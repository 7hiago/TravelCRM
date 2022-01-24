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
    <title>Edit Accounting Page</title>
</head>
<body>
<h2>Edit accounting</h2>
<a href="../../showAccounting/${command.accountingId}">Back to accounting</a>
<form:form action="../../saveEditedAccounting/${command.accountingId}" method="patch">
    <table>
        <tr>
            <td>Tour price:</td>
            <td><form:input path="tourPrice"/></td>
        </tr>
        <tr>
            <td>Tour paid:</td>
            <td><form:input path="tourPaid"/></td>
        </tr>
        <tr>
            <td>Commission:</td>
            <td><form:input path="commission"/></td>
        </tr>
        <tr>
            <td>Touroperator price:</td>
            <td><form:input path="touroperatorPrice"/></td>
        </tr>
        <tr>
            <td>Touroperator paid:</td>
            <td><form:input path="touroperatorPaid"/></td>
        </tr>
        <tr>
            <td>Profit:</td>
            <td><form:input path="profit"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit accounting"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
