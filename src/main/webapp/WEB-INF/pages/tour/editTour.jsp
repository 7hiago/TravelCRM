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
    <title>Edit Tour Page</title>
</head>
<body>
<h2>Edit tour</h2>
<a href="../../showTour/${tourDTO.tour.tourId}">Back to tour</a>
<form:form action="../../saveEditedTour/${tourDTO.tour.tourId}" method="patch" modelAttribute="tourDTO">
    <table>
        <tr>
            <td>Country:</td>
            <td><form:input path="tour.country"/></td>
        </tr>
        <tr>
            <td>Hotel:</td>
            <td><form:input path="tour.hotel"/></td>
        </tr>
        <tr>
            <td>Departure date:</td>
            <td><form:input path="tour.departureDate"/></td>
        </tr>
        <tr>
            <td>Return date:</td>
            <td><form:input path="tour.returnDate"/></td>
        </tr>
        <tr>
            <td>Proposal number:</td>
            <td><form:input path="tour.proposalNumber"/></td>
        </tr>
        <tr>
            <td>Touroperator:</td>
            <td>
                <label>
                    <form:select path="tour.touroperatorId">
                        <option selected value="${tourDTO.tour.touroperatorId}">${tourDTO.touroperator.name}</option>
                        <c:forEach var="touroperator" items="${touroperators}">
                            <option value="${touroperator.touroperatorId}">${touroperator.name}</option>
                        </c:forEach>
                    </form:select>
                </label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit tour"></td>
        </tr>
    </table>
</form:form>
</body>
</html>