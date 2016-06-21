<%-- 
    Document   : editRegion
    Created on : 21-jun-2016, 17:02:15
    Author     : marce
--%>

<%@page import="Entities.Region"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DAO.RegionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Edit Region</title>
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
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="region.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
                <div class="title">Edit Region</div>
                </br></br>
                <form id="simpleform" action="/Media_author/EditRegion" method="post">
                    <fieldset>
                        <legend>Region</legend>
                        <div>
                            <label>Name:</label>
                            <select name="NAME_REGION_OLD"/>
                            <%
                                RegionDAO region = new RegionDAO();
                                List<Region> regions = new ArrayList();
                                regions = region.listaRegion();
                                for (int k = 0; k < regions.size(); k++) {
                                    out.println("<option>");
                                    out.println(regions.get(k).getNameRegion());
                                    out.println("</option>");
                                }
                            %>
                            </select>
                        </div>
                    </fieldset>
                     <fieldset>
                        <legend>New data</legend>
                        <div>
                            <label>Name:</label>
                            <input type="text" name="NAME_REGION" size="auto"/>
                        </div>
                    </fieldset>       
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'region.jsp';"/>
                    <input class="button" type="submit" value="Edit" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
