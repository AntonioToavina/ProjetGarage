<%-- 
    Document   : insert
    Created on : 17 janv. 2023, 15:04:43
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
        <h1> Insert employe </h1>
        <form action="#" method="post">
            <p>
                <input type="text" name="nom"/>
            </p>
            <p>
                <input type="text" name="prenom"/>
            </p>
            <p>
                <input type="date" name="dtn"/>
            </p>
            <p>
                <select name="niveau">
                    <option value="1"> Bacc </option>
                    <option value="2"> Licence </option>
                </select>
            </p>
        </form>
    </body>
</html>
