<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <title>Edit Touroperator Page</title>
        <style>
            <%@include file="/WEB-INF/pages/style.css" %>
        </style>
    </head>
    <body>
        <div class="show-title-wrapper">
            <a class="arrow-back" href="../../../touroperators/showTouroperators"></a>
            <h2 class="show-title">Edit touroperator</h2>
        </div>
        <form:form action="../../../touroperators/saveEditedTouroperator/${command.touroperatorId}" method="post">
            <div class="form">
                <div class="form-row">
                    <div class="input-label">Name</div>
                    <div><form:input path="name"/></div>
                    <div class="error-label"><form:errors path="name"/></div>
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
                <br/>
                <div class="form-row">
                    <button type="submit" class="align-center no-top-padding">Edit touroperator</button>
                </div>
            </div>
        </form:form>
    </body>
</html>