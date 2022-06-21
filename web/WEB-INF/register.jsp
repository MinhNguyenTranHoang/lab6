<%-- 
    Document   : register
    Created on : Jun 20, 2022, 7:53:02 PM
    Author     : MINH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="ShoppingList" method="POST">
            <label>Username: <input type="text" name="name" id="name"></input></label>
            
            
            <input type="submit" value="Register name">
            
        </form>
        <p>${message}</p>
    </body>
</html>

