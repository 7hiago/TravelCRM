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
    <title>Edit Accounting Page</title>
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>

<div class="show-title-wrapper">
    <a class="arrow-back" href="../../showAccounting/${command.accountingId}"></a>
    <h2 class="show-title">Edit accounting</h2>
</div>


<form:form action="../../saveEditedAccounting/${command.accountingId}" method="patch">
    <div class="form">
        <div class="form-row">
            <div class="input-label">Tour price</div>
            <form:input path="tourPrice"/>
        </div>
        <div class="form-row">
            <div class="input-label">Tour paid</div>
            <form:input path="tourPaid"/>
        </div>
        <div class="form-row">
            <div class="input-label">Commission in $</div>
            <form:input path="commission"/>
        </div>
        <div class="form-row">
            <div class="input-label">Tour operator price</div>
            <form:input path="touroperatorPrice"/>
        </div>
        <div class="form-row">
            <div class="input-label">Tour operator paid</div>
            <form:input path="touroperatorPaid"/>
        </div>
        <div class="form-row">
            <div class="input-label">Profit</div>
            <form:input path="profit"/>
        </div>

        <button type="submit" class="align-center">Edit accounting</button>
    </div>

</form:form>
</body>
</html>
