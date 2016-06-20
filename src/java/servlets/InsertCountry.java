/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.CountryDAO;
import DAO.RegionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */
//@WebServlet(name = "InsertCountry", urlPatterns = {"/InsertCountry"})
public class InsertCountry extends HttpServlet {

    private Object session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try {
            CountryDAO daoc = new CountryDAO();
            RegionDAO daor = new RegionDAO();
            String name_country = request.getParameter("NAME_COUNTRY");
            int id_region = daor.getRegionId(request.getParameter("NAME_REGION"));
            daoc.insertCountry(name_country, id_region);
            response.sendRedirect("/Media_author/country.jsp");
        } catch (Exception e) {
            pw.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
