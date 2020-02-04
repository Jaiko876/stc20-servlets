<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<ul class="list-group">
    <li class="list-group-item">Id: ${user.id}</li>
    <li class="list-group-item">Login: ${user.login}</li>
    <li class="list-group-item">Password: ${user.password}</li>
    <li class="list-group-item">Email: ${user.email}</li>
    <li class="list-group-item">$Phone: {user.phone}</li>
</ul>

<br>
<a href="/mobiles/">Main page</a>
