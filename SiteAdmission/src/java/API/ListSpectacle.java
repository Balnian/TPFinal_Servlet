/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

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
public class ListSpectacle extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("{\n" +
"  \"Nom\": \"Spectacle1\",\n" +
"  \"Description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sed rutrum lorem, sagittis facilisis nulla. Donec finibus ultrices justo a.\",\n" +
"  \"Rep\": [\n" +
"    {\n" +
"      \"Nom\": \"place1\",\n" +
"      \"Adresse\": \"1234 Adresse1, ville1\",\n" +
"      \"Date\": \"2015-05-11\",\n" +
"      \"Heure\": \"18:12\"\n" +
"    },\n" +
"    {\n" +
"      \"Nom\": \"place1\",\n" +
"      \"Adresse\": \"1234 Adresse1, ville1\",\n" +
"      \"Date\": \"2015-05-12\",\n" +
"      \"Heure\": \"19:00\"\n" +
"    },\n" +
"    {\n" +
"      \"Nom\": \"place1\",\n" +
"      \"Adresse\": \"1234 Adresse1, ville1\",\n" +
"      \"Date\": \"2015-05-13\",\n" +
"      \"Heure\": \"18:00\"\n" +
"    },\n" +
"    {\n" +
"      \"Nom\": \"place2\",\n" +
"      \"Adresse\": \"1234 Adresse2, ville2\",\n" +
"      \"Date\": \"2015-05-11\",\n" +
"      \"Heure\": \"19:00\"\n" +
"    },\n" +
"    {\n" +
"      \"Nom\": \"place2\",\n" +
"      \"Adresse\": \"1234 Adresse2, ville2\",\n" +
"      \"Date\": \"2015-05-12\",\n" +
"      \"Heure\": \"19:00\"\n" +
"    },\n" +
"    {\n" +
"      \"Nom\": \"place2\",\n" +
"      \"Adresse\": \"1234 Adresse2, ville2\",\n" +
"      \"Date\": \"2015-05-13\",\n" +
"      \"Heure\": \"19:00\"\n" +
"    },\n" +
"    {\n" +
"      \"Nom\": \"place3\",\n" +
"      \"Adresse\": \"1234 Adresse3, ville3\",\n" +
"      \"Date\": \"2015-05-11\",\n" +
"      \"Heure\": \"19:00\"\n" +
"    },\n" +
"    {\n" +
"      \"Nom\": \"place3\",\n" +
"      \"Adresse\": \"1234 Adresse3, ville3\",\n" +
"      \"Date\": \"2015-05-12\",\n" +
"      \"Heure\": \"19:00\"\n" +
"    },\n" +
"    {\n" +
"      \"Nom\": \"place3\",\n" +
"      \"Adresse\": \"1234 Adresse3, ville3\",\n" +
"      \"Date\": \"2015-05-13\",\n" +
"      \"Heure\": \"19:00\"\n" +
"    }\n" +
"\n" +
"  ]\n" +
"\n" +
"}");
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
