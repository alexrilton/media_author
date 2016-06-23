<%-- 
    Document   : searchSpeciality
    Created on : 23-jun-2016, 17:11:17
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Search Speciality</title>
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
                <div class="title">Search Speciality</div>
                </br></br>
                <form id="simpleform" action="/Media_author/SearchSpeciality" method="post">
                    <fieldset>
                        <legend>Speciality and/or Theme</legend>
                        <div>
                            <label>Speciality:</label>
                            <p><input type="checkbox" name="check-spec" onclick="document.getElementById('NAME_SPEC').disabled = !this.checked;"></p>
                            <p><input type="text" name="NAME_SPEC" id="NAME_SPEC" size="40" disabled="disabled"> </p>
                        </div>
                        <div>
                            <label>Theme:</label>
                            <p><input type="checkbox" name="check-theme" onclick="document.getElementById('NAME_THEME').disabled = !this.checked;"></p>
                            <p><input type="text" name="NAME_THEME" id="NAME_THEME" size="40" disabled="disabled"> </p>
                        </div>
                    </fieldset>
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'speciality.jsp';"/>
                    <input class="button" type="submit" value="Search" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
