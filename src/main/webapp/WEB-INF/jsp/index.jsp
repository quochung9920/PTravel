<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container-fluid p-0">
    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="https://cdn2.ivivu.com/2019/09/13/15/ivivu-invalides6.jpg" class="d-block w-100" style="height: 700px;" alt="Ảnh 1">
            <div class="carousel-caption d-none d-md-block">
              <!-- <h5>First slide label</h5>
              <p>Some representative placeholder content for the first slide.</p> -->
            </div>
          </div>
          <div class="carousel-item">
            <img src="https://cdn2.ivivu.com/2022/03/15/14/ivivu-khai-hoan-mon.gif" class="d-block w-100" style="height: 700px;" alt="Ảnh 2">
            <div class="carousel-caption d-none d-md-block">
              <!-- <h5>Second slide label</h5>
              <p>Some representative placeholder content for the second slide.</p> -->
            </div>
          </div>
          <div class="carousel-item">
            <img src="https://cdn2.ivivu.com/2022/03/15/09/ivivu-thanh-duong-sacre-c-ur.gif" class="d-block w-100" style="height: 700px;" alt="Ảnh 3">
            <div class="carousel-caption d-none d-md-block">
              <!-- <h5>Third slide label</h5>
              <p>Some representative placeholder content for the third slide.</p> -->
            </div>
          </div>
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
<div class="container-fluid p-0 py-4 bg-secondary bg-opacity-10">
    <div class="container">
        <div class="h4">TOUR ĐƯỢC YÊU THÍCH NHẤT</div>
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="https://cdn2.ivivu.com/2019/09/13/15/ivivu-invalides6.jpg" alt="Card image">
                    <div class="card-body">
                      <h4 class="card-title">John Doe</h4>
                      <p class="card-text">Some example text.</p>
                      <a href="#" class="btn btn-primary">See Profile</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="https://cdn2.ivivu.com/2022/03/15/14/ivivu-khai-hoan-mon.gif" alt="Card image">
                    <div class="card-body">
                      <h4 class="card-title">John Doe</h4>
                      <p class="card-text">Some example text.</p>
                      <a href="#" class="btn btn-primary">See Profile</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="https://cdn2.ivivu.com/2022/03/15/09/ivivu-thanh-duong-sacre-c-ur.gif" alt="Card image">
                    <div class="card-body">
                      <h4 class="card-title">John Doe</h4>
                      <p class="card-text">Some example text.</p>
                      <a href="#" class="btn btn-primary">See Profile</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
  
</div>

<div class="container py-4">
    <div class="h4">DU LỊCH TRONG NƯỚC</div>
    <div class="row">
      <c:forEach items="${tour}" var="t">
        <div class="col-md-4 pt-3">
          <div class="card">
              <c:if test="${t.image == null}">
                <img class="card-img-top" style="height: 260px;" src="https://cdn2.ivivu.com/2019/09/13/15/ivivu-invalides6.jpg" alt="Card image">
              </c:if>
              <c:if test="${t.image != null}">
                <img class="card-img-top" style="height: 260px;" src="<c:url value="/images/image-tour/${t.image}" />" alt="Card image">
              </c:if>
              <div class="card-body">
                <h4 class="card-title">${t.tourName}</h4>
                <div class="row bg-secondary bg-opacity-25 align-self-center p-2">
                  <div class="col-md-8 align-self-center">
                    
                    <div class="card-text h5 mb-0" id="${t.id}"></div>
                    <script>
                       function formatNumber(nStr, decSeperate, groupSeperate) {
                            nStr += '';
                            x = nStr.split(decSeperate);
                            x1 = x[0];
                            x2 = x.length > 1 ? '.' + x[1] : '';
                            var rgx = /(\d+)(\d{3})/;
                            while (rgx.test(x1)) {
                                x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
                            }
                            return x1 + x2;
                        }
                      $( document ).ready(function() {
                        $('#${t.id}').text("Giá từ: " + formatNumber(${t.priceAdult}, '.', ',') + " VNĐ");
                      });
                      
                    </script>

                  </div>
                  <div class="col-md-4">
                    <a href="<c:url value="/${t.id}" />" class="btn btn-primary">Chi tiết</a>
                  </div>
                </div>
              </div>
          </div>
        </div> 
      </c:forEach>
        

    </div>
