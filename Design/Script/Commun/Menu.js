(function(){
  var app = angular.module('Menu',[]);
  app.directive('mainMenu', function(){
    return {
      restrict: 'E',
      templateUrl:'Template/Menu.html'
    };
  });
})();
