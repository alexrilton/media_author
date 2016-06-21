<%-- 
    Document   : editTheme
    Created on : 17-jun-2016, 15:59:41
    Author     : Alex
--%>

<%@page import="Entities.Theme"%>
<%@page import="DAO.ThemeDAO"%>
<%@page import="Entities.Media"%>
<%@page import="DAO.MediaDAO"%>
<%@page import="Entities.Country"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Region"%>
<%@page import="DAO.CountryDAO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.RegionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Edit Theme</title>
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
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="theme.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
                <div class="title">Edit Theme</div>
                </br></br>
                <form id="simpleform" action="/Media_author/EditTheme" method="post">
                    <fieldset>
                        <legend>Theme</legend>
                        <div>
                            <label>Name:</label>
                            <select name="NAME_THEME_OLD"/>
                            <%
                                ThemeDAO theme = new ThemeDAO();
                                List<Theme> themes = new ArrayList();
                                themes = theme.listaTheme();
                                for (int k = 0; k < themes.size(); k++) {
                                    out.println("<option>");
                                    out.println(themes.get(k).getNameTheme());
                                    out.println("</option>");
                                }
                            %>
                            </select>
                        </div>
                    </fieldset>
                    </fieldset>
                    <fieldset>
                        <legend>New data</legend>
                        <div>
                            <label>Name:</label>
                            <input type="text" name="NAME_THEME" size="auto"/>
                        </div>
                    </fieldset>       
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'theme.jsp';"/>
                    <input class="button" type="submit" value="Edit" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
