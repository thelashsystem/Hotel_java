(function(){
    const module = angular.module('module.marketing', [
        'marketing.components.send-sms'
    ]);

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
