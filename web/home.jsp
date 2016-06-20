<%-- 
    Document   : telaInicial
    Created on : 23/05/2016, 15:55:23
    Author     : alex
--%>
<c:if test="condition">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Media_Autor</title>
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
                    <li><a href="author.jsp">Author</a></li>
                    <li><a href="media.jsp">Media</a></li>
                    <li><a href="speciality.jsp">Speciality</a></li>
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="country.jsp">Country</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
		<div class="title">What is?</div>
            </div>
	</div>
        <br>
        <div id="footer"></div>
    </body>
</html>
</c:if>
