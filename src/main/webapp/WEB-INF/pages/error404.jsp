<%--
  Created by IntelliJ IDEA.
  User: thiago
  Date: 29.01.2022
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/pages/style.css" %>
    </style>
</head>
<body>
    <div class="error">
        <h1 class="error-title">404</h1>
        <div class="error-description">${message}</div>
        <a class="btn error-btn" href="../menuPage">Back</a>
    </div>
</body>
</html>
