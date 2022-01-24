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
<a href="../showOrders">Back to orders</a>
<table>
    <tr>
        <td>Order Id</td>
        <td>${order.orderId}</td>
    </tr>
    <tr>
        <td>Tour Id</td>
        <td>${order.tourId}</td>
    </tr>
    <tr>
        <td>Customer Id</td>
        <td>${order.customerId}</td>
    </tr>
    <tr>
        <td>Manager Id</td>
        <td>${order.managerId}</td>
    </tr>
    <tr>
        <td>Accounting Id</td>
        <td>${order.accountingId}</td>
    </tr>
    <tr>
        <td>Date</td>
        <td>${order.date}</td>
    </tr>
    <tr>
        <td>Status</td>
        <td>${order.status}</td>
    </tr>
</table>

