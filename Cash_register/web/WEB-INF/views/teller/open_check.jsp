<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 13.01.2019
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>--%>
<jsp:useBean id="checkBean" class="service.CheckService"/>



<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title><fmt:message key="CHECK"/></title>

</head>
<body>
<h2><fmt:message key="CHECK"/>${check_ID}</h2>

<button id="add_button"><fmt:message key="ADD_PRODUCT"/></button>
<button form="close_check_form"><fmt:message key="CLOSE_CHECK"/></button>
<c:if test="${adminUser != null}">
    <form action="${pageContext.request.contextPath}/main" method="post">
        <input type="submit" value="<fmt:message key="OK"/>">
        <input type="hidden" name="command" value="CANCEL_CHECK">
        <input type="hidden" name="role" value="admin">
    </form>
</c:if>
<button id="req_cancel_check_button" type="submit"><fmt:message key="CANCEL_CHECK"/></button>

<c:if test="${product_error_list != null}">
    <c:forEach items="${product_error_list}" var="message">
        <p>${message}.</p>
    </c:forEach>
</c:if>

<form id="add_product_form" action="${pageContext.request.contextPath}/main">
    <input type="hidden" name="command" value="ADD_PRODUCT"/>
    <input type="hidden" name="role" value="teller"/>
</form>

<form id="close_check_form" action="${pageContext.request.contextPath}/main">
    <input type="hidden" name="command" value="CLOSE_CHECK"/>
    <input type="hidden" name="role" value="teller"/>
</form>

<form id="admin_form" action="${pageContext.request.contextPath}/main" hidden="hidden" method="post">
    <input type="hidden" name="command" value="LOGIN_FORM"/>
    <input type="hidden" name="role" value="teller"/>
    <input type="text" name="username" required placeholder="<fmt:message key="USERNAME"/>"/>
    <input type="password" name="password" required placeholder="<fmt:message key="PASSWORD"/>"/>
    <button type="submit"><fmt:message key="LOGIN"/></button>
</form>

<c:if test="${messages != null}">
    <c:forEach items="${messages}" var="message">
        <p>${message}.</p>
    </c:forEach>
</c:if>

<c:if test="${check != null}">
    <p><fmt:message key="CHECK"/><c:out value=" ${check.checkNumber}"/></p>
    <hr>
    <c:forEach items="${check.products}" var="product">
        <p>${product}</p>
            <input type="button" value="<fmt:message key="CANCEL_PRODUCT"/>" id="req_cancel_product_button">
            <c:if test="${adminUser != null}">
            <form action="${pageContext.request.contextPath}/main" method="post">
                <input type="submit" value="<fmt:message key="OK"/>">
                <input type="hidden" name="productID" value="${product.id}">
                <input type="hidden" name="command" value="CANCEL_PRODUCT">
                <input type="hidden" name="role" value="admin">
            </form>
            </c:if>
    </c:forEach>
    <hr>
    <c:out value="${check.date}"/>
</c:if>

<script>
    function appendChild (parent, elem) {
        return parent.appendChild(elem);
    }
    function createElement (tag) {
        return document.createElement(tag);
    }
    function setCustomAttribute (element, attr, value) {
        return element.setAttribute(attr, value);
    }
    document.getElementById('add_button').addEventListener('click', function() {
        var parent = document.getElementById('add_product_form');
        var input = createElement('input');
        setCustomAttribute(input, 'type', 'number');
        setCustomAttribute(input, 'placeholder', 'ID');
        setCustomAttribute(input, 'required', 'true');
        setCustomAttribute(input, 'name', 'productID');
        var input2 = createElement('input');
        setCustomAttribute(input2, 'type', 'number');
        setCustomAttribute(input2, 'placeholder', 'AMOUNT');
        setCustomAttribute(input2, 'required', 'true');
        setCustomAttribute(input2, 'name', 'amount');
        var okButton = document.createElement('button');
        setCustomAttribute(okButton, 'id', 'ok_button');
        setCustomAttribute(okButton, 'type', 'submit');
        okButton.innerText = 'OK';
        var elements = [input, input2, okButton];
        elements.forEach(function(e) {
           return appendChild(parent, e);
        })
    });
    function adminForm () {
        document.getElementById('admin_form').hidden = false;
    }
    document.getElementById('req_cancel_check_button').addEventListener('click', adminForm);
    document.getElementById('req_cancel_product_button').addEventListener('click', adminForm);

</script>
</body>
</html>