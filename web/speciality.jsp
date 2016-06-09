<%-- 
    Document   : telaInicial
    Created on : 23/05/2016, 15:55:23
    Author     : alex
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<c:if test="condition">
<%@page import="java.sql.ResultSet"%>
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
        <title>DARE-THINK: Speciality</title>
        <link rel='stylesheet' href='style.css' type='text/css'>
    </head>
    <body>
        
        <div id="header1">
            <div class="logo"><img id="logo" src="img/medthor.png" alt="pinguim"/></div>
        </div>
	<div id="header2"></div>
        <br>
	<div id="mainbody">
            <div class="content" style="width:25%; float:left">
		<div class="title">Menu</div>
                <ul>
                    <li><a href="insertSpeciality.jsp">Insert Speciality</a></li>
                    <li><a href="editSpeciality.jsp">Edit Speciality</a></li>
                    <li><a href="theme.jsp">Theme</a></li>
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="home.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
		<div class="title">Speciality</div>
                <br>
                <div class="table">
                <%
                    ResultSet rs = Estamento.executeQuery("SELECT SPECIALITY, THEME FROM  themes_specialities");
                    out.println("<table border=1>");
                    out.println("<tr><th>SPECIALITY</th><th>THEME</th></tr>");
                    while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>");    
                    out.println(rs.getString("SPECIALITY"));
                    out.println("</td><td>");
                    out.println(rs.getString("THEME"));
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
