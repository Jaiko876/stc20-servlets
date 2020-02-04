<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="user" class="com.inno.pojo.User" />
<c:set target="${user}" property="login" value="login" />
<c:set target="${user}" property="password" value="password" />
<c:set target="${user}" property="email" value="email" />
<c:set target="${user}" property="phone" value="phone" />
<h1><div align="center">Register a new user</div></h1>
<form method="post" action="${pageContext.request.contextPath}/register" autocomplete="off">
    <div class="form-group">
        <label for="login"></label>
        <input name="login" type="text" class="form-control" id="login" value="<jsp:getProperty name="user" property="login" />">
    </div>
    <div class="form-group">
        <label for="password"></label>
        <input name="password" type="text" class="form-control" id="password" value="<jsp:getProperty name="user" property="password" />">
    </div>
    <div class="form-group">
        <label for="email"></label>
        <input name="email" type="text" class="form-control" id="email" value="<jsp:getProperty name="user" property="email" />">
    </div>
    <div class="form-group">
        <label for="phone"></label>
        <input name="phone" type="text" class="form-control" id="phone" value="<jsp:getProperty name="user" property="phone" />">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<a href="/mobiles/">Main page</a>
