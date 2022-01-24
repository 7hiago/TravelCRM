<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 22.01.2022
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show Customer Page</title>
</head>
<body>
<h2>Customer</h2>
<a href="../../orders/showOrders">Back to orders</a>
<table>
    <tr>
        <td>First name:</td>
        <td>${customer.firstName}</td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td>${customer.lastName}</td>
    </tr>
    <tr>
        <td>Phone number:</td>
        <td>${customer.phoneNumber}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${customer.email}</td>
    </tr>
</table>

