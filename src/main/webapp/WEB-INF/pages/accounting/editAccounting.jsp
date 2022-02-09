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
            <a class="arrow-back" href="../../../accounting/showAccounting/${command.accountingId}"></a>
            <h2 class="show-title">Edit accounting</h2>
        </div>
        <form:form action="../../../accounting/saveEditedAccounting/${command.accountingId}" method="post">
            <div class="form">
                <div class="form-row">
                    <div class="input-label">Tour price</div>
                    <div><form:input path="tourPrice"/></div>
                    <div class="error-label"><form:errors path="tourPrice"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Tour paid</div>
                    <div><form:input path="tourPaid"/></div>
                    <div class="error-label"><form:errors path="tourPaid"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Commission in %</div>
                    <div><form:input path="commission"/></div>
                    <div class="error-label"><form:errors path="commission"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Tour operator price</div>
                    <div><form:input path="touroperatorPrice"/></div>
                    <div class="error-label"><form:errors path="touroperatorPrice"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Tour operator paid</div>
                    <div><form:input path="touroperatorPaid"/></div>
                    <div class="error-label"><form:errors path="touroperatorPaid"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Profit</div>
                    <div><form:input path="profit"/></div>
                    <div class="error-label"><form:errors path="profit"/></div>
                </div>
                <button type="submit" class="align-center">Edit accounting</button>
            </div>
        </form:form>
    </body>
</html>