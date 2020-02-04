<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/date.tld" prefix="datetag" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>Mobiles</h1>
        (<datetag:DateTag plus="1"/>)
    </jsp:attribute>
    <jsp:body>
        <ul>
            <li><a href="${pageContext.request.contextPath}/allmobiles">List mobiles</a></li>
            <li><a href="${pageContext.request.contextPath}/addmobile">Add mobile</a></li>
            <li><a href="${pageContext.request.contextPath}/users">List users</a></li>
        <c:if test="${CURRENT_USER == null}">
            <li><a href="${pageContext.request.contextPath}/register">Register</a></li>
            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
        </c:if>
            <c:if test="${CURRENT_USER != null}">
                <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
            </c:if>
        </ul>
        <c:set var="message" value='${requestScope["error"]}' />
        <c:out value="${message}"></c:out>
    </jsp:body>
</myTags:template>