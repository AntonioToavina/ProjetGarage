<%-- 
    Document   : result
    Created on : 17 janv. 2023, 15:33:33
    Author     : ITU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p> Revenu salarial : </p>
        <%
            out.println(request.getAttribute("RevientSalarial"));
            %>
    </body>
</html>
