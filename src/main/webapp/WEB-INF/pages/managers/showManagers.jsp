<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 21.01.2022
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<html>
<head>
    <title>Show Managers Page</title>
</head>
<br>
<h2>Managers</h2>
<a href="..">Back to main</a></br>
<a href="./createManager">Create new manager</a>
<table border="1" cellpadding="2" width="60%">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Salary</th>
        <th>Hire date</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Login</th>
        <th>Pass</th>
        <th>Edit</th>
    </tr>

    <c:forEach var="manager" items="${managers}">
        <tr>
            <td>${manager.firstName}</td>
            <td>${manager.lastName}</td>
            <td>${manager.salary}</td>
            <td>${manager.hireDate}</td>
            <td>${manager.phoneNumber}</td>
            <td>${manager.email}</td>
            <td>${manager.login}</td>
            <td>${manager.password}</td>
            <td>
                <a href="./${manager.managerId}/editManager/">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
