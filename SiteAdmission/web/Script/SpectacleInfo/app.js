(function(){

  var app = angular.module('SpectInfo', []);
  app.controller('SpectInfoController',['$http',function($http){
      var Info=this;
    Info.Spectacles=[];
    $http.get('API/ListSpectacle').success(function(data){
      Info.Spectacles=data;
    });
  }]);
  /*app.controller('FiltreController',function(){
    this.
  });*/
})();
