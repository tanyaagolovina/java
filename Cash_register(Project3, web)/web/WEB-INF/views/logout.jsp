<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17.01.2019
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<button form="logout" type="submit"><fmt:message key="LOGOUT"/></button>
<form id="logout" action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="role" value="${user.role}">
    <input type="hidden" name="command" value="LOGOUT">
</form>

</body>
</html>
