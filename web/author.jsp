<%-- 
    Document   : telaInicial
    Created on : 23/05/2016, 15:55:23
    Author     : alex
--%>
<c:if test="condition">
    
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Autor</title>
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
                    <li><a href="insertAuthor.jsp">Insert Author</a></li>
                    <li><a href="insertAuthor.jsp">Insert Author</a></li>
                    <li><a href="editAuthor.jsp">Edit Author</a></li> 
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="home.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
		<div class="title">Author</div>
                
            </div>
	</div>
        <br>
        <div id="footer"></div>
    </body>
</html>
</c:if>
