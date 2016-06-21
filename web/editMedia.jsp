<%-- 
    Document   : editMedia
    Created on : 17-jun-2016, 15:59:41
    Author     : Alex
--%>

<%@page import="Entities.Media"%>
<%@page import="DAO.MediaDAO"%>
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
        <title>DARE-THINK: Edit Media</title>
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
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="media.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
                <div class="title">Edit Media</div>
                </br></br>
                <form id="simpleform" action="/Media_author/EditMedia" method="post">
                    <fieldset>
                        <legend>Media</legend>
                        <div>
                            <label>Name:</label>
                            <select name="NAME_MEDIA_OLD"/>
                            <%
                                MediaDAO media = new MediaDAO();
                                List<Media> medias = new ArrayList();
                                medias = media.listaMedia();
                                for (int k = 0; k < medias.size(); k++) {
                                    out.println("<option>");
                                    out.println(medias.get(k).getNameMedia());
                                    out.println("</option>");
                                }
                            %>
                            </select>
                        </div>
                    </fieldset>
                     <fieldset>
                        <legend>New data</legend>
                        <div>
                            <label>Name:</label>
                            <input type="text" name="NAME_MEDIA" size="auto"/>
                        </div>
                        <div>                             
                            <label>Country:</label>
                            <select name="NAME_COUNTRY">
                                <%
                                    RegionDAO region = new RegionDAO();
                                    List<Region> regions = new ArrayList();
                                    regions = region.listaRegion();
                                    for (int i = 0; i < regions.size(); i++) {
                                        out.println("<optgroup");
                                        out.println(" label='"+ regions.get(i).getNameRegion()+"'>");
                                        out.print("<div> "+regions.get(i).getNameRegion()+"</div>");
                                        CountryDAO country = new CountryDAO();
                                        List<Country> countries = new ArrayList();
                                        countries = country.listaCountry(regions.get(i).getIdRegion());
                                        for (int j = 0; j < countries.size(); j++) {
                                            out.println("<option>");
                                            out.println(countries.get(j).getNameCountry());
                                            out.println("</option>");
                                        }
                                        out.println("</optgroup>");
                                    }
                                %>    
                            </select>
                        </div>
                    </fieldset>       
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'media.jsp';"/>
                    <input class="button" type="submit" value="Edit" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
