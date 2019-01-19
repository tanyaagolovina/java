<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 15.01.2019
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="CHECK"/></title>
</head>
<body>
<c:if test="${error_list != null}">
    <c:forEach items="${error_list}" var="message">
        <p>${message}.</p>
    </c:forEach>
</c:if>
<c:if test="${error_list == null}">
    <c:if test="${check != null}">
        <p><fmt:message key="CHECK"/><c:out value=" ${check.checkNumber}"/></p>
        <hr>
        <c:forEach items="${check.products}" var="product">
            <p>${product}</p>
        </c:forEach>
        <hr>
        <c:out value="${check.date}"/>
    </c:if>
    <h2><fmt:message key="BYE"/></h2>
    <form action="${pageContext.request.contextPath}/main">
        <input type="hidden" name="command" value="RETURN">
        <input type="hidden" name="role" value="${user.role}">
        <input type="submit" value="<fmt:message key="RETURN"/>">
    </form>
</c:if>

</body>
</html>
