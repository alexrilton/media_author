<%-- 
    Document   : editSpeciality
    Created on : 21-jun-2016, 17:02:44
    Author     : marce
--%>

<%@page import="Entities.Theme"%>
<%@page import="DAO.ThemeDAO"%>
<%@page import="Entities.Speciality"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DAO.SpecialityDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Edit Speciality</title>
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
                <div class="title">Edit Speciality</div>
                </br></br>
                <form id="simpleform" action="/Media_author/EditSpeciality" method="post">
                    <fieldset>
                        <legend>Speciality</legend>
                        <div>
                            <label>Name:</label>
                            <select name="NAME_SPEC_OLD"/>
                            <%
                                SpecialityDAO speciality = new SpecialityDAO();
                                List<Speciality> specialities = new ArrayList();
                                specialities = speciality.listaSpeciality();
                                for (int k = 0; k < specialities.size(); k++) {
                                    out.println("<option>");
                                    out.println(specialities.get(k).getNameSpec());
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
                            <input type="text" name="NAME_SPEC" size="auto"/>
                        </div>
                        <div>                             
                            <label>Theme:</label>
                            <select name="NAME_THEME">
                                <%
                                    ThemeDAO theme = new ThemeDAO();
                                    List<Theme> themes = new ArrayList();
                                    themes = theme.listaTheme();
                                    for (int i = 0; i < themes.size(); i++) {
                                        out.println("<option>");
                                        out.println(themes.get(i).getNameTheme());
                                        out.println("</option>");
                                    }
                                %>    
                            </select>
                        </div>
                    </fieldset>       
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'speciality.jsp';"/>
                    <input class="button" type="submit" value="Edit" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
