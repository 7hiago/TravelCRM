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
    <title>Show Orders Page</title>
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>

</head>
<div class="show-order-title-wrapper">
    <a class="arrow-back" href="../menuPage"></a>
    <h2 class="show-order-title">Orders</h2>
</div>
<a class="btn create-order-btn" href="./createOrder">Create new order</a></br>

<div class="order-wrapper">
    <c:forEach var="order" items="${orders}">
        <div class="order-pile">
            <image class="order-image" src=""/>
            <div class="order-pile-inner-wrapper">
                <div class="order-info">
                    <div class="order-info-label">
                        Order number
                    </div>
                    <div class="order-info-value">
                        ${order.orderNumber}
                    </div>
                </div>

                <a class="order-info" href="../tour/showTour/${order.tour.tourId}">
                    <div class="order-info-label">
                        Tour
                    </div>
                    <div class="order-info-value">
                            ${order.tour.country}
                    </div>
                </a>

                <a class="order-info" href="../customers/showCustomer/${order.customer.customerId}">
                    <div class="order-info-label">
                        Customer
                    </div>
                    <div class="order-info-value">
                            ${order.customer.lastName}
                    </div>
                </a>
                <security:authorize access="hasRole('ADMIN')">
                <a class="order-info" href="../managers/showManager/${order.manager.managerId}">
                    <div class="order-info-label">
                        Manager
                    </div>
                    <div class="order-info-value">
                            ${order.manager.firstName}
                    </div>
                </a>
                </security:authorize>
                <a class="order-info" href="../accounting/showAccounting/${order.accounting.accountingId}">
                    <div class="order-info-label">
                        Tour Price
                    </div>
                    <div class="order-info-value">
                            ${order.accounting.tourPrice}
                    </div>
                </a>

                <div class="order-info">
                    <div class="order-info-label">
                        Data
                    </div>
                    <div class="order-info-value">
                            ${order.date}
                    </div>
                </div>

                <div class="order-info">
                    <div class="order-info-label">
                        Status
                    </div>
                    <div class="order-info-value">
                            ${order.status}
                    </div>
                </div>

                <a class="edit-btn" href="./${order.orderNumber}/editOrder/">Edit</a>
                <form:form action="./deleteOrder/${order.orderNumber}" method="delete">
                    <button class="btn delete-btn" type="submit">Delete</button>
                </form:form>
            </div>
        </div>
    </c:forEach>
</div>

<script>
    const words = ['beach', 'islands', 'sunset', 'sunrise', 'sea', 'mountains', 'countryside', 'resorts', 'hotels', 'summer'];
    const images = document.getElementsByClassName('order-image');
    const uniqueItems = [];

    Array.from(images).forEach((image, index) => {
        words.forEach(() => {
            const randomKey = Math.ceil(((Math.random() * 10) * words.length) / 10);
            uniqueItems.push(words[randomKey]);
        })

        image.setAttribute('src', 'https://source.unsplash.com/400x400/?' + uniqueItems[index])
    });
</script>

</body>
</html>
