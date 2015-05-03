(function(){

  var Spectacle = {
    Nom:'Spectacle1',
    Description:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sed rutrum lorem, sagittis facilisis nulla. Donec finibus ultrices justo a.",
    /*Rep:[
      {
        Nom:'place1',
        Adresse:'1234 Adresse1, ville1',
        Date:'2015-05-11',
        Heure:'19:00',
      }
    ],*/
    Lieu:[
      {
        id:1,
        Nom:'place1',
        Adresse:'1234 Adresse1, ville1',
        DateHeure:[{
          Date:'2015-05-11',
          Heure:'19:00'
        },
        {
          Date:'2015-05-12',
          Heure:'19:00'
        },
        {
          Date:'2015-05-13',
          Heure:'19:00'
        }
        ],
        Sections:[{
          Nom:'SectionA',
          Prix:60.99,
          NbPlaces:50
        },
        {
          Nom:'SectionB',
          Prix:70.99,
          NbPlaces:50
        },
        {
          Nom:'SectionC',
          Prix:80.99,
          NbPlaces:50
        }
        ]
      },
      {
        id:2,
        Nom:'place2',
        Adresse:'1234 Adresse2, ville2',
        DateHeure:[{
          Date:'2015-05-11',
          Heure:'19:00'
        },
        {
          Date:'2015-05-12',
          Heure:'19:00'
        },
        {
          Date:'2015-05-13',
          Heure:'19:00'
        }
        ],
        Sections:[{
          Nom:'SectionA',
          Prix:60.99,
          NbPlaces:50
        },
        {
          Nom:'SectionB',
          Prix:70.99,
          NbPlaces:50
        },
        {
          Nom:'SectionC',
          Prix:80.99,
          NbPlaces:50
        }
        ]
      },
      {
        id:3,
        Nom:'place3',
        Adresse:'1234 Adresse3, ville3',
        DateHeure:[{
          Date:'2015-05-11',
          Heure:'19:00'
        },
        {
          Date:'2015-05-12',
          Heure:'19:00'
        },
        {
          Date:'2015-05-13',
          Heure:'19:00'
        }
        ],
        Sections:[{
          Nom:'Section Bronze',
          Prix:60.99,
          NbPlaces:50
        },
        {
          Nom:'Section Argent',
          Prix:70.99,
          NbPlaces:50
        },
        {
          Nom:'Section Or',
          Prix:80.99,
          NbPlaces:50
        }
        ]
      }

    ]
  }
  ;

  var app = angular.module('SpectInfo', []);
  app.controller('SpectInfoController',function(){
    this.Spectacles=Spectacle;
  });
})();
