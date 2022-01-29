<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 21.01.2022
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Create Touroperator Page</title>
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>

<div class="show-title-wrapper">
    <a class="arrow-back" href="./showTouroperators"></a>
    <h2 class="show-title">Create touroperator</h2>
</div>

<form:form action="saveCreatedTouroperator" method="post">
    <div class="form">
        <div class="form-row">
            <div class="input-label">Name</div>
            <form:input path="name"/>
        </div>

        <div class="form-row">
            <div class="input-label">Phone number:</div>
            <div><form:input path="phoneNumber"/></div>
        </div>
        <div class="form-row">
            <div class="input-label">Email:</div>
            <div><form:input path="email"/></div>
        </div>
        <br/>
        <div class="form-row">
            <button type="submit" class="align-center no-top-padding">Create touroperator</button>
        </div>
    </div>

</form:form>
</body>
</html>
