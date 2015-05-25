/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){

  var app = angular.module('Panier', []);
  app.controller('PanierController',['$http','$scope',function($http,$scope){
       $scope.panier=[];
    $http.get('API/GetPanier').success(function(data){
      $scope.panier=data;
    });
  }]);
  /*app.controller('FiltreController',function(){
    this.
  });*/
})();


