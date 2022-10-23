<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">QUẢN LÝ TOUR DU LỊCH</h1>
            <a href="<c:url value="/admin/tour-manager/add-tour" />" class="btn btn-outline-primary">Thêm Tour</a>
        </div>        
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên Tour</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="myTours">
                
                </tbody>
                
            </table>
            <script src="<c:url value="/js/tour.js" />"></script>
            <script>
                <c:url value="/api/tours" var="endpoint" />
                window.onload = function() {
                    loadTours('${endpoint}');
                }
            </script>
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