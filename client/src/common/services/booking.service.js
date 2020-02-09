(function() {
    angular.module('service.booking', [])
        .factory('BookingService', BookingService);

    function BookingService($http) {
        const baseApiUrl = 'http://f486ba53.ngrok.io';

        return {
            findServices: function() {
                return $http
                    .get(baseApiUrl + '/api/admin/list_services')
                    .then(res => res.data)
                    .catch(err => [
                        {
                            id: 1,
                            img: 'assets/images/item-1.jpg',
                            name: 'Non diam phasellus vestibulum?',
                            stepping: 30
                        },
                        {
                            id: 2,
                            img: 'assets/images/item-2.jpg',
                            name: 'Fermentum dui faucibus in!',
                            stepping: 15
                        },
                        {
                            id: 3,
                            img: 'assets/images/item-1.jpg',
                            name: 'Convallis aenean et tortor?',
                            stepping: 10
                        },
                        {
                            id: 4,
                            img: 'assets/images/item-2.jpg',
                            name: 'Tellus cras adipiscing enim?',
                            stepping: 20
                        }
                    ]);
            },
            findEmployees: function() {
                return $http
                    .get(baseApiUrl + '/api/admin/list_employee')
                    .then(res => res.data)
                    .catch(err => [
                        {
                            id: 1,
                            name: 'Adam',
                            img: 'assets/images/item-1.jpg',
                            service_id: 1,
                            available: {
                                [moment(new Date()).valueOf()]: [
                                    {
                                        start: moment(new Date()).valueOf(),
                                        end: moment(new Date()).add(6, 'hours').valueOf()
                                    }
                                ]
                            }
                        },
                        {
                            id: 2,
                            name: 'Amalie',
                            img: 'assets/images/item-2.jpg',
                            service_id: 2,
                            available: {
                                [moment(new Date()).valueOf()]: [
                                    {
                                        start: moment(new Date()).valueOf(),
                                        end: moment(new Date()).add(6, 'hours').valueOf()
                                    }
                                ]
                            }
                        },
                        {
                            id: 3,
                            name: 'Estefanía',
                            img: 'assets/images/item-1.jpg',
                            service_id: 1,
                            available: {
                                [moment(new Date()).valueOf()]: [
                                    {
                                        start: moment(new Date()).valueOf(),
                                        end: moment(new Date()).add(6, 'hours').valueOf()
                                    }
                                ]
                            }
                        },
                        {
                            id: 4,
                            name: 'Adrian',
                            img: 'assets/images/item-2.jpg',
                            service_id: 3,
                            available: {
                                [moment(new Date()).valueOf()]: [
                                    {
                                        start: moment(new Date()).valueOf(),
                                        end: moment(new Date()).add(6, 'hours').valueOf()
                                    }
                                ]
                            }
                        },
                        {
                            id: 5,
                            name: 'Wladimir',
                            img: 'assets/images/item-1.jpg',
                            service_id: 4,
                            available: {
                                [moment(new Date()).valueOf()]: [
                                    {
                                        start: moment(new Date()).valueOf(),
                                        end: moment(new Date()).add(6, 'hours').valueOf()
                                    }
                                ]
                            }
                        }
                    ]);
            }
        };
    }
})();
