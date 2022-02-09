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
            <h1 class="error-title">500</h1>
            <div class="error-description">${message}</div>
            <a class="btn error-btn" href="../../../menuPage">Back to menu</a>
        </div>
    </body>
</html>
