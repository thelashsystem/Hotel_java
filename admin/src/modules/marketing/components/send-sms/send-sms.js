(function(){
    const module = angular.module('marketing.components.send-sms', []);

    module.directive('maSendSms', function() {
        return {
            // E = element, A = attribute, C = class, M = comment
            restrict: 'EA',
            scope: {
                // @ reads the attribute value, = provides two-way binding, & works with functions
                entity: '&',
                selection: '&'
            },
            controller: function($scope, $uibModal, MarketingService) {
                $scope.message = '';

                $scope.showModal = function() {
                    $scope.names = $scope.selection().map(entry => entry.values.name).join(', ');

                    $scope.modal = $uibModal.open({
                        animation: true,
                        templateUrl: 'sendSmsModal.html',
                        size: 'md',
                        scope: $scope
                    });

                };

                $scope.send = function() {
                    if (confirm('Send SMS to: ' + $scope.names)) {
                        const ids = $scope.selection().map(function (entry) {
                            return entry.identifierValue;
                        });

                        MarketingService.sendSms(ids, $scope.message).then(res => {
                            alert('Send SMS Successful!');

                            $scope.modal.close();
                        });
                    }
                };

                $scope.cancel = function() {
                    $scope.modal.close();
                };

                $scope.isShow = function() {
                    return $scope.selection().length;
                };
            },
            templateUrl: 'src/modules/marketing/components/send-sms/send-sms.html'
        };
    });
})();
