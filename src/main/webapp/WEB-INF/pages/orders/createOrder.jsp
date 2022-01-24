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
    <title>Create Order Page</title>
</head>
<body>
<h2>Create order</h2>
<a href="..">Back to main</a>
<form:form action="saveCreatedOrder" method="post">
    <table>
        <tr>
            <td>Tour Id</td>
            <td><form:input path="tourId"/></td>
        </tr>
        <tr>
            <td>Customer Id</td>
            <td><form:input path="customerId"/></td>
        </tr>
        <tr>
            <td>Manager Id</td>
            <td><form:input path="managerId"/></td>
        </tr>
        <tr>
            <td>Accounting Id</td>
            <td><form:input path="accountingId"/></td>
        </tr>
        <tr>
            <td>Date</td>
            <td><form:input path="date"/></td>
        </tr>
        <tr>
            <td>Status</td>
            <td><form:input path="status"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create order"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
