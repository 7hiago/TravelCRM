<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 25.01.2022
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Create Order Page</title>
</head>
<body>
<h2>Create order</h2>
<a href="./showOrders">Back to orders</a>
<form:form action="saveCreatedOrder" method="post" modelAttribute="createOrderDTO">
    <table>
    <%--row 1--%>
        <tr>
        <%--Tour column--%>
            <th>Tour</th>
            <th></th>
        <%--Customer column--%>
            <th>Customer</th>
            <th></th>
        <%--Accounting column--%>
            <th>Accounting</th>
            <th></th>
        <%--Manager column--%>
            <th>Manager</th>
            <th></th>
        <%--Data column--%>
            <th>Data</th>
            <th></th>
        <%--Status column--%>
            <th>Status</th>
            <th></th>
        </tr>
    <%--row 2--%>
        <tr>
        <%--Tour column--%>
            <td>Country:</td>
            <td><form:input path="tour.country"/></td>
        <%--Customer column--%>
            <td>First name:</td>
            <td><form:input path="customer.firstName"/></td>
        <%--Accounting column--%>
            <td>Tour price:</td>
            <td><form:input path="accounting.tourPrice"/></td>
        <%--Manager column--%>
            <td>Name:</td>
            <td>
                <label>
                    <form:select path="selectedManagerId">
                        <c:forEach var="manager" items="${managers}">
                            <option value="${manager.managerId}">${manager.login}</option>
                        </c:forEach>
                    </form:select>
                </label>
            </td>
        <%--Data column--%>
            <td>Date</td>
            <td><form:input path="date"/></td>
        <%--Status column--%>
            <td>Status</td>
            <td><form:input path="status"/></td>
        </tr>
    <%--row 3--%>
        <tr>
        <%--Tour column--%>
            <td>Hotel:</td>
            <td><form:input path="tour.hotel"/></td>
        <%--Customer column--%>
            <td>Last name:</td>
            <td><form:input path="customer.lastName"/></td>
        <%--Accounting column--%>
            <td>Tour paid:</td>
            <td><form:input path="accounting.tourPaid"/></td>
        <%--Manager column--%>
            <td></td>
            <td></td>
        <%--Data column--%>
            <td></td>
            <td></td>
        <%--Status column--%>
            <td></td>
            <td></td>
        </tr>
    <%--row 4--%>
        <tr>
        <%--Tour column--%>
            <td>Departure date:</td>
            <td><form:input path="tour.departureDate"/></td>
        <%--Customer column--%>
            <td>Phone number:</td>
            <td><form:input path="customer.phoneNumber"/></td>
        <%--Accounting column--%>
            <td>Commission:</td>
            <td><form:input path="accounting.commission"/></td>
        <%--Manager column--%>
            <td></td>
            <td></td>
        <%--Data column--%>
            <td></td>
            <td></td>
        <%--Status column--%>
            <td></td>
            <td></td>
        </tr>
    <%--row 5--%>
        <tr>
        <%--Tour column--%>
            <td>Return date:</td>
            <td><form:input path="tour.returnDate"/></td>
        <%--Customer column--%>
            <td>Email:</td>
            <td><form:input path="customer.email"/></td>
        <%--Accounting column--%>
            <td>Touroperator price:</td>
            <td><form:input path="accounting.touroperatorPrice"/></td>
        <%--Manager column--%>
            <td></td>
            <td></td>
        <%--Data column--%>
            <td></td>
            <td></td>
        <%--Status column--%>
            <td></td>
            <td></td>
        </tr>
    <%--row 6--%>
        <tr>
        <%--Tour column--%>
            <td>Proposal number:</td>
            <td><form:input path="tour.proposalNumber"/></td>
        <%--Customer column--%>
            <td></td>
            <td></td>
        <%--Accounting column--%>
            <td></td>
            <td></td>
        <%--Manager column--%>
            <td></td>
            <td></td>
        <%--Data column--%>
            <td></td>
            <td></td>
        <%--Status column--%>
            <td></td>
            <td></td>

        </tr>
    <%--row 7--%>
        <tr>
        <%--Tour column--%>
            <td>Touroperator:</td>
            <td>
                <label>
                    <form:select path="tour.touroperatorId">
                        <c:forEach var="touroperator" items="${touroperators}">
                            <option value="${touroperator.touroperatorId}">${touroperator.name}</option>
                        </c:forEach>
                    </form:select>
                </label>
            </td>
        <%--Customer column--%>
            <td></td>
            <td></td>
        <%--Accounting column--%>
            <td></td>
            <td></td>
        <%--Manager column--%>
            <td></td>
            <td></td>
        <%--Data column--%>
            <td></td>
            <td></td>
        <%--Status column--%>
            <td></td>
            <td></td>
        </tr>
    <%--row 8--%>
        <tr>
        <%--Tour column--%>
            <td></td>
            <td></td>
        <%--Customer column--%>
            <td></td>
            <td></td>
        <%--Accounting column--%>
            <td></td>
            <td></td>
        <%--Manager column--%>
            <td></td>
            <td></td>
        <%--Data column--%>
            <td></td>
            <td></td>
        <%--Status column--%>
            <td></td>
            <td><input type="submit" value="Create order"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
