<%--
  Created by IntelliJ IDEA.
  User: buihuuhai
  Date: 14/08/2023
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save" method="post">
    <label><input type="checkbox" name="condiment" value="Lettuce">Lettuce</label>
    <label><input type="checkbox" name="condiment" value="Tomato">Tomato</label>
    <label><input type="checkbox" name="condiment" value="Mustard">Mustard</label>
    <label><input type="checkbox" name="condiment" value="Sprouts">Sprouts</label>
    <button>save</button>
</form>
<table border="1 solid">
    <tr>
        <th>Sandwich</th>
        <th>Condiment</th>
    </tr>
    <c:forEach var="condiment" items="${list}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${condiment}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
