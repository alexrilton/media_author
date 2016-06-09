/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegionDAO;

/**
 *
 * @author alex
 */
public class InsertRegion extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertRegion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertRegion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                                 throws ServletException, IOException{
        response.setContentType("text/html");
    
        PrintWriter pw = response.getWriter();
        String connectionURL = "jdbc:mysql://127.0.0.1:3306/author_media";
        Connection connection;
        int i = 0;
        try{
            String name_region = request.getParameter("NAME_REGION");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "");
            RegionDAO dao = new RegionDAO();
            dao.insertRegion(name_region);
            i = 1;
            /*int i = 0;
            String name_region = request.getParameter("NAME_REGION");
            int j = 0;
            if(j==0){
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "");
            PreparedStatement pst = connection.prepareStatement("insert into region(NAME_REGION) values (?)");
            j++;
            pst.setString(1,name_region);
            i = pst.executeUpdate();
            }*/
            //pst.setString(1,name_region);
            //int i = pst.executeUpdate();
            if(/*j!=0 &&*/ i!=0){  
               pw.write("<br>Record has been inserted");
               response.sendRedirect("/Media_author/region.jsp");
                //j = 0;
                i = 0;
            }
            else{
                pw.println("failed to insert the data");
            }
        }
        catch (Exception e){
            pw.println(e);
        }
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