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
<a href="../../showOrders">Back to orders</a>
<form:form action="../../saveEditedOrder/${orderDTO.orderNumber}" method="patch" modelAttribute="orderDTO">
    <table>
        <tr>
            <td>Tour:</td>
            <td>
                <a href="../../../tour/showTour/${orderDTO.tour.tourId}">${orderDTO.tour.country}</a>
            </td>
        </tr>
        <tr>
            <td>Customer:</td>
            <td>
                <a href="../../../customers/showCustomer/${orderDTO.customer.customerId}">${orderDTO.customer.lastName}</a>
            </td>
        </tr>
        <tr>
            <td>Manager:</td>
            <td>
                <label>
                    <form:select path="manager.managerId">
                        <option selected value="${orderDTO.manager.managerId}">${orderDTO.manager.lastName}</option>
                        <c:forEach var="manager" items="${managers}">
                            <option value="${manager.managerId}">${manager.lastName}</option>
                        </c:forEach>
                    </form:select>
                </label>
            </td>
        </tr>
        <tr>
            <td>Tour price:</td>
            <td>
                <a href="../../../accounting/showAccounting/${orderDTO.accounting.accountingId}">${orderDTO.accounting.tourPrice}</a>
            </td>
        </tr>
        <tr>
            <td>Date:</td>
            <td><form:input path="date"/></td>

        </tr>
        <tr>
            <td>Status:</td>
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
