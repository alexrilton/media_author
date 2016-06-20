<%-- 
    Document   : telaInicial
    Created on : 23/05/2016, 15:55:23
    Author     : alex
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<c:if test="condition">
    <%
        Class.forName("com.mysql.jdbc.Driver");
        Connection  conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/author_media", "root", "");
        Statement Estamento = conexion.createStatement();
    %>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Media</title>
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
                    <li><a href="insertMedia.jsp">Insert Media</a></li>
                    <li><a href="editMedia.jsp">Edit Media</a></li> 
                    <li><a href="deleteMedia.jsp">Delete Media</a></li> 
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="home.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
		<div class="title">Media</div>
                <br>
                <div class="table">
                <%
                    ResultSet rs = Estamento.executeQuery("SELECT MEDIA, COUNTRY, REGION FROM  media_origin");
                    out.println("<table border=1>");
                    out.println("<tr><th>MEDIA</th><th>COUNTRY</th><th>REGION</th></tr>");
                    while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>");    
                    out.println(rs.getString("MEDIA"));
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
                    conexion.close();
                %>
                </div>
            </div>
	</div>
        <br>
        <div id="footer"></div>
    </body>
</html>
</c:if>
