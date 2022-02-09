<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Show Customer Page</title>
        <style>
            <%@include file="/WEB-INF/pages/style.css" %>
        </style>
    </head>
    <body>
        <div class="show-title-wrapper">
            <a class="arrow-back" href="../../orders/showOrders"></a>
            <h2 class="show-title">Customer</h2>
        </div>
        <div class="item-wrapper">
            <div class="item-pile padding-bt-16">
                <img class="avatar" src="https://i.pravatar.cc/150"/>
                <div class="item-pile-inner-wrapper">
                    <div class="info">
                        <div class="order-info-label">
                            First Name
                        </div>
                        <div class="order-info-value">
                            ${customer.firstName}
                        </div>
                    </div>
                    <div class="info">
                        <div class="order-info-label">
                            Last Name
                        </div>
                        <div class="order-info-value">
                            ${customer.lastName}
                        </div>
                    </div>
                    <div class="info">
                        <div class="order-info-label">
                            Phone number
                        </div>
                        <div class="order-info-value">
                            ${customer.phoneNumber}
                        </div>
                    </div>
                    <div class="info">
                        <div class="order-info-label">
                            Email
                        </div>
                        <div class="order-info-value">
                            ${customer.email}
                        </div>
                    </div>
                    <a class="edit-btn" href="../${customer.customerId}/editCustomer/">Edit</a>
                </div>
            </div>
        </div>
    </body>
</html>