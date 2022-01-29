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
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>

<div class="show-title-wrapper">
    <a class="arrow-back" href="../../orders/showOrders"></a>
    <h2 class="show-title">Tour</h2>
</div>


<div class="item-wrapper ">
    <div class="item-pile padding-bt-16 tour-wrapper">
        <div class="item-pile-inner-wrapper">
            <div class="info">
                <div class="order-info-label">
                    Country
                </div>
                <div class="order-info-value">
                    ${tourDTO.tour.country}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Hotel:
                </div>
                <div class="order-info-value">
                    ${tourDTO.tour.hotel}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Departure date:
                </div>
                <div class="order-info-value">
                    ${tourDTO.tour.departureDate}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Return date:
                </div>
                <div class="order-info-value">
                    ${tourDTO.tour.returnDate}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Proposal number:
                </div>
                <div class="order-info-value">
                    ${tourDTO.tour.proposalNumber}
                </div>
            </div>

            <div class="info">
                <div class="order-info-label">
                    Touroperator:
                </div>
                <div class="order-info-value">
                    ${tourDTO.touroperator.name}
                </div>
            </div>

            <a class="edit-btn tour-edit-btn" href="../${tourDTO.tour.tourId}/editTour/">Edit</a>
        </div>
    </div>
</div>

</body>
