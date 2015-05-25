<%-- 
    Document   : Login
    Created on : 2015-05-20, 05:20:13
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admission | Connection</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
        <script src="Script/Login/app.js"></script> 
    </head>
    <body ng-app="Login">
        <!-- menu -->
        <%@include file="HtmlTemplate/Menu/Menu.jsp" %>
        <!-- contenu -->
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-6 col-xs-offset-3">
                                <h1>Connection</h1>
                                <form name="myForm" ng-controller="LoginController" action="API/Login" method="POST" novalidate>
                            
                            <div class="form-group" ng-class="{'has-error has-feedback': myForm.input.$error.email }" >
                                <label class="control-label sr-only" for="courriel">Alias</label>
                                <input type="Text" name="Alias" ng-model="email.text" id="courriel" class="form-control input-lg" placeholder="Alias" aria-describedby="courriel2Status" required/>
                                <span class="glyphicon glyphicon-remove form-control-feedback" ng-show="myForm.input.$error.email" aria-hidden="true"></span>
                                <span id="courriel2Status" class="sr-only">Alias Invalide!</span>
                            </div>


                            <div class="form-group" ng-class="{'has-error has-feedback': myForm.Pass.$error.password }">
                                <label class="control-label sr-only" for="pass">Mot de passe</label>
                                <input type="password" name="Pass" id="pass" ng-model="pass.text"  class="form-control input-lg" placeholder="Mot de passe"  required/>
                                <span class="glyphicon glyphicon-remove form-control-feedback" ng-show="myForm.Pass.$error.password" aria-hidden="true"></span>
                                <span id="pass2Status" class="sr-only">Courriel Invalide!</span>


                            </div>

                            <button  type="submit" class="btn btn-primary center-block input-lg" ng-disabled="!myForm.$valid" >Connection</button>
                            
                        </form>
                                
                            </div>
                        </div>
                    </div>   

                </div>
            </div>
        </div>
    </body>
</html>
