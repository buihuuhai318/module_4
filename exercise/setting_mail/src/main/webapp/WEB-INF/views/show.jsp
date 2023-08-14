<%--
  Created by IntelliJ IDEA.
  User: buihuuhai
  Date: 14/08/2023
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<fieldset disabled>
    <table>
        <tr>
            <td>Languages:</td>
            <td>
                <select name="languages">
                    <option value="English"
                            <c:if test="${setting.languages eq 'English'}">selected</c:if> >English
                    </option>
                    <option value="Vietnamese"
                            <c:if test="${setting.languages eq 'Vietnamese'}">selected</c:if> >Vietnamese
                    </option>
                    <option value="Japanese"
                            <c:if test="${setting.languages eq 'Japanese'}">selected</c:if> >Japanese
                    </option>
                    <option value="Chinese"
                            <c:if test="${setting.languages eq 'Chinese'}">selected</c:if> >Chinese
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>
                <label for="size">Show</label><select name="size" id="size">
                <option value="5"
                        <c:if test="${setting.pageSize == 5}">selected</c:if> >5
                </option>
                <option value="10"
                        <c:if test="${setting.pageSize == 10}">selected</c:if> >10
                </option>
                <option value="15"
                        <c:if test="${setting.pageSize == 15}">selected</c:if> >15
                </option>
                <option value="25"
                        <c:if test="${setting.pageSize == 25}">selected</c:if> >25
                </option>
                <option value="50"
                        <c:if test="${setting.pageSize == 50}">selected</c:if> >50
                </option>
                <option value="100"
                        <c:if test="${setting.pageSize == 100}">selected</c:if> >100
                </option>
            </select><label> email per page</label>
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="flexCheckIndeterminate" name="spam"
                           <c:if test="${setting.filter}">checked</c:if>>
                    <label class="form-check-label" for="flexCheckIndeterminate">
                        Enable spams filter
                    </label>
                </div>
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <textarea name="signature" cols="30" rows="10">${setting.signature}</textarea>
            </td>
        </tr>
    </table>
</fieldset>
<table>
    <tr>
        <td></td>
        <td>
            <button onclick="window.location.href='/edit'">setting</button>
        </td>
    </tr>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
