/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Francis
 */
@WebServlet(name = "Login", urlPatterns = {"/API/Login"})
public class Login extends HttpServlet {

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
            String alias = request.getParameter("Alias");
            String pass = request.getParameter("Pass");
            if (alias == null || pass == null) {
                   response.sendRedirect("http://localhost:8084/Admission/Login.jsp");
            } else {

                Connection conn2 = null;
                PreparedStatement stm2;
                ResultSet rset2;
                String Url2 = "jdbc:oracle:thin:@205.237.244.251:1521:orcl";
                String UName2 = "thibodea";
                String Pword2 = "ORACLE1";
                String sql2 = "select count(NUMCOMPTE) as EXIST ,NUMCOMPTE from COMPTE where USERNAME=? and PASS=? group by NUMCOMPTE";

                try {
                    /* TODO output your page here. You may use following sample code. */

                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                    conn2 = DriverManager.getConnection(Url2, UName2, Pword2);
                    if (conn2 != null) {
                        stm2 = conn2.prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        stm2.setString(1, alias);
                        stm2.setString(2,pass);
                        rset2 = stm2.executeQuery();
                        

                        rset2.next();

                           if(rset2.isLast())
                           {
                               HttpSession session = request.getSession(true);
                               session.setAttribute("ID", rset2.getInt("NUMCOMPTE"));
                               response.sendRedirect("http://localhost:8084/Admission/Magasin.jsp");
                           }
                           else
                           {
                               response.sendRedirect("http://localhost:8084/Admission/Login.jsp");
                           }
                    conn2.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ListSpectacle.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
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
