<%-- 
    Document   : shoppingList
    Created on : Jun 20, 2022, 7:53:13 PM
    Author     : MINH
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <p>Hello, ${name}. </p>
        <a href="ShoppingList?logout">Logout</a>
        
        <h2>List</h2>
        <form action="ShoppingList" method="post">
            <input type="hidden" name="action" value="add">
                
            <label for="item">Item<input type="text" name="item" id="item"></input></label>
            <button type="submit">Add</button>
        </form>
        <p>${message1}</p>
        <form action="ShoppingList" method="post">
            <input type="hidden" name="action" value="delete">
            <c:forEach items="${items}" var="item">
                <p>
                    <input type="radio" name="item" value="${item}">
                    ${item}
                </p>
            </c:forEach>
            
            <button>Delete</button>
            <p>${message2}</p>
        </form>
    </body>
</html>

