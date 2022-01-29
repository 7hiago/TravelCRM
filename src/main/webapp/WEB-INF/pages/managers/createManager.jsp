<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 21.01.2022
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Create Manager Page</title>
</head>
<body>
<h2>Create manager</h2>
<a href="./showManagers">Back to managers</a>
<form:form action="saveCreatedManager" method="post">
    <table>
        <tr>
            <td>First name:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Salary:</td>
            <td><form:input path="salary"/></td>
        </tr>
        <tr>
            <td>Hire date:</td>
            <td><form:input path="hireDate"/></td>
        </tr>
        <tr>
            <td>Phone number:</td>
            <td><form:input path="phoneNumber"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Login:</td>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td>Pass:</td>
            <td><form:input type="password" path="password" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2, 3}$"/></td>
        </tr>
        <tr>
            <td>Role:</td>
            <td>
                <form:select path="role">
                    <option value="ADMIN">ADMIN</option>
                    <option value="MANAGER">MANAGER</option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Status:</td>
            <td>
                <form:select path="status">
                    <option value="ACTIVE">ACTIVE</option>
                    <option value="BANNED">BANNED</option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create manager"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
