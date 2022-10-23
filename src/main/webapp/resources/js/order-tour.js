function addOrderTour(endpoint){
    if(confirm("Bạn có chắc chắn muốn đặt tour") == true){
        fetch(endpoint, {
            
            method:"post",
            body: JSON.stringify({
                "departureDay" : document.getElementById("departureDay").value,
                "numberAdult" : document.getElementById("numberAdult").value,
                "numberChild" : document.getElementById("numberChild").value,
                "totalPrice" : document.getElementById("totalPrice2").innerText
            }),
            headers: {
                "Content-Type": "application/json"
            }
        
        }).then(function (res){
            console.info(res);
            alert("Đặt tour thành công");
            return res.json();
        }).then(function (data){
            console.info(data);
        });
    }
}

function updateOrderTour(endpoint){
        fetch(endpoint, {
            method:"put",
            body: JSON.stringify({
                "active" : true
            }),
            headers: {
                "Content-Type": "application/json"
            }
        
        }).then(function (res){
            console.info(res);
            return res.json();
        }).then(function (data){
            console.info(data);
        });
}


function messageLogin(url){
    if(confirm("Bạn chưa đăng nhập, vui lòng đăng nhập để đặt tour") == true){
        window.location.href = url;
    }
}
