<%--
  Created by IntelliJ IDEA.
  User: buihuuhai
  Date: 14/08/2023
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/change" method="post">
    <input type="number" name="input" placeholder="nhap vap day" value="${input}">
    <button type="submit">nhap</button>
</form>
<input type="number" value="${output}">
</body>
</html>
