<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 18.12.2018
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session"/>--%>
<fmt:setLocale value="${language}"/>


<html>
<head lang="${language}">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title><fmt:message key="GREETING"/></title>
</head>
<body>
<p><c:out value="${user},"/><fmt:message key="GREETING"/></p>
<button form="all_checks_form" type="submit"><fmt:message key="ALL_CHECKS"/></button>
<jsp:include page="/WEB-INF/views/logout.jsp"/>
<form id="all_checks_form" action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="role" value="${user.role}">
    <input type="hidden" name="command" value="GET_ALL_CHECKS">
    <input type="hidden" name="currentPage" value="1">
</form>
</body>
</html>
