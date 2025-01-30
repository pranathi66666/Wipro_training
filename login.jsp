<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="index.jsp" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>
        
        <label>Password:</label>
        <input type="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>

    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null) {
            if ("admin".equals(username) && "admin123".equals(password)) {
                session.setAttribute("user", username); // Store user in session
                response.sendRedirect("welcome.jsp"); // Redirect to success page
                return; // Important to stop further processing after redirection
            } else {
                out.println("<p style='color: red;'>Invalid Username or Password</p>");
            }
        }
    %>
</body>
</html>
