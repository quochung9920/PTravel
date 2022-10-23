<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<div class="container">
  <table class="table table-bordered table-hover">
    <h2 class="text-success">
      Các tour đang chờ xác nhận
      <c:if test="${orderTourByUserWaiting.size() == 0}">
        <span class="text-danger">(Không có tour nào đang chờ xác nhận)</span>
      </c:if>
    </h2>
    <c:if test="${orderTourByUserWaiting.size() != 0}">
      <thead class="bg-dark text-white">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Tên tour</th>
          <th scope="col">Người lớn</th>
          <th scope="col">Trẻ em</th>
          <th scope="col">Tổng</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach
          items="${orderTourByUserWaiting}"
          var="orderTourByUserWaiting"
        >
          <tr>
            <th scope="row">${orderTourByUserWaiting.id}</th>
            <td>${orderTourByUserWaiting.tourId.tourName}</td>
            <td>${orderTourByUserWaiting.numberAdult}</td>
            <td>${orderTourByUserWaiting.numberChildren}</td>
            <td id="totalPriceWaiting-${orderTourByUserWaiting.id}"></td>
            <script>
              $("#totalPriceWaiting-${orderTourByUserWaiting.id}").text(formatNumber(${orderTourByUserWaiting.totalPrice}, ',', '.') + " VNĐ");
            </script>
          </tr>
        </c:forEach>
      </tbody>
    </c:if>
  </table>

  <table class="table table-bordered table-hover">
    <h2 class="text-success">
      Các tour đang đặt
      <c:if test="${orderTourByUserActive.size() == 0}">
        <span class="text-danger">(Không có tour nào đang đặt)</span>
      </c:if>
    </h2>
    <c:if test="${orderTourByUserActive.size() != 0}">
      <thead class="bg-dark text-white">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Tên tour</th>
          <th scope="col">Người lớn</th>
          <th scope="col">Trẻ em</th>
          <th scope="col">Tổng</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${orderTourByUserActive}" var="orderTourByUserActive">
          <tr>
            <th scope="row">${orderTourByUserActive.id}</th>
            <td>${orderTourByUserActive.tourId.tourName}</td>
            <td>${orderTourByUserActive.numberAdult}</td>
            <td>${orderTourByUserActive.numberChildren}</td>
            <td id="totalPriceActive-${orderTourByUserActive.id}"></td>
            <script>
              $("#totalPriceActive-${orderTourByUserActive.id}").text(formatNumber(${orderTourByUserActive.totalPrice}, ',', '.') + " VNĐ");
            </script>
          </tr>
        </c:forEach>
      </tbody>
    </c:if>
  </table>
</div>

