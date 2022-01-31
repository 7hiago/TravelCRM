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
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>
<div class="show-title-wrapper">
    <a class="arrow-back" href="../menuPage"></a>
    <h2 class="show-title">Touroperators</h2>
    <a class="btn create-btn" href="./createTouroperator"></a>
</div>

<br/>

<div class="item-wrapper">
    <c:forEach var="touroperator" items="${touroperators}">
        <div class="item-pile padding-bt-16">
            <div class="item-pile-inner-wrapper">

                <h3 class="item-pile-header">
                        ${touroperator.name}
                </h3>

                <div class="info">
                    <div class="info-label">
                        Phone Number
                    </div>
                    <div class="info-value">
                            ${touroperator.phoneNumber}
                    </div>
                </div>

                <div class="info">
                    <div class="info-label">
                        Email
                    </div>
                    <div class="info-value">
                            ${touroperator.email}
                    </div>
                </div>

                <a class="edit-btn" href="./${touroperator.touroperatorId}/editTouroperator/">Edit</a>
            </div>
        </div>

    </c:forEach>
</div>

</body>
</html>
