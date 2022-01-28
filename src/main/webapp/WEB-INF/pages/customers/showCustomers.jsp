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
    <title>Show Customers Page</title>
</head>
<h2>Customers</h2>
<a href="../menuPage">Back to menu</a></br>
<a href="./createCustomer">Create new customer</a>
<table border="1" cellpadding="2" width="60%">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Edit</th>
    </tr>

    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.phoneNumber}</td>
            <td>${customer.email}</td>
            <td>
                <a href="./${customer.customerId}/editCustomer/">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
