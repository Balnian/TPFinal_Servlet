<%-- 
    Document   : Menu
    Created on : 2015-05-20, 04:55:48
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Admission</a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li ><a href="/Admission/Magasin.jsp">Billeterie</a></li>
                <li><a href="Magasin"> <span class="glyphicon glyphicon-shopping-cart"></span> Panier</a></li>

            </ul>
            
            <ul class="nav navbar-nav navbar-right">
                <%
                    
                    if(null != session.getAttribute("Connecter"))
                        out.write("<li><a href=\"#\"><span class=\"glyphicon glyphicon-log-out\"></span> Déconnection</a></li>");
                    else
                        out.write(
                                "<li><a href=\"SignUp.html\"><span class=\"glyphicon glyphicon-user\"></span> Créer un compte</a></li>"+
                                  "<li><a href=\"Login.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Connection</a></li>"
                                 );
                
                %>
            </ul>
        </div>
    </div>
</nav>
