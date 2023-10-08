<%-- 
    Document   : mainAdmin
    Created on : Oct 8, 2023, 3:38:42 PM
    Author     : ASUS
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Job"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <title>JobBoard &mdash; Website Template by Colorlib</title>
        
    </head>
   
    <body id="top">
    <c:forEach items="${jobs}" var="job">
        <label>Name</label>
        <div class="row-table">
            ${job} 
        </div>
    </c:forEach>
        
    </body>

</html>
