<%-- 
    Document   : Panier
    Created on : 2015-05-20, 07:15:41
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admission | Panier</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
        <script src="Script/Login/app.js"></script> 
    </head>
    <body>
        <%@include file="HtmlTemplate/Menu/Menu.jsp" %>
        <div classs="container">
            <table class='table'>
                <tr ng-repeat="">
                    <td>{{}}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
