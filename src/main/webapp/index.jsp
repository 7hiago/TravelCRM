<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Main Page of TravelCRM</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Menu</h2>--%>
<%--<ul>--%>
<%--    <li><a href="orders/showOrders">Orders</a></li>--%>
<%--    <security:authorize access="hasRole('ADMIN')">--%>
<%--    <li><a href="managers/showManagers">Managers</a></li>--%>
<%--    </security:authorize>--%>
<%--    <security:csrfInput/>--%>
<%--    <li><a href="customers/showCustomers">Customers</a></li>--%>
<%--    <li><a href="touroperators/showTouroperators">Touroperators</a></li>--%>
<%--    <li><a href="logout">Logout</a></li>--%>
<%--</ul>--%>
<%--</body>--%>
<%--</html>--%>

<html>
<head>
    <title>index</title>
</head>
<body>
<script>
    document.getElementById('mybutton').onload = function() {
        window.location.href = './menuPage';
    };
</script>
<h1>Welcome to Travel CRM</h1>
<h2>To start work press <a href="./menuPage">here</a></h2>
</body>
</html>