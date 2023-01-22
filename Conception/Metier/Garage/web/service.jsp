<%-- 
    Document   : service
    Created on : 17 janv. 2023, 15:14:21
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
        <h1> Service : </h1>
        <form action="Service" method="get">
            <p>
                <select name="nomservice">
                    <option value="Vidange"> Vidange </option>
                    <option value="Paralellisme"> Paralellisme </option>
                </select>
            </p>
            <p>
                <button type="submit"> Valider </button>
            </p>
        </form>
    </body>
</html>
