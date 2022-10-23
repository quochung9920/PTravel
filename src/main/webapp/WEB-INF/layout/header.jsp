<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar navbar-expand-sm bg-light     navbar-light">
    <div class="row container-fluid">
        <div class="col-md-4 d-flex justify-content-center">
            <div>
                <svg width="141" height="44" viewBox="0 0 141 44" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M3.83183 8.15215C1.65245 7.45185 0.930427 3.01218 0.841835 0.879883C11.7165 0.879883 34.3032 0.920284 37.6519 1.08189C41.0007 1.2435 44.4071 3.30397 45.6917 4.31401C46.2897 4.83025 47.9242 6.58996 49.6784 9.49886C51.871 13.135 51.0072 19.3972 50.2763 22.0907C49.5455 24.7841 46.7548 27.6122 44.4957 29.4976C42.6884 31.0059 38.8258 31.9666 37.1204 32.2584H25.1604V24.5821H35.4593C37.1204 24.5821 38.3164 24.1107 40.2433 22.966C42.1702 21.8213 43.6319 18.1178 42.5024 13.8084C41.5987 10.3608 37.962 9.04996 36.2566 8.8255C26.3564 8.89284 6.0112 8.85244 3.83183 8.15215ZM14.6622 42.9647C14.6091 42.9647 14.6401 21.7764 14.6622 11.1823H20.5093C22.4229 11.1823 22.8127 12.7085 22.7684 13.4717V42.9647H14.6622ZM97.7634 42.9649H101.075V28.5219H97.7634V42.9649ZM64.6472 43.1211C62.0133 43.1211 59.9022 40.9351 59.9022 37.5C59.9022 34.0649 62.0133 31.918 64.6666 31.918C66.2741 31.918 67.4167 32.6596 67.9978 33.616V32.0741H71.3096V42.9649H67.9978V41.423C67.3974 42.3794 66.2547 43.1211 64.6472 43.1211ZM65.6349 40.2129C66.8938 40.2129 67.9978 39.2566 67.9978 37.5195C67.9978 35.7824 66.8938 34.8261 65.6349 34.8261C64.3954 34.8261 63.2721 35.7629 63.2721 37.5C63.2721 39.2371 64.3954 40.2129 65.6349 40.2129ZM58.0675 35.4897C56.4987 35.4897 55.5884 36.0362 55.5884 37.9099V42.9649H52.2766V32.0741H55.5884V33.8892C56.3438 32.7377 57.5252 31.957 58.9777 31.957V35.4897H58.0675ZM76.5138 42.9649H80.6003L84.435 32.0741H80.9102L78.5667 39.8421L76.2233 32.0741H72.6791L76.5138 42.9649ZM92.627 36.4656C92.627 35.275 91.6973 34.5919 90.5934 34.5919C89.5088 34.5919 88.676 35.2555 88.4824 36.4656H92.627ZM92.2396 39.3542H95.7645C95.2416 41.4816 93.3242 43.1211 90.6321 43.1211C87.4559 43.1211 85.1706 40.9741 85.1706 37.5195C85.1706 34.0649 87.4172 31.918 90.6321 31.918C93.789 31.918 96.0163 34.0259 96.0163 37.3439C96.0163 37.6561 95.9969 37.9879 95.9582 38.3197H88.463C88.5792 39.7445 89.4507 40.4081 90.5159 40.4081C91.4456 40.4081 91.9685 39.9397 92.2396 39.3542ZM124.838 15.8231H135.052C137.877 15.8231 140.158 18.1217 140.158 20.9693V32.9772C140.158 35.8248 137.877 38.1235 135.052 38.1235L136.754 39.8389V41.5543H135.052L131.647 38.072H128.243L124.838 41.5543H123.136V39.8389L124.838 38.1235C122.013 38.1235 119.732 35.8248 119.732 32.9772V20.9693C119.732 18.1217 122.013 15.8231 124.838 15.8231ZM123.136 32.9772C123.136 33.9207 123.902 34.6926 124.838 34.6926C125.775 34.6926 126.54 33.9207 126.54 32.9772C126.54 32.0337 125.775 31.2618 124.838 31.2618C123.902 31.2618 123.136 32.0337 123.136 32.9772ZM133.349 32.9772C133.349 33.9207 134.115 34.6926 135.052 34.6926C135.988 34.6926 136.754 33.9207 136.754 32.9772C136.754 32.0337 135.988 31.2618 135.052 31.2618C134.115 31.2618 133.349 32.0337 133.349 32.9772ZM123.136 29.5464H136.754V19.2539H123.136V29.5464ZM112.923 31.2618L112.344 27.0247L118.029 21.2952V20.9693C118.029 17.1782 121.076 14.1076 124.838 14.1076H125.145L131 8.20661C132.005 7.24598 132.005 5.58203 131 4.56993C130.047 3.56641 128.345 3.56641 127.392 4.56993L120.77 11.2429L105.127 7.60622L102.71 10.025L115.357 16.7322L108.769 23.3709L104.514 22.7362L102.71 24.5888L108.14 27.6251L111.136 33.0801L112.923 31.2618Z" fill="#3366FF"/>
                </svg>
            </div>
        </div>
        <div class="col-md-4">
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <a class="nav-link h5 mb-0" href="<c:url value="/" />">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link h5 mb-0" href="<c:url value="/tour-list" />">Tour</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link h5 mb-0" href="#">Tin tức</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link h5 mb-0" href="#">Liên hệ</a>
                </li>
            </ul>
        </div>
        <div class="col-md-4">
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <!-- <a class="nav-link" href="#"><i class="fa-light fa-magnifying-glass h5 mb-0"></i></a> -->
                    <form class="d-flex">
                        <input class="form-control me-2" type="text" name="kw" placeholder="Tìm kiếm">
                        <input type="submit" value="Tìm kiếm" class="btn btn-primary">
                    </form>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fa-light fa-heart h5 mb-0"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/cart" />?user=${userId}"><i class="fa-light fa-cart-shopping h5 mb-0"></i></a>
                </li>
                <li class="nav-item dropdown-toggle">
                    <a class="nav-link" href="#"><i class="fa-light fa-user h5 mb-0"></i></a>
                </li>
                <ul class="dropdown-menu dropdown-menu-dark mt-5">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li>
                            <a class="nav-link text-danger" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="<c:url value="/info-user/${userId}" />">Thông tin tài khoản</a>
                        </li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li><a class="dropdown-item" href="<c:url value="/login" />">Đăng nhập</a></li>
                    </c:if>
                    
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="<c:url value="/logout" />">Đăng xuất</a></li>
                    </c:if>
                    
                </ul>
                
            </ul>
        </div>
    </div>
</nav>
<style>
    .dropdown-toggle::after{
        content: none !important;
    }
</style>
<script>
    $(".dropdown-toggle" ).click(function() {
        if(!$(".dropdown-menu").hasClass("show")){
            $(".dropdown-menu").addClass("show");
            $(".dropdown-menu" ).mouseenter(function() {
                $(".dropdown-menu" ).mouseleave(function() {
                    $(".dropdown-menu").removeClass("show");
                });
            });

        } else {
            $(".dropdown-menu").removeClass("show");
        }
        
    });
</script>
