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
    <title>Create Customer Page</title>
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>

<div class="show-title-wrapper">
    <a class="arrow-back" href="./showCustomers"></a>
    <h2 class="show-title">Create customer</h2>
</div>

<form:form action="saveCreatedCustomer" method="post">
    <div class="form">
        <div class="form-row">
            <div class="input-label">First Name</div>
            <div><form:input path="firstName"/></div>
            <div class="error-label"><form:errors path="firstName"/></div>
        </div>

        <div class="form-row">
            <div class="input-label">Last Name</div>
            <div><form:input path="lastName"/></div>
            <div class="error-label"><form:errors path="lastName"/></div>
        </div>
        <div class="form-row">
            <div class="input-label">Phone number</div>
            <div><form:input path="phoneNumber"/></div>
            <div class="error-label"><form:errors path="phoneNumber"/></div>
        </div>
        <div class="form-row">
            <div class="input-label">Email</div>
            <div><form:input path="email"/></div>
            <div class="error-label"><form:errors path="email"/></div>
        </div>

        <button type="submit" class="align-center">Create customer</button>
    </div>

</form:form>
</body>
</html>
