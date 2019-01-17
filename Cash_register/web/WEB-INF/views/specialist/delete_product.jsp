<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17.01.2019
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="DELETE_PRODUCT"/></title>
</head>
<body>

<form action="${pageContext.request.contextPath}/main">

    <c:if test="${messageList != null}">
        <c:forEach items="${messageList}" var="message">
            <p>${message}</p>
        </c:forEach>
    </c:if>

    <form action="${pageContext.request.contextPath}/main" method="post">
        <input type="hidden" name="command" value="RETURN">
        <input type="hidden" name="role" value="${user.role}">
        <button type="submit"><fmt:message key="RETURN"/></button>
    </form>
</form>

</body>
</html>
