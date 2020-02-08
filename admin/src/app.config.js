(function() {
  angular
    .module('app.config', [])
    .config(function (NgAdminConfigurationProvider, $injector) {
      const nga = NgAdminConfigurationProvider;

      const app = nga.application('Lash Admin')
            .baseApiUrl('http://jsonplaceholder.typicode.com/'); // main API endpoint

      const { user } = window.entities;

      app.addEntity(user);

      app.menu(
        nga.menu()
          .addChild(nga.menu(user).icon('<span class="glyphicon glyphicon-user"></span>'))
      );

      nga.configure(app);
    });
})();
