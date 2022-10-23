<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
    <div class="col-md-2">
    </div>
    <div class="col-md-8">
        <h1 class="text-info text-center">SỬA TOUR</h1>

        <!-- <c:url value="/admin/update-tour/${tour.id}" var="addTourImage" />
        <form:form method="post" action="${addTourImage}" modelAttribute="imageTour" enctype="multipart/form-data">
            <div class="form-group">
                <input type="file" id="file" name="image1" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <input type="file" id="file" name="image2" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <input type="file" id="file" name="image3" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <input type="file" id="file" name="image4" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <input type="submit" value="Thêm ảnh tour" class="btn btn-danger">
            </div>
        </form:form> -->
        <div id="addImageGroup">
            <c:url value="/admin/update-tour/${tour.id}" var="tourUpdateImage" />
            <form:form method="POST" action="${tourUpdateImage}" 
                modelAttribute="tourUpdateImage" enctype="multipart/form-data">
                <input type="file" id="imageTour" accept=".jpg, .png, .jpeg" name="imageTour" multiple="multiple" cssClass="form-control"/>
                <input type="submit" value="Thêm ảnh tour" />
            
            </form:form>
        </div>
        <form>
            <div class="mb-3 mt-3">
                <label for="tourName" class="form-label">Tên Tour:</label>
                <input type="text" name="tourName" value="${tour.tourName}" id="tourName">
            </div>
            
            <div class="mb-3 mt-3">
                <select class="form-select" id="region">
                    <c:forEach items="${region}" var="r">
                        <option value="${r.id}" <c:if test="${r.id == tour.regionId.id}">selected</c:if>>${r.regionName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3 mt-3" >
                <select class="form-select" id="season">
                    <c:forEach items="${season}" var="s">
                        <option value="${s.id}" <c:if test="${s.id == tour.seasonId.id}">selected</c:if>>${s.seasonName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3 mt-3">
                <label for="header" class="form-label">Tiêu đề:</label>
                <textarea id="header" name="header" class="form-control">${tour.header}</textarea>
            </div>
            <div class="mb-3">
                <label for="intro" class="form-label">Giới thiệu Tour:</label>
                <textarea id="intro" name="intro" class="form-control">${tour.intro}</textarea>
            </div>
            <div class="mb-3">
                <label for="schedule" class="form-label">Lịch trình Tour:</label>
                <textarea id="schedule" name="schedule" class="form-control">${tour.schedule}</textarea>
            </div>
            <div class="mb-3 mt-3">
                <label for="priceAdult" class="form-label">Giá người lớn:</label>
                <input type="number" name="priceAdult" value="${tour.priceAdult}" id="priceAdult">
            </div>
            <div class="mb-3 mt-3">
                <label for="priceChild" class="form-label">Giá trẻ em:</label>
                <input type="number" name="priceChild" value="${tour.priceChild}" id="priceChild">
            </div>
            <c:url var="url" value="/api/tours/${tour.id}" />
            <input type="button" onclick="updateTour('${url}')" class="btn btn-primary" value="Cập nhật">
        </form>
    </div>
    <div class="col-md-2">
    </div>
</div>
    
<script src="<c:url value="/js/tour.js" />"></script>
<script>

    var editor = CKEDITOR.replace('header');
    CKEDITOR.replace('intro');
    CKEDITOR.replace('schedule');

    var button = document.getElementById('addImage');

    button.addEventListener('click', function(){
        let d = document.getElementById("addImageGroup");
        let msg = "";
        
        msg += `<div class="form-group">
                    <input type="file" accept=".jpg, .png, .jpng" id="image10" name="image10" cssClass="form-control"/>
                </div>`
        
        d.innerHTML = msg;
    });
    
</script>