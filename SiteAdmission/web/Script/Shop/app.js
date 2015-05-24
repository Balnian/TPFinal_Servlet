(function(){

 
  var app = angular.module('SpectStore', []);
  app.controller('StoreController',['$scope', '$rootScope', '$http',function($scope,$rootScope,$http){
          var cont = this;
          $scope.info=[];
          $scope.catInclude=[];
          //$rootScope.ID=undefined;
    //this.Spectacles=[];
    $http.get('API/ListSpectacle').success(function(data){
      $scope.Spectacles=data;
    });
    $http.get('API/CategoList').success(function(data){
      $scope.Catlist=data;
    });
    $scope.choix = function(id){
       $rootScope.ID=id;
    };
    $rootScope.$watchCollection('MainSearch',function(newNames, oldNames) {
        $scope.dataCount = newNames.length;
    });
    //Gestion pour filtre catégorie
    $scope.includeCat = function(cat) {
        var i = $.inArray(cat, $scope.catInclude);
        if (i > -1) {
            $scope.catInclude.splice(i, 1);
        } else {
            $scope.catInclude.push(cat);
        }
    };
     $scope.catFilter = function(spec) {
         
        if ($scope.catInclude.length > 0) {
            if ($.inArray(spec.Cat, $scope.catInclude) < 0)
                return;
        }
        
        return spec;
    };
    
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
