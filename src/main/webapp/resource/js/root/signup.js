window.addEventListener("load",function(e){
    var section = document.querySelector("#body");
    var pw = section.querySelector("input[name=pw]");
    var pwCheck = section.querySelector("input[name=pw-check]");
    var loginBtn = section.querySelector("input[type=submit]");
    var same = section.querySelector("#same");
    
    pwCheck.oninput =function(e){
        if(pw.value != pwCheck.value)
            same.innerText="비밀번호가 일치하지 않습니다.";
        else
            same.innerText="일치합니다.";
   }
   loginBtn.onclick = function(){
       alert("gkdl");
   }

});

