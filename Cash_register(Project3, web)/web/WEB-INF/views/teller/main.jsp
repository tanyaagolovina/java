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
<fmt:setBundle basename="properties.messages"/>

<html>
<head lang="${language}">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title><fmt:message key="GREETING"/></title>
</head>
<body>

<%--<form action="${lang.changeLocale(language)}">
<select name="language" onchange="submit()">
    <option value="en">English</option>
    <option value="ru" selected>Russian</option>
</select>
</form>
<jsp:include page="header.jsp" />--%>
<p><c:out value="${user},"/><fmt:message key="GREETING"/></p>
<button form="open_check_form" type="submit" name="login"><fmt:message key="OPEN_CHECK"/></button>
<jsp:include page="/WEB-INF/views/logout.jsp"/>
<form id="open_check_form" action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="command" value="OPEN_CHECK"/>
    <input type="hidden" name="role" value="${user.role}"/>
</form>
</body>
</html>
