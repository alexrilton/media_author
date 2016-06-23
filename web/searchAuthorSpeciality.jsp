<%-- 
    Document   : searchAuthorSpeciality
    Created on : 23-jun-2016, 17:21:20
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Search Author - Speciality</title>
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
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="authorSpeciality.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
                <div class="title">Search Author - Speciality</div>
                </br></br>
                <form id="simpleform" action="/Media_author/AuthorSpeciality" method="post" overflow="auto">
                    <fieldset>
                        <legend>Author and/or Speciality and/or Country and/or Media</legend>
                        <div>
                            <label>Author:</label>
                            <p><input type="checkbox" name="check-author" onclick="document.getElementById('NAME_AUTHOR').disabled = !this.checked;"></p>
                            <p><input type="text" name="NAME_AUTHOR" id="NAME_AUTHOR" size="40" disabled="disabled"> </p>
                        </div>
                        <div>
                            <label>Speciality:</label>
                            <p><input type="checkbox" name="check-spec" onclick="document.getElementById('NAME_SPEC').disabled = !this.checked;"></p>
                            <p><input type="text" name="NAME_SPEC" id="NAME_SPEC" size="40" disabled="disabled"> </p>
                        </div>
                        <div>
                            <label>Media:</label>
                            <p><input type="checkbox" name="check-media" onclick="document.getElementById('NAME_MEDIA').disabled = !this.checked;"></p>
                            <p><input type="text" name="NAME_MEDIA" id="NAME_MEDIA" size="40" disabled="disabled"> </p>
                        </div>
                        <div>
                            <label>Country:</label>
                            <p><input type="checkbox" name="check-country" onclick="document.getElementById('NAME_COUNTRY').disabled = !this.checked;"></p>
                            <p><input type="text" name="NAME_COUNTRY" id="NAME_COUNTRY" size="40" disabled="disabled"> </p>
                        </div>
                    </fieldset>
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'authorSpeciality.jsp';"/>
                    <input class="button" type="submit" value="Search" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
