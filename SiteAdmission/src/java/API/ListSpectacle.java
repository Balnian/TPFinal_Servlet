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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleDriver;
import java.sql.*;

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
        
        Connection conn=null; 
        Statement stm;
        ResultSet rset;
        String Url ="jdbc:oracle:thin:@205.237.244.251:1521:orcl";
        String UName = "thibodea";
        String Pword = "ORACLE1";
        try (PrintWriter out = response.getWriter()) {
            try {
                /* TODO output your page here. You may use following sample code. */
                
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                
                conn = DriverManager.getConnection(Url,UName,Pword);
                if(conn != null)
                {
                stm=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                rset = stm.executeQuery("select s.NUMSPEC,s.NOMSPEC,s.IMAGEURL,cat.NOMCAT from Spectacles s inner join CATEGORIES cat on cat.NUMCAT = s.NUMCAT");
                out.print("[\n");
    
                while(rset.next())
                {

                    out.print("{\n");
                    out.print("\"ID\": " + rset.getInt("NUMSPEC")+",\n");
                    out.print("\"Nom\": \""+rset.getString("NOMSPEC")+"\",\n");
                    out.print("\"Img\": \""+rset.getString("IMAGEURL")+"\",\n");
                    out.print("\"Cat\": \""+rset.getString("NOMCAT")+"\"\n");
                    
                   if(rset.isLast())
                    {
                        out.print("}\n");
                    }
                    else
                    {
                        out.print("},\n");
                   }
                }
                out.print("]");
                }
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
