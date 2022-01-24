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
    <title>Show Tour Page</title>
</head>
<body>
<h2>Tour</h2>
<a href="../../orders/showOrders">Back to orders</a>
<table>
    <tr>
        <td>Country:</td>
        <td>${tour.country}</td>
    </tr>
    <tr>
        <td>Hotel:</td>
        <td>${tour.hotel}</td>
    </tr>
    <tr>
        <td>Departure date:</td>
        <td>${tour.departureDate}</td>
    </tr>
    <tr>
        <td>Return date:</td>
        <td>${tour.returnDate}</td>
    </tr>
    <tr>
        <td>Proposal number:</td>
        <td>${tour.proposalNumber}</td>
    </tr>
    <tr>
        <td>Touroperator:</td>
        <td>${tour.touroperatorId}</td>
    </tr>
    <tr>
        <td></td>
        <td>
            <a href="../${tour.tourId}/editTour/">Edit</a>
        </td>
    </tr>
</table>

