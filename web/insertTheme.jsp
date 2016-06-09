<%-- 
    Document   : insertTheme
    Created on : 06-jun-2016, 17:39:49
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Insert Specific Theme</title>
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
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="theme.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
		<div class="title">Insert Specific Theme</div>
                </br></br>
                <form  id="simpleform" action="/Media_author/InsertTheme" method="post">
                    <fieldset>
                        <legend>Specific Theme</legend>
                        <div>
                            <label>Name:</label>
                            <input type="text" name="NAME_THEME" size="auto"/>
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
