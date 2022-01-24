<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 21.01.2022
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Edit Tour Page</title>
</head>
<body>
<h2>Edit tour</h2>
<a href="../../showTour/${command.tourId}">Back to tour</a>
<form:form action="../../saveEditedTour/${command.tourId}" method="patch">
    <table>
        <tr>
            <td>Country:</td>
            <td><form:input path="country"/></td>
        </tr>
        <tr>
            <td>Hotel:</td>
            <td><form:input path="hotel"/></td>
        </tr>
        <tr>
            <td>Departure date:</td>
            <td><form:input path="departureDate"/></td>
        </tr>
        <tr>
            <td>Return date:</td>
            <td><form:input path="returnDate"/></td>
        </tr>
        <tr>
            <td>Proposal number:</td>
            <td><form:input path="proposalNumber"/></td>
        </tr>
        <tr>
            <td>Touroperator Id:</td>
            <td><form:input path="touroperatorId"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit tour"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
