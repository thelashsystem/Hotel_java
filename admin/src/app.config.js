(function() {
  angular
    .module('app.config', [])
    .config(function($urlRouterProvider) {
      // $urlRouterProvider.otherwise('/');
    })
    .config(function($httpProvider) {
      $httpProvider.defaults.headers = {
	'Content-Type': 'application/json;charset=utf-8'
      };
      $httpProvider.interceptors.push('AuthInterceptor');
    })
    .config(function (NgAdminConfigurationProvider, $injector) {
      const nga = NgAdminConfigurationProvider;

      const app = nga.application('Lash Admin')
            .baseApiUrl(window.config.baseApiUrl); // main API endpoint

      const { marketing } = window.entities;

      app.addEntity(marketing);

      app.menu(
        nga.menu()
          .addChild(nga.menu(marketing).icon('<span class="glyphicon glyphicon-shopping-cart"></span>'))
          .addChild(nga.menu().title('Staff Services').link('/staff-services').icon('<span class="glyphicon glyphicon-calendar"></span>'))
          .addChild(nga.menu().title('Payment Manager').link('/payment-manager').icon('<span class="glyphicon glyphicon-euro"></span>'))
          .addChild(nga.menu().title('Payment Report').link('/payment-report').icon('<span class="glyphicon glyphicon-stats"></span>'))
          .addChild(nga.menu().title('Customer Report').link('/customer-report').icon('<span class="glyphicon glyphicon-equalizer"></span>'))
      );

      nga.configure(app);
    });
})();
