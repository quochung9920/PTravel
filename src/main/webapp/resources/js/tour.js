function getRegion(){
    console.info(document.getElementById('region').options[document.getElementById('region').selectedIndex].value);
}


function loadTours(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        let d = document.getElementById("myTours");
        let msg = "";
        for (let i = 0; i < data.length; i++)
            msg += `<tr id="${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].tourName}</td>
                    <td>
                        <button class="btn btn-danger">
                            <a href="http://localhost:8080/ptravel-1.0-SNAPSHOT/admin/update-tour/${data[i].id}">Sửa</a>
                        </button>
                        <button class="btn btn-danger" onclick="deleteTour('${endpoint+'/'+data[i].id}', ${data[i].id})">Huỷ</button>
                    </td>
                </tr>`
        
        d.innerHTML = msg;
    });
}

function deleteTour(endpoint, id){
    fetch(endpoint, {
        method: "delete"
    }).then(function (res){
        if(res.status == 204)
            location.reload();
    }).catch(function (err){
        console.error(err);
    });
}


function addTour(endpoint){
    fetch(endpoint, {
        method:"post",
        body: JSON.stringify({
            "tourName": document.getElementById('tourName').value,
            "header": CKEDITOR.instances['header'].getData(),
            "intro": CKEDITOR.instances['intro'].getData(),
            "schedule": CKEDITOR.instances['schedule'].getData(),
            "priceAdult": document.getElementById('priceAdult').value,
            "priceChild": document.getElementById('priceChild').value,
            "region" : document.getElementById('region').value,
            "season" : document.getElementById('season').value
            // "image1" : document.getElementById('image1').value,
            // "image2" : document.getElementById('image2').value,
            // "image3" : document.getElementById('image3').value,
            // "image4" : document.getElementById('image4').value,
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

function updateTour(endpoint){
    fetch(endpoint, {
        method:"put",
        body: JSON.stringify({
            "tourName": document.getElementById('tourName').value,
            "header": CKEDITOR.instances['header'].getData(),
            "intro": CKEDITOR.instances['intro'].getData(),
            "schedule": CKEDITOR.instances['schedule'].getData(),
            "priceAdult": document.getElementById('priceAdult').value,
            "priceChild": document.getElementById('priceChild').value,
            "region" : document.getElementById('region').value,
            "season" : document.getElementById('season').value,
            "image1" : document.getElementById('image1').value,
            "image2" : document.getElementById('image2').value,
            "image3" : document.getElementById('image3').value,
            "image4" : document.getElementById('image4').value,
            // "image5" : document.getElementById('image5').value,
            // "image6" : document.getElementById('image6').value,
            // "image7" : document.getElementById('image7').value,
            // "image8" : document.getElementById('image8').value,
            // "image9" : document.getElementById('image9').value,
            // "image10" : document.getElementById('image10').value

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
