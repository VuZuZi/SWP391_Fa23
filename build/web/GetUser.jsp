<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <h2>User Details</h2>
    
    <%-- Lấy danh sách người dùng từ request --%>
    <% ArrayList<User> res = (ArrayList<User>)request.getAttribute("res"); %>

    <%-- Kiểm tra xem danh sách người dùng có tồn tại không --%>
    <c:if test="${res != null && not empty res}">
        <table border="1">
            <tr>
                <th>User ID</th>
                <th>User Account</th>
                <th>Full Name</th>
                <th>Password</th>
                <th>Phone</th>
                <th>Gender</th>
                <th>Date of Birth</th>
                <th>Skills</th>
                <th>isAdmin</th>
                <th>Number of Reports</th>
            </tr>
            
            <%-- Sử dụng forEach để lặp qua danh sách người dùng --%>
            <c:forEach  items="${res}" var="u">
                <tr> 
                    <td>${u.getUserID()}</td>
                    <td>${u.getUserAccount()}</td>
                    <td>${u.getUserName()}</td>
                    <td>${u.getUserPassword()}</td>
                    <td>${u.getPhone()}</td>
                    <td>${u.getGender()}</td>
                    <td>${u.getUserDOB()}</td>
                    <td>${u.getUserSkills()}</td>
                    <td>${u.getIsAdmin()}</td>
                    <td>${u.getNumberOfReports()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    
    <%-- Nếu danh sách rỗng hoặc null, hiển thị thông báo --%>
    <c:if test="${empty res}">
        <p>User not found</p>
    </c:if>
</body>
</html>
