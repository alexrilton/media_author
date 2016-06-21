<%-- 
    Document   : telaInicial
    Created on : 23/05/2016, 15:55:23
    Author     : alex
--%>
<%@page import="DAO.AuthorDAO"%>
<%@page import="darethink.database_connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<c:if test="condition">
    <%
        AuthorDAO author = new AuthorDAO();
        author.conectar();
        Statement Estamento = author.connection.createStatement();
    %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Autor</title>
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
                    <li><a href="insertAuthor.jsp">Insert Author</a></li>
                    <li><a href="editAuthor.jsp">Edit Author</a></li>
                    <li><a href="deleteAuthor.jsp">Delete Author</a></li> 
                    <li><a href="authorSpeciality.jsp">Speciality</a></li> 
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="home.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
		<div class="title">Author</div>
                <br>
                <div class="table">
                <%
                    ResultSet rs = Estamento.executeQuery("SELECT AUTHOR, COUNTRY, REGION FROM  authors_origin ORDER BY AUTHOR");
                    out.println("<table border=1>");
                    out.println("<tr><th>AUTHOR</th><th>COUNTRY</th><th>REGION</th></tr>");
                    while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>");    
                    out.println(rs.getString("AUTHOR"));
                    out.println("</td><td>");
                    out.println(rs.getString("COUNTRY"));
                    out.println("</td><td>");
                    out.println(rs.getString("REGION"));
                    out.println("</td>");
                    out.println("</tr>");
                    }
                    out.println("</table>");
                    rs.close();
                    Estamento.close();
                    author.connection.close();
                %>
                </div>
            </div>
	</div>
        <br>
        <div id="footer"></div>
    </body>
</html>
</c:if>
