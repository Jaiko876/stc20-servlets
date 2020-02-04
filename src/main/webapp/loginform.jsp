<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="user" class="com.inno.pojo.User" />
<c:set target="${user}" property="login" value="login" />
<c:set target="${user}" property="password" value="password" />


<h1><div align="center">Login</div></h1>
<form method="post" action="${pageContext.request.contextPath}/login" autocomplete="off">
    <div class="form-group">
        <label for="login"></label>
        <input name="login" type="text" class="form-control" id="login" value=
                "<jsp:getProperty name="user" property="login" />" required>
    </div>
    <div class="form-group">
        <label for="password"></label>
        <input name="password" type="password" class="form-control" id="password" value=
                "<jsp:getProperty name="user" property="password" />" required>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<a href="/mobiles/">Main page</a>
