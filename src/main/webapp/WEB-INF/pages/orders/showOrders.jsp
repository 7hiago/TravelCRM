<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 21.01.2022
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<html>
<head>
    <title>Show Orders Page</title>
</head>
<h2>Orders</h2>
<a href="..">Back to main</a></br>
<a href="./createOrder">Create new order</a></br>
<table border="1" cellpadding="2" width="60%">
    <tr>
        <th>Order number</th>
        <th>Tour</th>
        <th>Customer</th>
        <th>Manager</th>
        <th>Tour price</th>
        <th>Data</th>
        <th>Status</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach var="order" items="${orders}">
        <tr style="align-items: center">
            <td>#${order.orderNumber}
            </td>
            <td>
                <a href="../tour/showTour/${order.tour.tourId}">${order.tour.country}</a>
            </td>
            <td>
                <a href="../customers/showCustomer/${order.customer.customerId}">${order.customer.lastName}</a>
            </td>
            <td>
                <a href="../managers/showManager/${order.manager.managerId}">${order.manager.login}</a>
            </td>
            <td>
                <a href="../accounting/showAccounting/${order.accounting.accountingId}">${order.accounting.tourPrice}</a>
            </td>
            <td>${order.date}</td>
            <td>${order.status}</td>
            <td>
                <a href="./${order.orderNumber}/editOrder/">Edit</a>
            </td>
            <td>
                <form:form action="./deleteOrder/${order.orderNumber}" method="delete">
                        <input type="submit" value="Delete"/>
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
<%--<security:authorize access="hasRole('ADMIN')">--%>
<%--    <div><a href="./createOrder">Create new order</a></div>--%>
<%--</security:authorize>--%>
<%--<security:csrfInput/>--%>

</body>
</html>
