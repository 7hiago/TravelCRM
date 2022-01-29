<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 25.01.2022
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Order Page</title>
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>

<div class="show-title-wrapper">
    <a class="arrow-back" href="./showOrders"></a>
    <h2 class="show-title">Create order</h2>
</div>

<form:form action="saveCreatedOrder" method="post" modelAttribute="createOrderDTO">
    <div class="create-order-form">
        <div class="crate-order-wrapper item-wrapper">
            <h3>Tour</h3>

            <div class="form-row full-width">
                <div class="input-label">Country</div>
                <form:input path="tour.country"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Hotel</div>
                <form:input path="tour.hotel"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Departure date</div>
                <form:input path="tour.departureDate"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Return date</div>
                <form:input path="tour.returnDate"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Proposal number</div>
                <form:input path="tour.proposalNumber"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Tour operator</div>
                <label>
                    <form:select path="tour.touroperatorId">
                        <c:forEach var="touroperator" items="${touroperators}">
                            <option value="${touroperator.touroperatorId}">${touroperator.name}</option>
                        </c:forEach>
                    </form:select>
                </label>
            </div>
        </div>

        <div class="crate-order-wrapper item-wrapper">
            <h3>Customer</h3>

            <div class="form-row full-width">
                <div class="input-label">First name</div>
                <form:input path="customer.firstName"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Last name</div>
                <form:input path="customer.lastName"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Email</div>
                <form:input path="customer.email"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Phone number</div>
                <form:input path="customer.phoneNumber"/>
            </div>

        </div>

        <div class="crate-order-wrapper item-wrapper">
            <h3>Accounting</h3>

            <div class="form-row full-width">
                <div class="input-label">Tour price</div>
                <form:input path="accounting.tourPrice"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Tour paid</div>
                <form:input path="accounting.tourPaid"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Commission</div>
                <form:input path="accounting.commission"/>
            </div>

            <div class="form-row full-width">
                <div class="input-label">Tour operator price</div>
                <form:input path="accounting.touroperatorPrice"/>
            </div>
        </div>

        <button type="submit" class="create-order-btn">Create order</button>
    </div>


</form:form>
</body>
</html>
