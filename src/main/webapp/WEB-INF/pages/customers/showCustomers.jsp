<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 21.01.2022
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
<head>
    <title>Show Customers Page</title>
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>

<div class="show-title-wrapper">
    <a class="arrow-back" href="../menuPage"></a>
    <h2 class="show-title">Customers</h2>
    <a class="btn create-btn" href="./createCustomer"></a>
</div>

<br/>

<div class="item-wrapper">
    <c:forEach var="customer" items="${customers}">
        <div class="item-pile padding-bt-16">
            <img class="avatar" src=""/>

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
                        Phone Number
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

                <a class="edit-btn" href="./${customer.customerId}/editCustomer/">Edit</a>
            </div>
        </div>

    </c:forEach>
</div>
<script>
    const avatars = document.getElementsByClassName('avatar');
    const min = 1;
    const max = 70;

    Array.from(avatars).forEach((avatar) => {
        const randomImgID = Math.floor(Math.random() * (max - min + 1)) + min;
        avatar.setAttribute('src', 'https://i.pravatar.cc/150?img=' + randomImgID);
    })
</script>
</body>
</html>
