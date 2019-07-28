window.addEventListener("load",function(){
    var section = this.document.querySelector("#main");
    var id = section.querySelector("input[name=username]");
    var pw = section.querySelector("input[name=password]");
    var loginBtn= section.querySelector(".login-button");   
    var formData = new FormData();
   

    loginBtn.onclick = function(){
        alert("로그인");
        var parameter = 'username'+id.value+'$password'+pw.value;
        alert(parameter);
        var request = new XMLHttpRequest();
        request.open("POST","/login",true);
        request.onreadystatechange = function(){
            if(request.readyState ==4 && request.status ==200){
                alert(request.responseText);
                alert("들어옴");
            }
        }
        request.send(parameter);
        alert("로그인1");
    };
});