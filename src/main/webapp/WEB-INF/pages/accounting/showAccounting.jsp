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
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>

<div class="show-title-wrapper">
    <a class="arrow-back" href="../../orders/showOrders"></a>
    <h2 class="show-title">Accounting</h2>
</div>

<div class="item-wrapper">
    <div class="item-pile padding-bt-16">
        <div class="item-pile-inner-wrapper">
            <div class="info">
                <div class="order-info-label">
                    Tour price:
                </div>
                <div class="order-info-value">
                    ${accounting.tourPrice}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Tour paid:
                </div>
                <div class="order-info-value">
                    ${accounting.tourPaid}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Commission:
                </div>
                <div class="order-info-value">
                    ${accounting.commission}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Touroperator price:
                </div>
                <div class="order-info-value">
                    ${accounting.touroperatorPrice}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Touroperator paid:
                </div>
                <div class="order-info-value">
                    ${accounting.touroperatorPaid}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Profit:
                </div>
                <div class="order-info-value">
                    ${accounting.profit}
                </div>
            </div>

            <a class="edit-btn" href="../${accounting.accountingId}/editAccounting/">Edit</a>
        </div>
    </div>
</div>


</body>

