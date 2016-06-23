<%-- 
    Document   : telaInicial
    Created on : 23/05/2016, 15:55:23
    Author     : alex
--%>
<%@page import="DAO.CountryDAO"%>
<c:if test="condition">
    <%@page import="java.sql.*" %>
    <%
        Class.forName("com.mysql.jdbc.Driver");
        CountryDAO country = new CountryDAO();
        country.conectar();
        Statement Estamento = country.connection.createStatement();
    %>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>DARE-THINK: Country</title>
            <link rel='stylesheet' href='style.css' type='text/css'>
        </head>
        <body>

            <div id="header1">
                <div class="logo"><a href="home.jsp"><img id="logo" src="img/medthor.png" alt="pinguim" /></a></div>
            </div>
            <div id="header2"></div>
            <br>
            <div id="mainbody">
                <div class="content" style="width:25%; float:left">
                    <div class="title">Menu</div>
                    <ul>
                        <li><a href="insertCountry.jsp">Insert Country</a></li>
                        <li><a href="editCountry.jsp">Edit Country</a></li>
                        <li><a href="deleteCountry.jsp">Delete Country</a></li>
                        <li><a href="searchCountry.jsp">Search Country</a></li>
                        <li><a href="region.jsp">Region</a></li>
                        <li style="border-bottom: 5px solid #dfdfdf"><a href="home.jsp">Back</a></li>
                    </ul>         
                </div>
                <div class="content" style="width:70%; float:right; margin-right: 7px">
                    <div class="title">Country</div>
                    <br>
                    <div class="table">
                        <%
                            ResultSet rs = Estamento.executeQuery("SELECT REGION, COUNTRY FROM  regions_countries");
                            out.println("<table border=1>");
                            out.println("<tr><th>COUNTRY</th><th>REGION</th></tr>");
                            while (rs.next()) {
                                out.println("<tr>");
                                out.println("<td>");
                                out.println(rs.getString("COUNTRY"));
                                out.println("</td><td>");
                                out.println(rs.getString("REGION"));
                                out.println("</td>");
                                out.println("</tr>");
                            }
                            out.println("</table>");
                            rs.close();
                            Estamento.close();
                            country.connection.close();
                        %>
                    </div>
                </div>
            </div>
            <br>
            <div id="footer"></div>
        </body>
    </html>
</c:if>
