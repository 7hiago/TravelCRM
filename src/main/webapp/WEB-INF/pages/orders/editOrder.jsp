<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 21.01.2022
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Order Page</title>
</head>
<body>
<h2>Edit order</h2>
<a href="../../showOrders">Back to main</a>
<form:form action="../../saveEditedOrder/${order.orderNumber}" method="patch" modelAttribute="editOrderDTO">
    <table>
        <tr>
            <th></th>
            <th>Current data</th>
            <th>New data</th>
        </tr>
        <tr>
            <td>Tour:</td>
            <td>
                <a href="../tour/showTour/${order.tour.tourId}">${order.tour.country}</a>
            </td>
<%--            <td><form:input path="tourId"/></td>--%>
            <td></td>
        </tr>
        <tr>
            <td>Customer:</td>
            <td>
                <a href="../customers/showCustomer/${order.customer.customerId}">${order.customer.lastName}</a>
            </td>
<%--            <td><form:input path="customerId"/></td>--%>
            <td></td>
        </tr>
        <tr>
            <td>Current manager:</td>
            <td>${order.manager.lastName}</td>
<%--            <td><form:input path="managerId"/></td>--%>
            <td>
                <label>
                    <form:select path="managerId">
                        <c:forEach var="manager" items="${managers}">
                            <option value="${manager.managerId}">${manager.lastName}</option>
                        </c:forEach>
                    </form:select>
                </label>
            </td>
                <%--            <td><form:input path="managerId"/></td>--%>
        </tr>
        <tr>
            <td>Accounting price:</td>
            <td>
                <a href="../accounting/showAccounting/${order.accounting.accountingId}">${order.accounting.tourPrice}</a>
            </td>
<%--        <td><form:input path="accountingId"/></td>--%>
            <td></td>
        </tr>
        <tr>
            <td>Date:</td>
            <td>${order.date}</td>
            <td><form:input path="date"/></td>

        </tr>
        <tr>
            <td>Status:</td>
            <td>${order.status}</td>
            <td><form:input path="status"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit order"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
