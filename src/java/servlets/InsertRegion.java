/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                                 throws ServletException, IOException{
        response.setContentType("text/html");
    
        PrintWriter pw = response.getWriter();
        try{
            String name_region = request.getParameter("NAME_REGION");
            RegionDAO dao = new RegionDAO();
            dao.insertRegion(name_region);
            dao.connection.close();
            response.sendRedirect("/Media_author/region.jsp");
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
