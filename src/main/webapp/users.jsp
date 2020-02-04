<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>phone</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td scope="row">${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td><a href="${pageContext.request.contextPath}/showuser?id=${user.id}">Link</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="/mobiles/">Main page</a>