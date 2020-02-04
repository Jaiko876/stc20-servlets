<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<ul class="list-group">
   <li class="list-group-item">ID: ${mobile.id}</li>
   <li class="list-group-item">Model: ${mobile.model}</li>
   <li class="list-group-item">Price: ${mobile.price}</li>
   <li class="list-group-item">Manufacturer: ${mobile.manufacturer}</li>
</ul>

<br>
<a href="/mobiles/">Main page</a>
