<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 21.01.2022
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Edit Order Page</title>
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>

<div class="show-title-wrapper">
    <a class="arrow-back" href="../../showOrders"></a>
    <h2 class="show-title">Edit order</h2>
</div>

<form:form action="../../saveEditedOrder/${orderDTO.orderNumber}" method="patch" modelAttribute="orderDTO">
    <div class="form">
        <security:authorize access="hasRole('ADMIN')">
            <div class="form-row">
                <div class="input-label">Manager</div>
                <label>
                    <form:select path="manager.managerId">
                        <option selected value="${orderDTO.manager.managerId}">${orderDTO.manager.lastName}</option>
                        <c:forEach var="manager" items="${managers}">
                            <option value="${manager.managerId}">${manager.lastName}</option>
                        </c:forEach>
                    </form:select>
                </label>
            </div>
        </security:authorize>

        <div class="form-row">
            <div class="input-label">Date (yyyy-MM-dd)</div>
            <form:input path="date"/>
        </div>

        <div class="form-row">
            <div class="input-label">Status</div>
            <form:input path="status"/>
        </div>

        <div class="form-row">
            <button type="submit" class="align-center no-top-padding">Edit order</button>
        </div>
    </div>
</form:form>
</body>
</html>
