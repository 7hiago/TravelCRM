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
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>

<div class="show-title-wrapper">
    <a class="arrow-back" href="../../orders/showOrders"></a>
    <h2 class="show-title">Manager</h2>
</div>

<div class="item-wrapper">
    <div class="item-pile padding-bt-16 width-400">
        <img class="avatar" src="https://i.pravatar.cc/150"/>

        <div class="item-pile-inner-wrapper">
            <div class="info">
                <div class="order-info-label">
                    First Name
                </div>
                <div class="order-info-value">
                    ${manager.firstName}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Last Name
                </div>
                <div class="order-info-value">
                    ${manager.lastName}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Salary
                </div>
                <div class="order-info-value">
                    ${manager.salary}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Hire Date
                </div>
                <div class="order-info-value">
                    ${manager.hireDate}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Phone NUmber
                </div>
                <div class="order-info-value">
                    ${manager.phoneNumber}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Email
                </div>
                <div class="order-info-value">
                    ${manager.email}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Login
                </div>
                <div class="order-info-value">
                    ${manager.login}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Role
                </div>
                <div class="order-info-value">
                    ${manager.role}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Status
                </div>
                <div class="order-info-value">
                    ${manager.status}
                </div>
            </div>
        </div>
    </div>
</div>

</body>
