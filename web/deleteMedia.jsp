<%-- 
    Document   : deleteMedia
    Created on : 17-jun-2016, 16:00:20
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Delete Media</title>
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
                    <li><a href="home.jsp">Home</a></li>
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="media.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
		<div class="title">Delete Media</div>
                </br></br>
                <form id="simpleform" action="/Media_author/DeleteMedia" method="post">
                    <fieldset>
                        <legend></legend>
                       
                    </fieldset>
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href='media.jsp';"/>
                    <input class="button" type="reset" value="Clean" style="font-size: 16px;">
                    <input class="button" type="submit" value="Delete" style="font-size: 16px;">
                </form>	
            </div>
	</div>
        <br>
        <div id="footer"></div>
    </body>
</html>
