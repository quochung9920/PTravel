function addComment(tourId, endpoint){
    console.info(document.getElementById("ratingTotal").innerHTML);
    fetch(endpoint, {
        method:"post",
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "tourId": tourId,
            "ratingTotal": document.getElementById("ratingTotal").innerHTML
        }),
        headers: {
            "Content-Type": "application/json"
        }
    
    }).then(function (res){
        console.info(res);
        return res.json();
    }).then(function (data){
        console.info(data);
        let area = document.getElementById("commentArea");
        msg = `
        <div id="${data.id}" class="border rounded-3 px-3 py-2 mb-2 bg-white">
            <div class="row mb-2">
                <div class="col-md-2">
                    <img src="${data.avatarUser}" class="img-fluid rounded-circle" alt="Ảnh đại diện">
                </div>
                <div class="col-md-6 align-self-center">
                    <div class="h5">Nguyễn Quốc Hưng</div>
                    <div>
                        <i>${moment(data.createdDate).fromNow()}</i>
                    </div>
                </div>
                <div class="col-md-4 align-self-center">
                    <div>
                        <span>`;
                        for(let j = 0; j < data.rating; j++){
                            msg += `<i class="fa-solid fa-star text-warning"></i>`;
                        }
                        for(let j = 0; j < 5 - data.rating; j++){
                            msg += `<i class="fa-solid fa-star"></i>`;
                        }
                        msg +=`
                        </span>
                    </div>
                </div>
            </div>
            <div class="mb-2">
                <p>${data.content}</p>
            </div>
            <div>
                <span class="text-success h6">Thích</span>
                &#8194;
                <span class="text-success h6">Trả lời</span>
            </div>
        </div>`;
        area.innerHTML = msg + area.innerHTML;
    });
}

function loadComments(endpoint){
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        let d = document.getElementById("commentArea");
        let msg = "";
        // Chỗ này có lỗi 400 do user chưa có avatar
        
        for (let i = 0; i < data.length; i++){
            
            msg += `<div id="${data[i].id}" class="border rounded-3 px-3 py-2 mb-2 bg-white">
                <div  class="row mb-2">
                    <div class="col-md-2">
                        <img src="${data[i].avatarUser}" class="img-fluid rounded-circle" alt="Ảnh đại diện">
                    </div>
                    <div class="col-md-6 align-self-center">
                        <div class="h5">Nguyễn Quốc Hưng</div>
                        <div>
                            <i>${moment(data[i].createdDate).fromNow()}</i>
                        </div>
                    </div>
                    <div class="col-md-4 align-self-center">
                        <div>
                            <span>`;
            for(let j = 0; j < data[i].rating; j++){
                msg += `<i class="fa-solid fa-star text-warning"></i>`;
            }
            for(let j = 0; j < 5 - data[i].rating; j++){
                msg += `<i class="fa-solid fa-star"></i>`;
            }
            msg +=`
                            </span>
                        </div>
                    </div>
                </div>
                <div class="mb-2">
                    <p>${data[i].content}</p>
                </div>
                <div>
                    <span class="text-success h6">Thích</span>
                    &#8194;
                    <span class="text-success h6">Trả lời</span>
                </div>
            </div>`;
        }
        d.innerHTML = msg;
    });

}
