(function(){
  var app = angular.module('Menu',[]);
  app.directive('mainMenu', function(){
    return {
      restrict: 'E',
      templateUrl:'HtmlTemplate/Menu/Menu.html',
      controller:function ($location){
          this.path=$location.path();
          
      },
       controllerAs: 'Url'
       
    };
  });
})();