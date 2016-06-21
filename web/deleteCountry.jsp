<%-- 
    Document   : deleteCountry
    Created on : 21-jun-2016, 16:13:18
    Author     : marce
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entities.Country"%>
<%@page import="DAO.CountryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Delete Country</title>
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
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="country.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
                <div class="title">Delete Country</div>
                </br></br>
                <form id="simpleform" action="/Media_author/DeleteCountry" method="post">
                    <fieldset>
                        <legend>Country</legend>
                        <div>
                            <label>Name:</label>
                            <select name="NAME_COUNTRY"/>
                            <%
                                CountryDAO country = new CountryDAO();
                                List<Country> countries = new ArrayList();
                                countries = country.listaCountry();
                                for (int k = 0; k < countries.size(); k++) {
                                    out.println("<option>");
                                    out.println(countries.get(k).getNameCountry());
                                    out.println("</option>");
                                }
                            %>
                            </select>
                        </div>
                    </fieldset>
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'country.jsp';"/>
                    <input class="button" type="submit" value="Delete" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
