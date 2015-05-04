/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Francis
 */
public class SpectacleInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html ng-app=\"SpectInfo\" ng-controller=\"SpectInfoController as infos\">\n" +
"<head>\n" +
"  <title>Admission | {{infos.Spectacles.Nom}}</title>\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n" +
"  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n" +
"  <script src=\"http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js\"></script>\n" +
"  <script src=\"Script/SpectacleInfo/app.js\"></script>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"  <nav class=\"navbar navbar-default\">\n" +
"    <div class=\"container\">\n" +
"      <div class=\"navbar-header\">\n" +
"        <a class=\"navbar-brand\" href=\"#\">Admission</a>\n" +
"      </div>\n" +
"      <div>\n" +
"        <ul class=\"nav navbar-nav\">\n" +
"          <li class=\"active\"><a href=\"index.html\">Accueil</a></li>\n" +
"          <li><a href=\"Shop.html\">Billeterie</a></li>\n" +
"          <li><a href=\"#\">Page 2</a></li>\n" +
"          <li><a href=\"#\">Page 3</a></li>\n" +
"        </ul>\n" +
"      </div>\n" +
"    </div>\n" +
"  </nav>\n" +
"  <div class=\"container\">\n" +
"    <div class=\"panel panel-primary\">\n" +
"      <div class=\"panel-heading\">\n" +
"        <div class=\"panel-title\">{{infos.Spectacles.Nom}}</div>\n" +
"      </div>\n" +
"      <div class=\"panel-body\">\n" +
"        <!-- En-tête Spectacle -->\n" +
"        <div class=\"jumbotron\">\n" +
"          <div class=\"row\">\n" +
"          <div class=\"col-xs-12 col-md-4\">\n" +
"            <img src=\"Images/placeholder.jpg\" class=\"img-responsive\" alt=\"...\">\n" +
"          </div>\n" +
"          <div class=\"col-xs-12 col-md-8\">\n" +
"            <p>{{infos.Spectacles.Description}}</p>\n" +
"          </div>\n" +
"        </div>\n" +
"        </div>\n" +
"        <hr/>\n" +
"        <!-- Filtre Btn-->\n" +
"        <a class=\"btn btn-default\" data-toggle=\"collapse\" href=\"#filtre\" aria-expanded=\"false\" aria-controls=\"collapseExample\">\n" +
"          Filtre <span class=\"glyphicon glyphicon-filter\"></span>\n" +
"        </a>\n" +
"        <!-- Filtre -->\n" +
"        <div class=\"collapse\" id=\"filtre\">\n" +
"          <div class=\"well\">\n" +
"            <!-- Recherche -->\n" +
"\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"Recherche\">Recherche:</label>\n" +
"              <input type=\"text\" class=\"form-control\" placeholder=\"Place, Date ou Heure\" ng-model=\"search.$\"/>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"Recherche Place\">Place:</label>\n" +
"              <input type=\"text\" class=\"form-control\" placeholder=\"Place\" ng-model=\"search.Nom\"/>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"Recherche Date\">Date:</label>\n" +
"              <input type=\"text\" class=\"form-control\" placeholder=\"Date\" ng-model=\"search.Date\"/>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"Recherche Heure\">Heure:</label>\n" +
"              <input type=\"text\" class=\"form-control\" placeholder=\"Heure\" ng-model=\"search.Heure\"/>\n" +
"            </div>\n" +
"            <!-- Filtre Croissant/Decroissant -->\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"Filtre Place\">Place:</label>\n" +
"              <div class=\"btn-group\" role=\"group\" aria-label=\"...\">\n" +
"                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-sort-by-attributes\"></span></button>\n" +
"                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-remove\"></span></button>\n" +
"                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-sort-by-attributes-alt\"></span></button>\n" +
"              </div>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"Filtre Date\">Date: </label>\n" +
"              <div class=\"btn-group\" role=\"group\" aria-label=\"...\">\n" +
"                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-sort-by-attributes\"></span></button>\n" +
"                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-remove\"></span></button>\n" +
"                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-sort-by-attributes-alt\"></span></button>\n" +
"              </div>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"Filtre Heure\">Heure:</label>\n" +
"              <div class=\"btn-group\" role=\"group\" aria-label=\"...\">\n" +
"                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-sort-by-attributes\"></span></button>\n" +
"                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-remove\"></span></button>\n" +
"                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-sort-by-attributes-alt\"></span></button>\n" +
"              </div>\n" +
"            </div>\n" +
"\n" +
"\n" +
"          </div>\n" +
"        </div>\n" +
"        <!-- Horraire Spectacle -->\n" +
"        <table class=\"table\">\n" +
"          <thead>\n" +
"            <tr>\n" +
"              <th >Place </th>\n" +
"              <th >Date</th>\n" +
"              <th >Heure</th>\n" +
"              <th></th>\n" +
"            </tr>\n" +
"          </thead>\n" +
"          <tbody  >\n" +
"          <tr ng-repeat=\"place in infos.Spectacles.Rep | filter:search\">\n" +
"            <td> <strong>{{place.Nom | uppercase}}</strong></td>\n" +
"            <td> {{place.Date}}</td>\n" +
"            <td> {{place.Heure}}</td>\n" +
"            <td>\n" +
"            <a class=\"btn btn-warning btn-center\"><span class=\"glyphicon glyphicon-shopping-cart\"></span> Ajouter au panier</a>\n" +
"            </td>\n" +
"          </tr>\n" +
"        </tbody>\n" +
"        </table>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"    </div>\n" +
"  </div>\n" +
"</body>\n" +
"\n" +
"</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
