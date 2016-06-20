<%-- 
    Document   : deleteAuthor
    Created on : 17-jun-2016, 15:59:41
    Author     : marce
--%>

<%@page import="Entities.Author"%>
<%@page import="DAO.AuthorDAO"%>
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
        <title>DARE-THINK: Delete Author</title>
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
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="author.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
                <div class="title">Delete Author</div>
                </br></br>
                <form id="simpleform" action="/Media_author/DeleteAuthor" method="post">
                    <fieldset>
                        <legend>Personal</legend>
                        <div>
                            <label>Name:</label>
                            <select name="NAME_AUTHOR"/>
                            <%
                                AuthorDAO author = new AuthorDAO();
                                List<Author> authors = new ArrayList();
                                authors = author.listaAuthor();
                                for (int k = 0; k < authors.size(); k++) {
                                    out.println("<option>");
                                    out.println(authors.get(k).getNameAuthor());
                                    out.println("</option>");
                                }
                            %>
                            </select>
                        </div>
                    </fieldset>
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'author.jsp';"/>
                    <input class="button" type="submit" value="Delete" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
