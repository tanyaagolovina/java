<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17.12.2018
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="property" class="utils.managers.MessageManager"/>
<%--<jsp:useBean id="user" class="model.User"/>--%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title><fmt:message key="LOGIN"/></title>
</head>
<body>


<h1><fmt:message key="LOGIN"/></h1>

<c:if test="${messages != null}">
    <c:forEach items="${messages}" var="message">
        <p>${message}.</p>
    </c:forEach>
</c:if>

<jsp:include page="/WEB-INF/views/header.jsp" />
<form action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="command" value="login" />
    <label for="username"><fmt:message key="USERNAME"/></label>
    <input type="text" name="username" id="username" value="" required>
    <label for="password"><fmt:message key="PASSWORD"/></label>
        <input type="password" name="password" id="password" value="" required/>
    <label for="role"><fmt:message key="ROLE"/></label>
    <input type="text" name="role" id="role" value="" required/>
        <input type="submit" name="login" value=<fmt:message key="LOGIN"/>>
</form>
</body>
</html>
