<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17.01.2019
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="PRODUCT"/></title>
</head>
<body>

<form action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="command" value="ADD_NEW_PRODUCT" />
    <input type="hidden" name="role" value="${user.role}"/>

    <label for="productID"><fmt:message key="PRODUCT_ID"/></label>
    <input type="number" name="productID" id="productID" value="" required>

    <label for="productName"><fmt:message key="PRODUCT_NAME"/></label>
    <input type="text" name="productName" id="productName" value="" required/>

    <label for="price"><fmt:message key="PRODUCT_PRICE"/></label>
    <input type="number" name="price" id="price" value="" required/>

    <label for="amount"><fmt:message key="PRODUCT_AMOUNT"/></label>
    <input type="number" name="amount" id="amount" value="" required/>

    <input type="submit" value=<fmt:message key="CREATE_PRODUCT"/>>
</form>



<c:if test="${messageList != null}">
    <c:forEach items="${messageList}" var="message">
        <p>${message}</p>
    </c:forEach>

</c:if>

<p>${product}</p>

<form action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="command" value="RETURN">
    <input type="hidden" name="role" value="${user.role}">
    <button type="submit"><fmt:message key="RETURN"/></button>
</form>

</body>
</html>
