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
    <title>Show Manager Page</title>
</head>
<body>
<h2>Manager</h2>
<a href="../../orders/showOrders">Back to orders</a>
<table>
    <tr>
        <td>First name:</td>
        <td>${manager.firstName}</td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td>${manager.lastName}</td>
    </tr>
    <tr>
        <td>Phone number:</td>
        <td>${manager.phoneNumber}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${manager.email}</td>
    </tr>
    <tr>
        <td>Role:</td>
        <td>${manager.role}</td>
    </tr>
    <tr>
        <td>Status:</td>
        <td>${manager.status}</td>
    </tr>
</table>

