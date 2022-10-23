<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
    <div class="col-md-2">
    </div>
    <div class="col-md-8">
        <h1 class="text-info text-center">THÊM TOUR</h1>


    


        <form>
            <div class="mb-3 mt-3">
                <label for="tourName" class="form-label">Tên Tour:</label>
                <input type="text" name="tourName" id="tourName">
            </div>
            <div class="mb-3 mt-3">
                <select class="form-select" id="region">
                    <c:forEach items="${region}" var="r">
                        <option value="${r.id}">${r.regionName}</option>
                    </c:forEach>
                </select>
            </div>

            

            <div class="mb-3 mt-3" >
                <select class="form-select" id="season">
                    <c:forEach items="${season}" var="s">
                        <option value="${s.id}">${s.seasonName}</option>
                    </c:forEach>
                </select>
            </div>
            <!-- <div id="addImageGroup">
                <div class="form-group">
                    <input type="file" accept=".jpg, .png, .jpng" id="image1" name="image1" multiple cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <input type="file" accept=".jpg, .png, .jpng" id="image2" name="image2" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <input type="file" accept=".jpg, .png, .jpng" id="image3" name="image3" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <input type="file" accept=".jpg, .png, .jpng" id="image4" name="image4" cssClass="form-control"/>
                </div>
            </div> -->

            <div class="mb-3 mt-3">
                <label for="header" class="form-label">Tiêu đề:</label>
                <textarea id="header"  class="form-control"></textarea> 
            </div>

            <div class="mb-3">
                <label for="intro" class="form-label">Giới thiệu Tour:</label>
                <textarea id="intro" class="form-control"></textarea>
            </div>
            <div class="mb-3">
                <label for="schedule" class="form-label">Lịch trình Tour:</label>
                <textarea id="schedule" class="form-control"></textarea>
            </div>
            <div class="mb-3 mt-3">
                <label for="priceAdult" class="form-label">Giá người lớn:</label>
                <input type="number" name="priceAdult" id="priceAdult">
            </div>
            <div class="mb-3 mt-3">
                <label for="priceChild" class="form-label">Giá trẻ em:</label>
                <input type="number" name="priceChild" id="priceChild">
            </div>
            <c:url var="url" value="/api/tours/add-tour" />
            <input type="button" onclick="addTour('${url}')" class="btn btn-primary" value="Submit">
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


</script>




