<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="container-fluid py-4">
    <div class="container row">
        <div class="col-md-3">
            <c:url value="/info-user/${user.id}" var="userUpdateAvatar" />
            <form:form method="POST" action="${userUpdateAvatar}" 
                modelAttribute="uploadAvatar" enctype="multipart/form-data">
            
                <c:if test="${user.avatar != null}">
                    <img src="<c:url value="/images/avatar/${user.avatar}" />" class="img-fluid img-thumbnail" alt="Ảnh đại diện">
                </c:if>
                <c:if test="${user.avatar == null}">
                    <img src="https://scontent.fdad1-3.fna.fbcdn.net/v/t1.30497-1/143086968_2856368904622192_1959732218791162458_n.png?stp=dst-png_p100x100&_nc_cat=1&ccb=1-7&_nc_sid=7206a8&_nc_ohc=K9rdFgMILKMAX944AOU&_nc_ht=scontent.fdad1-3.fna&oh=00_AT_xohpkUiUejkwb7-of_CFseGiXLmOywVu8Wl28Zn77vQ&oe=632963F8" class="img-fluid img-thumbnail" alt="Ảnh đại diện">
                </c:if>
                <input type="file" id="avatarFile" accept=".jpg, .png" name="avatarFile" cssClass="form-control"/>
                <input type="submit" value="Submit" />
            
            </form:form>
        </div>
        <form class="row col-md-9">
            
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <div class="py-4">
                        <div class="text-center h1">Thông tin tài khoản</div>
                        <form:errors path="*" class="text-danger" element="div" />
                    </div>
                    <div class="form-group py-2">
                        <label for="last-name" class="form-label h5">Họ</label>
                        <input type="text" class="form-control" id="lastName" placeholder="Họ" value="${user.lastName}">
                        
                    </div>
                    <div class="form-group py-2">
                        <label for="first-name" class="form-label h5">Tên</label>
                        <input type="text" class="form-control" id="firstName" placeholder="Tên"value="${user.firstName}">
                    </div>
                    <div class="form-group py-2">
                        <label for="email" class="form-label h5">Email</label>
                        <input type="email" class="form-control" id="email" value="${user.email}" placeholder="Email" <sec:authorize access="!hasRole('ROLE_ADMIN')">readonly</sec:authorize> />
                    </div>
                    <div class="form-group py-2">
                        <label for="phone" class="form-label h5">Số điện thoại</label>
                        <input type="text" class="form-control" id="phone" value="${user.phone}" placeholder="Số điện thoại" />
                    </div>
                    <div class="form-group py-2">
                        <label for="username" class="form-label h5">Tài khoản</label>
                        <input type="text" class="form-control" id="username" value="${user.username}" placeholder="Tài khoản" />
                    </div>
                    <div class="form-group py-2">
                        <label for="password" class="form-label h5">Mật khẩu</label>
                        <input type="text" class="form-control" id="password" value="${user.password}" placeholder="Số điện thoại" />
                    </div>
                    <c:url value="/api/users/${user.id}" var="updateUser" />
                    <input type="button" onclick=" updateUser('${updateUser}')" class="btn btn-primary w-25"  value="Cập nhật">
                </div>
            </div>
        </form>
    </div>
</div>

<script src="<c:url value="/js/user.js" />"></script>