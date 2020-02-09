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
                            text: 'Non diam phasellus vestibulum?'
                        },
                        {
                            id: 2,
                            img: 'assets/images/item-2.jpg',
                            text: 'Fermentum dui faucibus in!'
                        },
                        {
                            id: 3,
                            img: 'assets/images/item-1.jpg',
                            text: 'Convallis aenean et tortor?'
                        },
                        {
                            id: 4,
                            img: 'assets/images/item-2.jpg',
                            text: 'Tellus cras adipiscing enim?'
                        }
                    ]);
            },
            findEmployees: function() {
                return $http
                    .get(baseApiUrl + '/api/admin/list_employee')
                    .then(res => res.data)
                    .catch(err => [
                        { id: 1, name: 'Adam',      img: 'assets/images/item-1.jpg' },
                        { id: 2, name: 'Amalie',    img: 'assets/images/item-2.jpg' },
                        { id: 3, name: 'Estefanía', img: 'assets/images/item-1.jpg' },
                        { id: 4, name: 'Adrian',    img: 'assets/images/item-2.jpg' },
                        { id: 5, name: 'Wladimir',  img: 'assets/images/item-1.jpg' },
                        { id: 6, name: 'Samantha',  img: 'assets/images/item-2.jpg' },
                        { id: 7, name: 'Nicole',    img: 'assets/images/item-1.jpg' },
                        { id: 8, name: 'Natasha',   img: 'assets/images/item-2.jpg' },
                        { id: 9, name: 'Michael',   img: 'assets/images/item-1.jpg' }
                    ]);
            },
            findAvailableTimeOfEmployee: function(id) {
                return $http
                    .get('http://server/findAvailableTimeOfEmployee?id=' + id)
                    .then(res => res.data)
                    .catch(err => ({
                        [moment(new Date()).valueOf()]: [1 ,3, 5],
                        [moment(new Date()).add(1, 'days').valueOf()]: [12, 20],
                    }));
            },
        };
    }
})();
