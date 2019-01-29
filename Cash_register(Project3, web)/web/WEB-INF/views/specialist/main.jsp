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
<button type="submit" form="create_product_form"><fmt:message key="CREATE_PRODUCT"/></button>
<button id="req_delete_product_button" type="submit"><fmt:message key="DELETE_PRODUCT"/></button>
<jsp:include page="/WEB-INF/views/logout.jsp"/>
<form id="create_product_form" action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="command" value="CREATE_PRODUCT">
    <input type="hidden" name="role" value="${user.role}">
</form>

<form id="admin_form" action="${pageContext.request.contextPath}/main" hidden="hidden" method="post">
    <input type="hidden" name="command" value="LOGIN_FORM"/>
    <input type="hidden" name="role" value="${user.role}"/>
    <input type="text" name="username" required placeholder="<fmt:message key="USERNAME"/>"/>
    <input type="password" name="password" required placeholder="<fmt:message key="PASSWORD"/>"/>
    <button type="submit"><fmt:message key="LOGIN"/></button>
</form>

<c:if test="${messages != null}">
    <c:forEach items="${messages}" var="message">
        <p>${message}.</p>
    </c:forEach>
</c:if>

<c:if test="${adminUser != null}">
    <form action="${pageContext.request.contextPath}/main" method="post" id="delete_product">
        <input type="hidden" name="command" value="DELETE_PRODUCT">
        <input type="hidden" name="role" value="${user.role}">
        <label for="productID"><fmt:message key="PRODUCT_ID"/></label>
        <input type="number" name="productID" id = "productID" value="" required>
        <button type="submit"><fmt:message key="OK"/></button>>
    </form>
</c:if>

<script>
    function adminForm () {
        document.getElementById('admin_form').hidden = false;
    }
    document.getElementById('req_delete_product_button').addEventListener('click', adminForm);
    document.getElementById('req_cancel_product_button').addEventListener('click', adminForm);
</script>

</body>
</html>
