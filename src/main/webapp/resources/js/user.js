function loadUsers(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        let d = document.getElementById("myUser");
        let msg = "";
        for (let i = 0; i < data.length; i++)
            msg += `<tr id="${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].email}</td>
                    <td>${data[i].password}</td>
                    <td>${data[i].userRole}</td>
                    <td><button class="btn btn-danger" onclick=""><a href="http://localhost:8080/ptravel-1.0-SNAPSHOT/admin/update-user/${data[i].id}">Thông tin chi tiết</a></button></td>
                </tr>`
        
        d.innerHTML = msg;
    });
}

function updateUser(endpoint){
    fetch(endpoint, {
        method:"put",
        body: JSON.stringify({
            "lastName" : document.getElementById('lastName').value,
            "firstName" : document.getElementById('firstName').value,
            "email" : document.getElementById('email').value,
            "phone" : document.getElementById('phone').value,
            "username" : document.getElementById('username').value,
            "password" : document.getElementById('password').value

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
