(function(){

 
  var app = angular.module('SpectStore', []);
  app.controller('StoreController',['$scope', '$rootScope', '$http',function($scope,$rootScope,$http){
          var cont = this;
          $scope.info=[];
          $scope.MainSearch=undefined;
          //$rootScope.ID=undefined;
    //this.Spectacles=[];
    $http.get('API/ListSpectacle').success(function(data){
      $scope.Spectacles=data;
    });
    $scope.choix = function(id){
       $rootScope.ID=id;
    };
    $rootScope.$watchCollection('MainSearch',function(newNames, oldNames) {
        $scope.dataCount = newNames.length;
    });
  }]);
  
  app.controller('SpectInfoController',['$scope','$rootScope','$http',function($scope,$rootScope,$http){
      
    $scope.Spectacles=[];
    $rootScope.$watch('ID',function(newValue, oldValue){
        if(!angular.isUndefined(newValue))
            $http.get('API/InfoSpectacle',{params:{ID:$scope.ID}}).success(function(data){                
                $scope.Spectacles=data;
            });
    });
   
    /**/
  }]);
})();
