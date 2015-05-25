/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author Francis
 */
@WebServlet(name = "AddBillet", urlPatterns = {"/API/AddBillet"})
public class AddBillet extends HttpServlet {

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
            String Nrep = request.getParameter("Nrep");
            String Nsec = request.getParameter("Nsec");
            String Qte = request.getParameter("Qte");
            HttpSession session = request.getSession(false);
            if(Nrep == null || Nsec == null || Qte == null)
            {
                response.sendRedirect("http://localhost:8084/Admission/Magasin.jsp");
            }
            else if(session == null)
            {
                response.sendRedirect("http://localhost:8084/Admission/Login.jsp");
            }
            else
            {
                Integer iQte = Integer.parseInt(Qte);
                
                Connection conn = null;
                CallableStatement stm;
                ResultSet rset;
                String Url = "jdbc:oracle:thin:@205.237.244.251:1521:orcl";
                String UName = "thibodea";
                String Pword = "ORACLE1";
                String sql = "{call AMINAPP.AJOUTERPANIER (?,?,?,?)}";
                
                try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection(Url,UName,Pword);
                    
                    if(conn !=null)
                    {
                        stm = conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        stm.setInt(1,Integer.parseInt( session.getAttribute("ID").toString()));
                        stm.setInt(2, Integer.parseInt( Nrep));
                        stm.setInt(3, Integer.parseInt( Nsec));
                        stm.setInt(4, Integer.parseInt( Qte));
                        stm.executeUpdate();
                        stm.clearParameters();
                        stm.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AddBillet.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                response.sendRedirect("http://localhost:8084/Admission/Magasin.jsp");
                
                 
                
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
