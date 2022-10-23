<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">
                QUẢN LÝ ĐẶT TOUR
                <c:if test="${orderTourManager.size() == 0}">
                    <span class="text-danger">(Không có tour nào)</span>
                </c:if>
            </h1>
        </div>        
        <table class="table table-bordered table-hover">
            <c:if test="${orderTourManager.size() != 0}">
                <thead class="bg-dark text-white">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tên tour</th>
                        <th scope="col">Ngày khởi hành</th>
                        <th scope="col">Người lớn</th>
                        <th scope="col">Trẻ em</th>
                        <th scope="col">Tổng</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col">Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orderTourManager}" var="orderTourManager">
                        <tr>
                            <th scope="row">${orderTourManager.id}</th>
                            <td>${orderTourManager.tourId.tourName}</td>
                            <td><input type="date" value="${orderTourManager.departureDay.toString().split(" ")[0]}"></td>
                            <td>${orderTourManager.numberAdult}</td>
                            <td>${orderTourManager.numberChildren}</td>
                            <td id="totalPriceOrderTour-${orderTourManager.id}"></td>
                            <td>
                                <c:if test="${orderTourManager.active == false}">
                                    <span class="text-danger">Chưa kích hoạt</span>
                                </c:if>
                                <c:if test="${orderTourManager.active == true}">
                                    <span class="text-success">Đã kích hoạt</span>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${orderTourManager.active == false}">
                                    <c:url var="urlUpdateOrder" value="/admin/update-order/${orderTourManager.id}"/>
                                    <form:form method="POST" action="${urlUpdateOrder}" modelAttribute="activeOrderTour">
                                        <input type="hidden" name="active" value="${orderTourManager.active}">
                                        <input type="submit" class="btn btn-primary" value="Kích hoạt" />
                                    </form:form>
                                </c:if>            
                            </td>
                            <script>
                                $("#totalPriceOrderTour-${orderTourManager.id}").text(formatNumber(${orderTourManager.totalPrice}, ',', '.') + " VNĐ");    
                            </script>
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </c:if>
        </table>
    </main>

    <footer class="py-4 bg-light mt-auto">
        <div class="container-fluid px-4">
            <div class="d-flex align-items-center justify-content-between small">
                <div class="text-muted">Copyright &copy; Your Website 2022</div>
                <div>
                    <a href="#">Privacy Policy</a>
                    &middot;
                    <a href="#">Terms &amp; Conditions</a>
                </div>
            </div>
        </div>
    </footer>