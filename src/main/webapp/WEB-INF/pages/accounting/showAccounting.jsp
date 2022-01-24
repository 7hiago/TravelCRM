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
    <title>Show Accounting Page</title>
</head>
<body>
<h2>Accounting</h2>
<a href="../../orders/showOrders">Back to orders</a>
<table>
    <tr>
        <td>Tour price:</td>
        <td>${accounting.tourPrice}</td>
    </tr>
    <tr>
        <td>Tour paid:</td>
        <td>${accounting.tourPaid}</td>
    </tr>
    <tr>
        <td>Commission:</td>
        <td>${accounting.commission}</td>
    </tr>
    <tr>
        <td>Touroperator price:</td>
        <td>${accounting.touroperatorPrice}</td>
    </tr>
    <tr>
        <td>Touroperator paid:</td>
        <td>${accounting.touroperatorPaid}</td>
    </tr>
    <tr>
        <td>Profit:</td>
        <td>${accounting.profit}</td>
    </tr>
    <tr>
        <td></td>
        <td>
            <a href="../${accounting.accountingId}/editAccounting/">Edit</a>
        </td>
    </tr>
</table>

