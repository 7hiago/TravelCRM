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
    <title>Show Order Page</title>
</head>
<body>
<h2>Order</h2>
<a href="../../orders/showOrders">Back to orders</a>
<a href="..">Back to main</a>
<table>
    <tr>
        <td>Touroperator Id:</td>
        <td>${touroperator.touroperatorId}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${touroperator.name}</td>
    </tr>
    <tr>
        <td>Phone number:</td>
        <td>${touroperator.phoneNumber}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${touroperator.email}</td>
    </tr>
</table>

