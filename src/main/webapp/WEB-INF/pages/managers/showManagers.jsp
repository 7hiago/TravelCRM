<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
    <head>
        <title>Show Managers Page</title>
        <style>
            <%@include file="/WEB-INF/pages/style.css" %>
        </style>
    </head>
    <body>
        <div class="show-title-wrapper">
            <a class="arrow-back" href="../menuPage"></a>
            <h2 class="show-title">Managers</h2>
            <a class="btn create-btn" href="./createManager"></a>
        </div>
        <div class="item-wrapper">
            <c:forEach var="manager" items="${managers}">
                <div class="item-pile padding-bt-16">
                    <img class="avatar" src=""/>
                    <div class="item-pile-inner-wrapper">
                        <div class="info">
                            <div class="order-info-label">
                                First Name
                            </div>
                            <div class="order-info-value">
                                    ${manager.firstName}
                            </div>
                        </div>
                        <div class="info">
                            <div class="order-info-label">
                                Last Name
                            </div>
                            <div class="order-info-value">
                                    ${manager.lastName}
                            </div>
                        </div>
                        <div class="info">
                            <div class="order-info-label">
                                Salary
                            </div>
                            <div class="order-info-value">
                                    ${manager.salary}
                            </div>
                        </div>
                        <div class="info">
                            <div class="order-info-label">
                                Hire Date
                            </div>
                            <div class="order-info-value">
                                    ${manager.hireDate}
                            </div>
                        </div>
                        <div class="info">
                            <div class="order-info-label">
                                Phone NUmber
                            </div>
                            <div class="order-info-value">
                                    ${manager.phoneNumber}
                            </div>
                        </div>
                        <div class="info">
                            <div class="order-info-label">
                                Email
                            </div>
                            <div class="order-info-value">
                                    ${manager.email}
                            </div>
                        </div>
                        <div class="info">
                            <div class="order-info-label">
                                Login
                            </div>
                            <div class="order-info-value">
                                    ${manager.login}
                            </div>
                        </div>
                        <div class="info">
                            <div class="order-info-label">
                                Role
                            </div>
                            <div class="order-info-value">
                                    ${manager.role}
                            </div>
                        </div>
                        <div class="info">
                            <div class="order-info-label">
                                Status
                            </div>
                            <div class="order-info-value">
                                    ${manager.status}
                            </div>
                        </div>
                        <a class="edit-btn" href="./${manager.managerId}/editManager/">Edit</a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <script defer>
            const avatars = document.getElementsByClassName('avatar');
            const min = 35;
            const max = 49;

            Array.from(avatars).forEach((avatar) => {
                const randomImgID = Math.floor(Math.random() * (max - min + 1)) + min;
                avatar.setAttribute('src', 'https://i.pravatar.cc/150?img=' + randomImgID);
            })
        </script>
    </body>
</html>