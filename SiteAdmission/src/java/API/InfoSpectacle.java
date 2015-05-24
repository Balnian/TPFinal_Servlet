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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Francis
 */
@WebServlet(name = "InfoSpectacle", urlPatterns = {"/API/InfoSpectacle"})
public class InfoSpectacle extends HttpServlet {

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
        
        String ID = request.getParameter("ID");

        Connection conn = null;
        PreparedStatement stm;
        ResultSet rset;
        String Url = "jdbc:oracle:thin:@205.237.244.251:1521:orcl";
        String UName = "thibodea";
        String Pword = "ORACLE1";
        String sql = "select s.NOMSPEC,s.IMAGEURL,cat.NOMCAT from Spectacles s inner join CATEGORIES cat on cat.NUMCAT = s.NUMCAT where s.numspec=?";
        try (PrintWriter out = response.getWriter()) {
            try {
                /* TODO output your page here. You may use following sample code. */

                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conn = DriverManager.getConnection(Url, UName, Pword);
                if (conn != null) {
                    stm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    stm.setString(1, ID);
                    rset = stm.executeQuery();
                    

                    rset.next();

                    out.print("{\n");
                    out.print("\"Nom\": \"" + rset.getString("NOMSPEC") + "\",\n");
                    out.print("\"Img\": \"" + rset.getString("IMAGEURL") + "\",\n");
                    out.print("\"Cat\": \"" + rset.getString("NOMCAT") + "\",\n");
                    out.print("\"Rep\": [\n");
                    try {
                        stm.clearParameters();
                       sql = "select r.NUMREP, r.LADATE, r.DISPONIBLE, sa.NOMSALLE, sa.ADRESSE  from representations r inner JOIN salles sa on r.NUMSALLE = sa.NUMSALLE where numspec = ?";

                        

                       
                        
                             stm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                             stm.setString(1, ID);
                             rset = stm.executeQuery();
                            

                            while (rset.next()) {

                                out.print("{\n");
                                out.print("\"ID\": " + rset.getInt("NUMREP") + ",\n");
                                out.print("\"Date\": \"" + rset.getDate("LADATE")+ "\",\n");
                                out.print("\"Time\": \"" + rset.getTimestamp("LADATE").getTime() + "\",\n");
                                out.print("\"Dispo\": \"" + rset.getString("DISPONIBLE") + "\",\n");
                                out.print("\"Nom\": \"" + rset.getString("NOMSALLE") + "\",\n");
                                out.print("\"Addr\": \"" + rset.getString("ADRESSE").replace('"', '\'') + "\"\n");
                                //out.print("\"Cat\": \"" + rset.getString("NOMCAT") + "\"\n");

                                if (rset.isLast()) {
                                    out.print("}\n");
                                } else {
                                    out.print("},\n");
                                }
                            }
                            out.print("]\n");
                        if(conn!=null)
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ListSpectacle.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    out.print("}\n");

                }
                if(conn!=null)
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ListSpectacle.class.getName()).log(Level.SEVERE, null, ex);
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
