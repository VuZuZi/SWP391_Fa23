<%-- 
    Document   : verify.jsp
    Created on : Oct 1, 2023, 1:38:51 PM
    Author     : Anh4Lan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Verify OTP</h1>
    <form method="post" action="VerifyServlet">
        <label for="otp-input">Enter OTP:</label>
        <input type="text" id="otp-input" name="otp" required>
        <input type="submit" value="Verify">
    </form>
    </body>
</html>
