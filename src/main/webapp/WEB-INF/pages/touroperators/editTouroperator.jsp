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
    <title>Edit Order Page</title>
</head>
<body>
<h2>Edit order</h2>
<a href="../../showOrders">Back to main</a>
<form:form action="../../saveEditedTouroperator/${command.touroperatorId}" method="patch">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
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
            <td></td>
            <td><input type="submit" value="Edit touroperator"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
