(function(){

  var Spectacle = {
    Nom:'Spectacle1',
    Description:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sed rutrum lorem, sagittis facilisis nulla. Donec finibus ultrices justo a.",
    Rep:[
      {
        Nom:'place1',
        Adresse:'1234 Adresse1, ville1',
        Date:'2015-05-11',
        Heure:'18:12',
      },
      {
        Nom:'place1',
        Adresse:'1234 Adresse1, ville1',
        Date:'2015-05-12',
        Heure:'19:00',
      },
      {
        Nom:'place1',
        Adresse:'1234 Adresse1, ville1',
        Date:'2015-05-13',
        Heure:'18:00',
      },
      {
        Nom:'place2',
        Adresse:'1234 Adresse2, ville2',
        Date:'2015-05-11',
        Heure:'19:00',
      },
      {
        Nom:'place2',
        Adresse:'1234 Adresse2, ville2',
        Date:'2015-05-12',
        Heure:'19:00',
      },
      {
        Nom:'place2',
        Adresse:'1234 Adresse2, ville2',
        Date:'2015-05-13',
        Heure:'19:00',
      },
      {
        Nom:'place3',
        Adresse:'1234 Adresse3, ville3',
        Date:'2015-05-11',
        Heure:'19:00',
      },
      {
        Nom:'place3',
        Adresse:'1234 Adresse3, ville3',
        Date:'2015-05-12',
        Heure:'19:00',
      },
      {
        Nom:'place3',
        Adresse:'1234 Adresse3, ville3',
        Date:'2015-05-13',
        Heure:'19:00',
      },

    ]

  }
  ;

  var app = angular.module('SpectInfo', []);
  app.controller('SpectInfoController',['$http',function($http){
      var Info=this;
    Info.Spectacles=[];
    $http.jsonp('Data/SpectacleInfo.json').success(function(data){
      Info.Spectacles=data;
    });
  }]);
  /*app.controller('FiltreController',function(){
    this.
  });*/
})();
