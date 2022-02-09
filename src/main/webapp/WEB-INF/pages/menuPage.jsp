<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
    <head>
        <title>Main Page of TravelCRM</title>
        <style>
            <%@include file="/WEB-INF/pages/style.css" %>
        </style>
    </head>
    <body>
        <h2>Menu</h2>
        <div class="pile-wrapper">
            <a class="pile" href="./orders/showOrders">Orders</a>
            <security:authorize access="hasRole('ADMIN')">
                <a class="pile" href="./managers/showManagers">Managers</a>
            </security:authorize>
            <security:csrfInput/>
            <a class="pile" href="./customers/showCustomers">Customers</a>
            <a class="pile" href="./touroperators/showTouroperators">Touroperators</a>
            <form action="./logout" method="POST">
                <button type="submit">Logout</button>
            </form>
        </div>
    </body>
</html>