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
    <title>Edit Customer Page</title>
</head>
<body>
<h2>Edit customer</h2>
<a href="../../showCustomers">Back to customers</a>
<form:form action="../../saveEditedCustomer/${command.customerId}" method="patch">
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
            <td>Phone number:</td>
            <td><form:input path="phoneNumber"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit customer"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
