<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17.01.2019
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="ALL_CHECKS"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>
<c:forEach items="${checks}" var="check">
    <fmt:message key="CHECK"/><p> ${check.checkNumber}</p>
    <p>${check.status}</p>
    <p>${check.date}</p>
    <form action="${pageContext.request.contextPath}/main" method="post">
        <input type="hidden" name="role" value="${user.role}">
        <input type="hidden" name="checkID" value="${check.checkNumber}">
        <input type="hidden" name="command" value="VIEW_CHECK">
        <button type="submit"><fmt:message key="VIEW_CHECK"/></button>
    </form>
</c:forEach>

<%--<form id="checks_navigation_previous" action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="command" value="GET_ALL_CHECKS">
    <input type="hidden" name="command" value="${user.role}">
    <input type="hidden" name="page" value="2">
</form>

<form id="checks_navigation_next" action="${pageContext.request.contextPath}/main" method="post">
    <input type="hidden" name="command" value="GET_ALL_CHECKS">
    <input type="hidden" name="command" value="${user.role}">
    <input type="hidden" name="page" value="2">
</form>--%>

<nav aria-label="Navigation for checks">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/main?currentPage=${currentPage-1}&command=GET_ALL_CHECKS&role=${user.role}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${nOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li class="page-item active"><a class="page-link">
                            ${i} <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/main?currentPage=${i}&command=GET_ALL_CHECKS&role=${user.role}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt nOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/main?currentPage=${currentPage+1}&command=GET_ALL_CHECKS&role=${user.role}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>
</body>
</html>
