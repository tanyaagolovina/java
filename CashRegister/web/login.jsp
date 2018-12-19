<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17.12.2018
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>

<jsp:useBean id="user" class="model.User"/>


<form action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="command" value="login" />
    <label for="username">Username: </label>
    <input type="text" name="username" id="username" value="${user.username}">
    <label for="password">Password: </label>
        <input type="password" name="password" id="password" value="${user.password}">
    <label for="role">Role: </label>
    <input type="text" name="role" id="role" value="${user.role}">
        <input type="submit" name="login" value="Login">
</form>
</body>
</html>
