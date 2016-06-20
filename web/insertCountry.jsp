<%-- 
    Document   : insertCountry
    Created on : 06-jun-2016, 15:56:24
    Author     : marce
--%>

<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Region"%>
<%@page import="DAO.RegionDAO"%>
<%@page import="java.util.List"%>
<%@page import="servlets.InsertCountry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Insert Country</title>
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
		<div class="title">Insert Country</div>
                </br></br>
                <form  id="simpleform" action="/Media_author/InsertCountry" method="post">
                    <fieldset>
                        <legend>Country</legend>
                        <div>
                            <label>Name:</label>
                            <input type="text" name="NAME_COUNTRY" size="auto"/>
                            </br>
                            <label>Region:</label>                            
                            <select name="NAME_REGION">
                             <%
                                    RegionDAO region = new RegionDAO();
                                    List<Region> regions = new ArrayList();
                                    regions = region.listaRegion();
                                    for (int i = 0; i < regions.size(); i++) {
                                        out.println("<option>");
                                        out.println(regions.get(i).getNameRegion());
                                        out.println("</option>");
                                    }
                            %>    
                            </select>
                        </div>
                    </fieldset>
                    <br>
                    <input class="button" type="reset" value="Clean" style="font-size: 16px;">
                    <input class="button" type="submit" value="Insert" style="font-size: 16px;">
                </form>	
            </div>
	</div>
        <br>
        <div id="footer"></div>
    </body>
</html>
