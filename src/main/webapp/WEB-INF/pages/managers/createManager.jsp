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
    <title>Create Manager Page</title>
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>

<div class="show-title-wrapper">
    <a class="arrow-back" href="./showManagers"></a>
    <h2 class="show-title">Create manager</h2>
</div>


<form:form action="saveCreatedManager" method="post">
    <div class="form">
        <div class="form-row">
            <div class="input-label">First Name</div>
            <form:input path="firstName"/>
        </div>

        <div class="form-row">
            <div class="input-label">Last Name</div>
            <form:input path="lastName"/>
        </div>

        <div class="form-row">
            <div class="input-label">Salary</div>
            <form:input path="salary"/>
        </div>

        <div class="form-row">
            <div class="input-label">Hire Date</div>
            <form:input path="hireDate"/>
        </div>

        <div class="form-row">
            <div class="input-label">Phone number</div>
            <div><form:input path="phoneNumber"/></div>
        </div>
        <div class="form-row">
            <div class="input-label">Email</div>
            <div><form:input path="email"/></div>
        </div>

        <div class="form-row">
            <div class="input-label">Login</div>
            <div><form:input path="login"/></div>
        </div>


        <div class="form-row">
            <div class="input-label">Pass</div>
            <div><form:input type="password" path="password" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2, 3}$"/></div>
        </div>

        <div class="form-row">
            <div class="input-label">Role</div>
            <div>
                <form:select path="role">
                    <option selected value="${command.role}">${command.role}</option>
                    <option value="ADMIN">ADMIN</option>
                    <option value="MANAGER">MANAGER</option>
                </form:select>
            </div>
        </div>

        <div class="form-row">
            <div class="input-label">Status</div>
            <div>
                <form:select path="status">
                    <option selected value="${command.status}">${command.status}</option>
                    <option value="ACTIVE">ACTIVE</option>
                    <option value="BANNED">BANNED</option>
                </form:select>
            </div>
        </div>

        <br/>
        <div class="form-row">
            <button type="submit" class="align-center no-top-padding">Create manager</button>
        </div>
    </div>
</form:form>
</body>
</html>
