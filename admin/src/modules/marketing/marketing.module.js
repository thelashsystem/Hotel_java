(function(){
    const module = angular.module('module.marketing', []);

    module.directive('maSendSms', function() {
        return {
            // E = element, A = attribute, C = class, M = comment
            restrict: 'EA',
            scope: {
                // @ reads the attribute value, = provides two-way binding, & works with functions
                entity: '&',
                selection: '&'
            },
            controller: function($scope, MarketingService) {
                $scope.sendSms = function() {
                    const names = $scope.selection().map(entry => entry.values.name).join(', ');

                    if (confirm('Send SMS to: ' + names)) {
                        const ids = $scope.selection().map(function (entry) {
                            return entry.identifierValue;
                        });

                        MarketingService.sendSms(ids).then(res => {
                            alert('Send SMS Successful!');
                        });
                    }
                };

                $scope.isShow = function() {
                    return $scope.selection().length;
                };
            },
            template: '<a class="btn btn-default btn-sm" ng-if="isShow()" ng-click="sendSms()"><span class="glyphicon glyphicon-phone" aria-hidden="true"></span>&nbsp;<span class="hidden-xs ng-scope">Send SMS</span></a>'
        };
    });

    module.config(function (NgAdminConfigurationProvider) {
        const nga = NgAdminConfigurationProvider;

        const marketing = nga.entity('marketing');

        const listView = marketing.listView();

        listView.url(function(entityId) {
            return 'mkt_customer';
        }).perPage(20);

        listView.fields([
            nga.field('name'),
            nga.field('phone_number', 'number'),
            nga.field('last_visit', 'date'),
            nga.field('birthday', 'date'),
            nga.field('image')
                .template('<img src="{{ entry.values.image }}" height="42" width="42" />'),
            nga.field('email', 'email'),
            nga.field('visit_count', 'number'),
            nga.field('amount_paid', 'number')
        ]);

        var template = '<ma-send-sms selection="selection" entity="entity"></ma-send-sms>';
        listView.actions(template);

        window.addEntity('marketing', marketing);
    });
})();
