<%-- 
    Document   : deleteSpeciality
    Created on : 21-jun-2016, 16:33:57
    Author     : marce
--%>

<%@page import="Entities.Speciality"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DAO.SpecialityDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Delete Speciality</title>
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
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="speciality.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
                <div class="title">Delete Speciality</div>
                </br></br>
                <form id="simpleform" action="/Media_author/DeleteSpeciality" method="post">
                    <fieldset>
                        <legend>Speciality</legend>
                        <div>
                            <label>Name:</label>
                            <select name="NAME_SPEC"/>
                            <%
                                SpecialityDAO speciality = new SpecialityDAO();
                                List<Speciality> specialities = new ArrayList();
                                specialities = speciality.listaSpecialityRef();
                                for (int k = 0; k < specialities.size(); k++) {
                                    out.println("<option>");
                                    out.println(specialities.get(k).getNameSpec());
                                    out.println("</option>");
                                }
                            %>
                            </select>
                        </div>
                    </fieldset>
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'speciality.jsp';"/>
                    <input class="button" type="submit" value="Delete" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
