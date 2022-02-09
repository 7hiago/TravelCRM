<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Edit Tour Page</title>
        <style>
            <%@include file="/WEB-INF/pages/style.css" %>
        </style>
    </head>
    <body>
        <div class="show-title-wrapper">
            <a class="arrow-back" href="../../showTour/${tourDTO.tour.tourId}"></a>
            <h2 class="show-title">Edit tour</h2>
        </div>
        <form:form action="../../saveEditedTour/${tourDTO.tour.tourId}" method="patch" modelAttribute="tourDTO">
            <div class="form">
                <div class="form-row">
                    <div class="input-label">Country:</div>
                    <form:input path="tour.country"/>
                </div>
                <div class="form-row">
                    <div class="input-label">Hotel:</div>
                    <form:input path="tour.hotel"/>
                </div>
                <div class="form-row">
                    <div class="input-label">Departure date</div>
                    <form:input type = "date" path="tour.departureDate"/>
                </div>
                <div class="form-row">
                    <div class="input-label">Return date</div>
                    <div><form:input type = "date" path="tour.returnDate"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Proposal number</div>
                    <div><form:input path="tour.proposalNumber"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Tour operator</div>
                    <label>
                        <form:select path="tour.touroperatorId">
                            <option selected value="${tourDTO.tour.touroperatorId}">${tourDTO.touroperator.name}</option>
                            <c:forEach var="touroperator" items="${touroperators}">
                                <option value="${touroperator.touroperatorId}">${touroperator.name}</option>
                            </c:forEach>
                        </form:select>
                    </label>
                </div>
                <button type="submit" class="align-center">Edit tour</button>
            </div>
        </form:form>
    </body>
</html>