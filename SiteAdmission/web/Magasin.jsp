<%-- 
    Document   : Magasin
    Created on : 2015-05-20, 04:48:27
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Admission | Magasin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
  <script src="Script/Shop/app.js"></script> 
</head>

<body   ng-app="SpectStore">
    <!-- Menu -->
<%@include file="HtmlTemplate/Menu/Menu.jsp" %>
<!-- Contenu -->
<div class="container" ng-controller="StoreController as store" >
      <div class="row" >
         <!-- Filtre Btn-->
        <div class="row">
        <div class="col-xs-10 col-xs-offset-1">
        <div class="form-group">
            <label for="Recherche">Recherche:</label>
            <div class="input-group ">
              
              <input type="text" class="form-control" placeholder="Place, Date ou Heure" ng-model="MainSearch.$"/>
              <span class="input-group-btn">
                  <a class="btn btn-default" data-toggle="collapse" href="#mainfiltre" aria-expanded="false" aria-controls="collapseExample">
                      Filtre <span class="glyphicon glyphicon-filter"></span>
                  </a>            
              </span>
            </div>
        </div>
        </div>
        </div>
        <!-- Filtre -->
        <div class="collapse" id="mainfiltre">
          <div class="well">
            <!-- Recherche -->

            
            <div class="form-group">
              <label for="Recherche Place">Place:</label>
              <input type="text" class="form-control" placeholder="Place" ng-model="MainSearch.Nom"/>
            </div>
            <div class="form-group">
              <label for="Recherche Date">Date:</label>
              <input type="text" class="form-control" placeholder="Date" ng-model="search.Date"/>
            </div>
            <div class="form-group">
              <label for="Recherche Heure">Heure:</label>
              <input type="text" class="form-control" placeholder="Heure" ng-model="search.Heure"/>
            </div>
            <!-- Filtre Croissant/Decroissant -->
            <div class="form-group">
              <label for="Filtre Place">Place:</label>
              <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></button>
              </div>
            </div>
            <div class="form-group">
              <label for="Filtre Date">Date: </label>
              <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></button>
              </div>
            </div>
            <div class="form-group">
              <label for="Filtre Heure">Heure:</label>
              <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></button>
              </div>
            </div>


          </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3" ng-repeat="Spectacle in Spectacles | filter:MainSearch">

          <div class="thumbnail">
              <img ng-src="{{Spectacle.Img}}">
            <img src="Images/placeholder.jpg"  alt="...">
            <div class="caption">
              <h3>{{Spectacle.Nom}}</h3>
              <h4>Catégorie: <small>{{Spectacle.Cat}}</small></h4>
              <button type="button" ng-click="choix(Spectacle.ID)" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Large modal</button>
              <p><a href="#" class="btn btn-primary" role="button">Voir les représentation...</a> </p>
            </div>
          </div>
        </div>
    </div>
          <!-- Large modal -->
        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
              <div class="modal-content" ng-controller="SpectInfoController">
                <!-- En-tête Spectacle -->
        <div class="jumbotron">
          <div class="row">
          <div class="col-xs-12 col-md-4">
            <img src="Images/placeholder.jpg" class="img-responsive" alt="...">
          </div>
          <div class="col-xs-12 col-md-8">
              <h2>{{Spectacles.Nom}}
            <p>{{Spectacles.Cat}}</p>
          </div>
        </div>
        </div>
        <hr/>
        <!-- Filtre Btn-->
        <div class="row">
        <div class="col-xs-10 col-xs-offset-1">
        <div class="form-group">
            <label for="Recherche">Recherche:</label>
            <div class="input-group ">
              
              <input type="text" class="form-control" placeholder="Place, Date ou Heure" ng-model="search.$"/>
              <span class="input-group-btn">
                  <a class="btn btn-default" data-toggle="collapse" href="#filtre" aria-expanded="false" aria-controls="collapseExample">
                      Filtre <span class="glyphicon glyphicon-filter"></span>
                  </a>            
              </span>
            </div>
        </div>
        </div>
        </div>
        <!-- Filtre -->
        <div class="collapse" id="filtre">
          <div class="well">
            <!-- Recherche -->

            
            <div class="form-group">
              <label for="Recherche Place">Place:</label>
              <input type="text" class="form-control" placeholder="Place" ng-model="search.Nom"/>
            </div>
            <div class="form-group">
              <label for="Recherche Date">Date:</label>
              <input type="text" class="form-control" placeholder="Date" ng-model="search.Date"/>
            </div>
            <div class="form-group">
              <label for="Recherche Heure">Heure:</label>
              <input type="text" class="form-control" placeholder="Heure" ng-model="search.Heure"/>
            </div>
            <!-- Filtre Croissant/Decroissant -->
            <div class="form-group">
              <label for="Filtre Place">Place:</label>
              <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></button>
              </div>
            </div>
            <div class="form-group">
              <label for="Filtre Date">Date: </label>
              <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></button>
              </div>
            </div>
            <div class="form-group">
              <label for="Filtre Heure">Heure:</label>
              <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button>
                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></button>
              </div>
            </div>


          </div>
        </div>
        <!-- Horraire Spectacle -->
        <table class="table">
          <thead>
            <tr>
              <th >Place </th>
              <th >Date</th>
              <th> Heure </th>
              <th >Adresse</th>
              <th></th>
            </tr>
          </thead>
          <tbody  >
          <tr ng-repeat="place in Spectacles.Rep | filter:search">
            <td> <strong>{{place.Nom | uppercase}}</strong></td>
            <td> {{place.Date }}</td>
            <td> {{place.Time|date:'shortTime'}}</td>
            <td> {{place.Addr}}</td>
            <td>
            <a class="btn btn-warning btn-center"><span class="glyphicon glyphicon-shopping-cart"></span> Ajouter au panier</a>
            </td>
          </tr>
        </tbody>
        </table>
              </div>
            </div>
        </div>

      
  </div>
</body>

</html>
