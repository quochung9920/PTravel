<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="container-fluid">
    <div class="container">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="#C1">
                    <div class="text-success h4">Tổng quan</div>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#C2">
                    <div class="text-success h4">Chương trình tour</div>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#C3">
                    <div class="text-success h4">Đánh giá của khách hàng</div>
                </a>
            </li>
        </ul>
    </div>
</div>
<div class="container">

    <div class="py-3">
        Trang chủ  Đà Nẵng  Tour Đà Nẵng 4N3Đ: HCM - Đà Nẵng - Bà Nà - Hội An - Huế - Quảng Bình Bay VJ
    </div>
    <div class="text-success">
        ${tour.header}
    </div>
    <div class="py-3">
        Tuyệt vời | 3 đánh giá
    </div>
    <div class="row">
        <div class="col-md-8">
            <div>
                <div class="container p-0 mb-4 bg-white">

                    <div id="carouselExampleCaptions" style="height: 500px;" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="<c:url value="/images/image-tour/${imageTop}" />" class="w-100 img-thumbnail" alt="Tour Image">
                                <div class="carousel-caption d-none d-md-block">
                                  <!-- <h5>First slide label</h5>
                                  <p>Some representative placeholder content for the first slide.</p> -->
                                </div>
                            </div>
                            <c:forEach items="${imagesTour}" var="imagesTour">
                                <div class="carousel-item">
                                    <img src="<c:url value="/images/image-tour/${imagesTour}" />" class="w-100 img-thumbnail" alt="Tour Image">
                                    <div class="carousel-caption d-none d-md-block">
                                      <!-- <h5>First slide label</h5>
                                      <p>Some representative placeholder content for the first slide.</p> -->
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                          <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                          <span class="carousel-control-next-icon" aria-hidden="true"></span>
                          <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>

                <div class="container p-4 mb-4 border rounded bg-white" id="C1">${tour.intro}</div>
                <div class="container p-4 border rounded bg-white" id="C2">${tour.schedule}</div>
            </div>
        </div>
        <div class="col-md-4 ">
            <form class="bg-white p-3 rounded">
                <div class="h4 text-success py-2">Lịch khởi hành & giá</div>
                <div class="form-group border rounded py-2 mb-2">
                    <div class="row p-2 m-0">
                        <div class="col-md-7 p-0">
                            <label for="departureDay">Chọn ngày khởi hành</label>
                        </div>
                        <div class="col-md-5 p-0">
                            <input type="date" class="form-control border-0 p-0" id="departureDay"/>
                        </div>
                    </div>
                </div>
                <div class="form-group border rounded py-2 mb-2">
                    <div class="row p-2 m-0">
                        <div class="col-md-7 p-0 d-flex justify-content-between">
                            <label for="numberAdult">Người lớn</label>
                            <span class="text-warning px-2" id="priceAdult">x </span>
                            <script>
                                $("#priceAdult").append(formatNumber(${tour.priceAdult}, ',', '.'));
                            </script>
                        </div>
                        <div class="col-md-5 p-0">
                            <input type="number" min="1" value="2" class="form-control border-0 p-0" id="numberAdult"/> 
                        </div>
                    </div>
                </div>
                <div class="form-group border rounded py-2 mb-2">
                    <div class="row p-2 m-0">
                        <div class="col-md-7 p-0 d-flex justify-content-between" id="labelChild">
                            <label for="numberChild">Trẻ em</label>
                            <span class="text-warning px-2 d-none" id="labelPriceChild">x </span>
                            <script>
                                $("#labelPriceChild").append(formatNumber(${tour.priceChild}, ',', '.'));
                            </script>

                        </div>
                        <div class="col-md-5 p-0">
                            <input type="number" min="0" value="0" class="form-control border-0 p-0" id="numberChild"/>
                        </div>
                    </div>
                </div>
                <div class="form-group py-2">
                    <div class="row py-2 m-0">
                        <div class="col-md-5 p-0 pt-2">
                            <label for="totalPrice" class="h5" >Tổng cộng</label>
                        </div>
                        <div class="col-md-7 p-0">
                            <div class="text-end h3 text-warning">
                                <span id="totalPrice"></span><span class="h5"> VND</span>
                                <span class="d-none" id="totalPrice2"></span> 
                            </div>
                            <script>
                                var totalPrice = (${tour.priceChild}*$("#numberChild").val())+(${tour.priceAdult}*$("#numberAdult").val());
                                $("#totalPrice2").text(totalPrice);
                                $("#totalPrice").text(formatNumber( totalPrice, ',', '.'));
                                $(':input[type="number"]').click(function () { 
                                    var totalPrice = (${tour.priceChild}*$("#numberChild").val())+(${tour.priceAdult}*$("#numberAdult").val());
                                    $("#totalPrice2").text(totalPrice);
                                    $("#totalPrice").text(formatNumber( totalPrice, ',', '.'));
                                    if($("#numberChild").val()==0){
                                        $("#labelPriceChild").addClass("d-none");
                                    } else {
                                        $("#labelPriceChild").removeClass("d-none");
                                    }
                                    
                                    $(':input[type="number"]').mouseleave(function () { 
                                        var totalPrice = (${tour.priceChild}*$("#numberChild").val())+(${tour.priceAdult}*$("#numberAdult").val());
                                        $("#totalPrice").text(formatNumber( totalPrice, ',', '.'));
                                        $("#totalPrice2").text(totalPrice);
                                    });
                                    $(':input[type="number"]').keypress(function(event){
                                        var keycode = (event.keyCode ? event.keyCode : event.which);
                                        if (keycode == '13') {
                                            var totalPrice = (${tour.priceChild}*$("#numberChild").val())+(${tour.priceAdult}*$("#numberAdult").val());
                                            $("#totalPrice").text(formatNumber( totalPrice, ',', '.'));
                                            $("#totalPrice2").text(totalPrice);
                                        }
                                    });
                                });
                                
                            </script>
                        </div>
                    </div>
                </div>
                <div class="form-group mb-2">
                    <div class="pt-2 m-0">
                        <label for="totalPrice" class="h5 mb-0" >Liên hệ để xác nhận chỗ</label>
                    </div>
                </div>
                <div class="form-group pb-2">
                    <div class="row">
                        <div class="col-md-6">
                            <c:url value="/api/tours/${tour.id}/order-tour" var="urlOrderTour" />
                            <button type="button" class="btn btn-outline-warning w-100 p-2" onclick=""><h5 class="m-0">Liên hệ tư vấn</h5></button>
                        </div>
                        <div class="col-md-6">
                            <c:url value="/api/tours/${tour.id}/order-tour" var="urlOrderTour" />
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <button type="button" class="btn btn-warning text-white w-100 p-2" onclick="addOrderTour('${urlOrderTour}')"><h5 class="m-0">Yêu cầu đặt</h5></button>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                                <c:url value="/login" var="urlLogin" />
                                <button type="button" class="btn btn-warning text-white w-100 p-2" onclick="messageLogin('${urlLogin}')"><h5 class="m-0">Yêu cầu đặt</h5></button>
                            </c:if>
                        </div>
                    </div>
                </div>
        
            </form>
        </div>
        <div class="row my-3 py-2" id="C3">
            <div class="col-md-7">
                <div id="commentArea">
                </div>
                    
            </div>
            <div class="col-md-5">
                
                <form class="bg-white p-3 rounded">
                    <div class="h4 text-success py-2">Bình luận & Đánh giá</div>
                    <div class="form-group pb-2">
                        <label for="rateTour">Đánh giá:</label>
                        <span class="ratingTour">
                            <i class="fa-solid fa-star rating-1"></i>
                            <i class="fa-solid fa-star rating-2"></i>
                            <i class="fa-solid fa-star rating-3"></i>
                            <i class="fa-solid fa-star rating-4"></i>
                            <i class="fa-solid fa-star rating-5"></i>
                        </span>
                        <span id="ratingTotal" class="d-none"></span>
                        <script>
                            $( ".ratingTour > i" ).hover(
                            function() {
                                // $( this ).addClass( "text-warning" );
                                $( this ).prevAll().addClass( "text-warning" );
                                $( this ).addClass( "text-warning" );
                                $( this ).nextAll().removeClass( "text-warning" );
                                var rating = $( this ).prevAll().length + 1;
                                $("#ratingTotal").text(rating);

                            });
                        </script>
                    </div>
                    <div class="form-group pb-2">
                        <label for="commentTour">Bình luận:</label>
                        <textarea id="commentId" name="commentId" rows="4" style="width: 100%">
                        </textarea>
                    </div>
                    <div class="form-group pb-2 d-flex justify-content-end">
                        <c:url value="/api/add-comment" var="endpoint" />
                        <button type="button" onclick="addComment(${tour.id} ,'${endpoint}')"class="btn btn-danger">Gửi bình luận</button>
                    </div>
                </form>

                
            </div>
        </div>
    </div>
    

</div>



<script src="<c:url value="/js/comment.js" />"></script>
<script src="<c:url value="/js/order-tour.js" />"></script>
<script>
    <c:url value="/api/comments/${tour.id}" var="endpoint" />
                window.onload = function() {

                    loadComments('${endpoint}');

                    moment.lang("vi").format('llll');
                }
</script>