</div>

<div class="container-fluid p-0">
    <div class="container-fluid px-5 py-4 bg-success bg-opacity-50">
        <div class="h4">MÙA XUÂN</div>
        <div class="row">
          <c:forEach items="${tourSpring}" var="tourSpring">
            <div class="col-md-3 pt-2">
              <div class="card">
                  <c:if test="${tourSpring.image == null}">
                    <img class="card-img-top" style="height: 260px;" src="https://cdn2.ivivu.com/2019/09/13/15/ivivu-invalides6.jpg" alt="Card image">
                  </c:if>
                  <c:if test="${tourSpring.image != null}">
                    <img class="card-img-top" style="height: 260px;" src="<c:url value="/images/image-tour/${tourSpring.image}" />" alt="Card image">
                  </c:if>
                  <div class="card-body">
                    <h4 class="card-title">${tourSpring.tourName}</h4>
                    <div class="row bg-secondary bg-opacity-25 align-self-center p-2">
                      <div class="col-md-8 align-self-center">
                        
                        <div class="card-text h5 mb-0" id="${tourSpring.id}"></div>
                        <script>
                           function formatNumber(nStr, decSeperate, groupSeperate) {
                                nStr += '';
                                x = nStr.split(decSeperate);
                                x1 = x[0];
                                x2 = x.length > 1 ? '.' + x[1] : '';
                                var rgx = /(\d+)(\d{3})/;
                                while (rgx.test(x1)) {
                                    x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
                                }
                                return x1 + x2;
                            }
                          $( document ).ready(function() {
                            $('#${t.id}').text("Giá từ: " + formatNumber(${tourSpring.priceAdult}, '.', ',') + " VNĐ");
                          });
                          
                        </script>
    
                      </div>
                      <div class="col-md-4">
                        <a href="<c:url value="/${tourSpring.id}" />" class="btn btn-primary">Chi tiết</a>
                      </div>
                    </div>
                  </div>
              </div>
            </div> 
          </c:forEach>
        </div>
    </div>
    <div class="container-fluid px-5 py-4 bg-danger bg-opacity-50">
      <div class="h4">MÙA HẠ</div>
      <div class="row">
        <c:forEach items="${tourSummer}" var="tourSummer">
          <div class="col-md-3 pt-2">
            <div class="card">
                <c:if test="${tourSummer.image == null}">
                  <img class="card-img-top" style="height: 260px;" src="https://cdn2.ivivu.com/2019/09/13/15/ivivu-invalides6.jpg" alt="Card image">
                </c:if>
                <c:if test="${tourSummer.image != null}">
                  <img class="card-img-top" style="height: 260px;" src="<c:url value="/images/image-tour/${tourSummer.image}" />" alt="Card image">
                </c:if>
                <div class="card-body">
                  <h4 class="card-title">${tourSummer.tourName}</h4>
                  <div class="row bg-secondary bg-opacity-25 align-self-center p-2">
                    <div class="col-md-8 align-self-center">
                      
                      <div class="card-text h5 mb-0" id="${tourSummer.id}"></div>
                      <script>
                         function formatNumber(nStr, decSeperate, groupSeperate) {
                              nStr += '';
                              x = nStr.split(decSeperate);
                              x1 = x[0];
                              x2 = x.length > 1 ? '.' + x[1] : '';
                              var rgx = /(\d+)(\d{3})/;
                              while (rgx.test(x1)) {
                                  x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
                              }
                              return x1 + x2;
                          }
                        $( document ).ready(function() {
                          $('#${t.id}').text("Giá từ: " + formatNumber(${tourSummer.priceAdult}, '.', ',') + " VNĐ");
                        });
                        
                      </script>
  
                    </div>
                    <div class="col-md-4">
                      <a href="<c:url value="/${tourSummer.id}" />" class="btn btn-primary">Chi tiết</a>
                    </div>
                  </div>
                </div>
            </div>
          </div> 
        </c:forEach>
      </div>
    </div>
    <div class="container-fluid px-5 py-4 bg-warning bg-opacity-50">
      <div class="h4">MÙA THU</div>
      <div class="row">
        <c:forEach items="${tourAutumn}" var="tourAutumn">
          <div class="col-md-3 pt-2">
            <div class="card">
                <c:if test="${tourAutumn.image == null}">
                  <img class="card-img-top" style="height: 260px;" src="https://cdn2.ivivu.com/2019/09/13/15/ivivu-invalides6.jpg" alt="Card image">
                </c:if>
                <c:if test="${tourAutumn.image != null}">
                  <img class="card-img-top" style="height: 260px;" src="<c:url value="/images/image-tour/${tourAutumn.image}" />" alt="Card image">
                </c:if>
                <div class="card-body">
                  <h4 class="card-title">${tourAutumn.tourName}</h4>
                  <div class="row bg-secondary bg-opacity-25 align-self-center p-2">
                    <div class="col-md-8 align-self-center">
                      
                      <div class="card-text h5 mb-0" id="${tourAutumn.id}"></div>
                      <script>
                         function formatNumber(nStr, decSeperate, groupSeperate) {
                              nStr += '';
                              x = nStr.split(decSeperate);
                              x1 = x[0];
                              x2 = x.length > 1 ? '.' + x[1] : '';
                              var rgx = /(\d+)(\d{3})/;
                              while (rgx.test(x1)) {
                                  x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
                              }
                              return x1 + x2;
                          }
                        $( document ).ready(function() {
                          $('#${t.id}').text("Giá từ: " + formatNumber(${tourAutumn.priceAdult}, '.', ',') + " VNĐ");
                        });
                        
                      </script>
  
                    </div>
                    <div class="col-md-4">
                      <a href="<c:url value="/${tourAutumn.id}" />" class="btn btn-primary">Chi tiết</a>
                    </div>
                  </div>
                </div>
            </div>
          </div> 
        </c:forEach>
      </div>
    </div>
    <div class="container-fluid px-5 py-4 bg-secondary bg-opacity-50">
      <div class="h4">MÙA ĐÔNG</div>
      <div class="row">
        <c:forEach items="${tourWinter}" var="tourWinter">
          <div class="col-md-3 pt-2">
            <div class="card">
                <c:if test="${tourWinter.image == null}">
                  <img class="card-img-top" style="height: 260px;" src="https://cdn2.ivivu.com/2019/09/13/15/ivivu-invalides6.jpg" alt="Card image">
                </c:if>
                <c:if test="${tourWinter.image != null}">
                  <img class="card-img-top" style="height: 260px;" src="<c:url value="/images/image-tour/${tourWinter.image}" />" alt="Card image">
                </c:if>
                <div class="card-body">
                  <h4 class="card-title">${tourWinter.tourName}</h4>
                  <div class="row bg-secondary bg-opacity-25 align-self-center p-2">
                    <div class="col-md-8 align-self-center">
                      
                      <div class="card-text h5 mb-0" id="${tourWinter.id}"></div>
                      <script>
                         function formatNumber(nStr, decSeperate, groupSeperate) {
                              nStr += '';
                              x = nStr.split(decSeperate);
                              x1 = x[0];
                              x2 = x.length > 1 ? '.' + x[1] : '';
                              var rgx = /(\d+)(\d{3})/;
                              while (rgx.test(x1)) {
                                  x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
                              }
                              return x1 + x2;
                          }
                        $( document ).ready(function() {
                          $('#${t.id}').text("Giá từ: " + formatNumber(${tourWinter.priceAdult}, '.', ',') + " VNĐ");
                        });
                        
                      </script>
  
                    </div>
                    <div class="col-md-4">
                      <a href="<c:url value="/${tourWinter.id}" />" class="btn btn-primary">Chi tiết</a>
                    </div>
                  </div>
                </div>
            </div>
          </div> 
        </c:forEach>
      </div>
    </div>
</div>