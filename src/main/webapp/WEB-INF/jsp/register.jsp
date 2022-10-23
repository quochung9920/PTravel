<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container d-flex justify-content-center">
    <sec:authorize access="hasRole('ROLE_ADMIN')">  
        <c:url value="/admin/add-user" var="action" />
    </sec:authorize>
    <sec:authorize access="!hasRole('ROLE_ADMIN')">
        <c:url value="/register" var="action" />
    </sec:authorize>

    <form:form method="post" action="${action}" modelAttribute="user" class="w-50">
        <h1 class="m-4 text-center">Đăng ký</h1>
        <div class="form-group m-4">
            <label for="email" class="h5">Email</label>
            <form:input type="email" class="form-control" id="email" path="email" placeholder="ptravel@gmail.com" />
            <form:errors path="email" class="text-danger" element="div" />
        </div>
        <div class="form-group m-4">
            <label for="username" class="h5">Tài khoản</label>
            <form:input type="username" class="form-control" id="username" path="username" placeholder="ptravel" />
            <form:errors path="username" class="text-danger" element="div" />
        </div>
        <div class="form-group m-4">
            <label for="password" class="h5">Mật khẩu</label>
            <form:input type="password" class="form-control" id="password" path="password" placeholder="6+ ký tự" />
            <form:errors path="password" class="text-danger" element="div" />
        </div>
        <div class="form-group m-4">
            <label for="confirm-password" class="h5">Xác nhận mật khẩu</label>
            <form:input type="password" class="form-control" id="confirm-password" path="confirmPassword" placeholder="Xác nhận lại mật khẩu" />
            <form:errors path="confirmPassword" class="text-danger" element="div" />
        </div>
        <sec:authorize access="hasRole('ROLE_ADMIN')">  
            <div class="form-group m-4">
                <label for="confirm-password" class="h5">Cấp bậc</label>
                <form:select path="userRole">  
                    <form:option value="${roleStaff}" label="Nhân viên"/>  
                    <form:option value="${roleUser}" label="Người dùng"/>  
                </form:select>  
            </div>
        </sec:authorize>
        <div class="form-group m-4 d-flex justify-content-center">
            <input type="submit" value="Đăng ký" class="btn btn-primary h5 w-50" />
        </div>
    </form:form>
</div>