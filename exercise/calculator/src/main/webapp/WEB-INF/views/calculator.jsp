<%--
  Created by IntelliJ IDEA.
  User: buihuuhai
  Date: 14/08/2023
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save" method="post">
    <div class="row">
        <input type="number" name="input1" value="${input1}" placeholder="number 1">
        <input type="number" name="input2" value="${input2}" placeholder="number 2">
    </div>
    <div class="row">
        <button type="submit" name="cal" value="+">+</button>
        <button type="submit" name="cal" value="-">-</button>
        <button type="submit" name="cal" value="*">*</button>
        <button type="submit" name="cal" value="/">/</button>
    </div>
</form>
<input type="number" name="result" value="${result}" placeholder="result">
</body>
</html>
