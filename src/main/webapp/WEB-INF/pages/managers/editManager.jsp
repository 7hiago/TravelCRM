<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <title>Edit Manager Page</title>
        <style>
            <%@include file="/WEB-INF/pages/style.css" %>
        </style>
    </head>
    <body>
        <div class="show-title-wrapper">
            <a class="arrow-back" href="../../../managers/showManagers"></a>
            <h2 class="show-title">Edit manager</h2>
        </div>
        <form:form action="../../../managers/saveEditedManager/${command.managerId}" method="post">
            <div class="form">
                <div class="form-row">
                    <div class="input-label">First Name</div>
                    <div><form:input path="firstName"/></div>
                    <div class="error-label"><form:errors path="firstName"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Last Name</div>
                    <div><form:input path="lastName"/></div>
                    <div class="error-label"><form:errors path="lastName"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Salary</div>
                    <div><form:input path="salary"/></div>
                    <div class="error-label"><form:errors path="salary"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Hire Date</div>
                    <div><form:input path="hireDate"/></div>
                    <div class="error-label"><form:errors path="hireDate"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Phone number</div>
                    <div><form:input path="phoneNumber"/></div>
                    <div class="error-label"><form:errors path="phoneNumber"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Email</div>
                    <div><form:input path="email"/></div>
                    <div class="error-label"><form:errors path="email"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Login</div>
                    <div><form:input path="login"/></div>
                    <div class="error-label"><form:errors path="login"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Pass</div>
                    <div><form:input type="password" path="password"/></div>
                    <div class="error-label"><form:errors path="password"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Role</div>
                    <div>
                        <form:select path="role">
                            <option selected value="${command.role}">${command.role}</option>
                            <option value="ADMIN">ADMIN</option>
                            <option value="MANAGER">MANAGER</option>
                        </form:select>
                    </div>
                    <div class="error-label"><form:errors path="role"/></div>
                </div>
                <div class="form-row">
                    <div class="input-label">Role</div>
                    <div>
                        <form:select path="status">
                            <option selected value="${command.status}">${command.status}</option>
                            <option value="ACTIVE">ACTIVE</option>
                            <option value="BANNED">BANNED</option>
                        </form:select>
                    </div>
                    <div class="error-label"><form:errors path="status"/></div>
                </div>
                <br/>
                <div class="form-row">
                    <button type="submit" class="align-center no-top-padding">Edit Manager</button>
                </div>
            </div>
        </form:form>
    </body>
</html>