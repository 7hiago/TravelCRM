<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 21.01.2022
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
    <head>
        <title>Show Touroperators Page</title>
    </head>
    <body>
        <h2>Touroperators</h2>
        <a href="..">Back to main</a></br>
        <a href="../touroperators/createTouroperator">Create new touroperator</a>
        <table border="1" cellpadding="2" width="60%">
            <tr>
                <th>Name</th>
                <th>Phone number</th>
                <th>Email</th>
                <th></th>
            </tr>

            <c:forEach var="touroperator" items="${touroperators}">
                <tr>
                    <td>${touroperator.name}</td>
                    <td>${touroperator.phoneNumber}</td>
                    <td>${touroperator.email}</td>
                    <td>
                        <a href="./${touroperator.touroperatorId}/editTouroperator/">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
