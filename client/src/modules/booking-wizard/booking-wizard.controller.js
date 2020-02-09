(function(){
    angular.module('module.booking-wizard.controller', [])
        .controller('BookingWizardController', BookingWizardController)
        .filter('propsFilter', function() {
            return function(items, props) {
                var out = [];

                if (angular.isArray(items)) {
                    var keys = Object.keys(props);

                    items.forEach(function(item) {
                        var itemMatches = false;

                        for (var i = 0; i < keys.length; i++) {
                            var prop = keys[i];
                            var text = props[prop].toLowerCase();
                            if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
                                itemMatches = true;
                                break;
                            }
                        }

                        if (itemMatches) {
                            out.push(item);
                        }
                    });
                } else {
                    out = items;
                }

                return out;
            };
        });

    function BookingWizardController($scope, $timeout, BookingService) {
        $scope.loading = false;

        $scope.util = {
            keys: Object.keys,
            toInt: s => +s,
            toMoment: s => moment(+s),
        };

        $scope.step = 1;
        $scope.maxStep = 5;

        $scope.services = [];
        $scope.servicesMap = {};

        $scope.employees = [];
        $scope.employeesMap = {};

        $scope.$watch('services', function(newValue, oldValue) {
            $scope.servicesMap = newValue.reduce((result, item) => {
                return {
                    ...result,
                    [item.id]: item
                };
            }, {});
        });

        $scope.$watch('employees', function(newValue, oldValue) {
            $scope.employeesMap = newValue.reduce((result, item) => {
                return {
                    ...result,
                    [item.id]: item
                };
            }, {});
        });

        $scope.availableTimes = {};

        $scope.form = {
            info: {
                name: 'Fermentum',
                phone: '0123456789'
            },
            confirm: {
                term: false,
                cookie: false
            },
            services: {}
        };

        $scope.setStep = function(step) {
            switch (step) {
            case 2: {
                $scope.loading = true;

                BookingService.findServices().then(services => {
                    $scope.services = services;
                    $scope.form.services = $scope.services.reduce((result, item) => {
                        return {
                            ...result,
                            [item.id]: {
                                active: false
                            }
                        };
                    }, {});

                    $timeout(() => {
                        $scope.loading = false;
                        $scope.step = step;
                    });
                });
                break;
            }

            case 3: {
                $scope.loading = true;

                BookingService.findEmployees().then(employees => {
                    $scope.employees = employees;

                    $timeout(() => {
                        $scope.loading = false;
                        $scope.step = step;
                    });
                });
                break;
            }

            case 4: {
                $scope.loading = true;

                const employeeIds = Object.values($scope.form.services)
                      .filter(item => item.active)
                      .map(item => item.employeeId);

                employeeIds.forEach(id => {
                    $scope.availableTimes[id] = $scope.employeesMap[id].available;
                });

                $scope.loading = false;
                $scope.step = step;

                break;
            }
            default: {
                $scope.loading = false;
                $scope.step = step;
            }
            }
        };

        $scope.nextStep = function() {
            $scope.setStep(Math.min($scope.step + 1, $scope.maxStep));
        };

        $scope.prevStep = function() {
            $scope.setStep(Math.max($scope.step - 1, 1));
        };

        $scope.done = function() {
            console.log($scope.form);
        };

        $scope.validateNext = function() {
            return $scope.step === $scope.maxStep;
        };

        $scope.disableNext = function(form, step=$scope.step) {
            switch (step) {
            case 1: {
                return !(form.name.$valid && form.phone.$valid);
            }

            case 2: {
                return Object.values($scope.form.services).every(item => !item.active);
            }

            case 3: {
                return Object.values($scope.form.services).filter(item => item.active).some(item => !item.employeeId);
            }

            case 4: {
                return false;
            }

            case 5: {
                return !($scope.form.confirm.term && $scope.form.confirm.cookie);
            }

            default: {
                return false;
            }
            }
        };
    }
})();
