window.addEventListener("load",function(){
    var section = document.querySelector("#body");
    var pw = section.querySelector("input[name=pw]");
    var pwCheck = section.querySelector("input[name=pw-check]");
    var loginBtn = section.querySelector("input[type=submit]");
    var same = section.querySelector("#same");
    var t = section.querySelector(".t");
    var d = section.querySelector(".d");
    var tag1 = section.querySelector("#tag1");
    var tag2 = section.querySelector("#tag2");
   
    pwCheck.oninput =function(){
        if(pw.value != pwCheck.value)
            same.innerText="비밀번호가 일치하지 않습니다.";
        else
            same.innerText="일치합니다.";
   }
    loginBtn.onclick = function(){
        alert("gkdl");
    }

    t.onclick = function(){
        tag1.classList.remove("d-none");
        if(tag2 != null)
            tag2.classList.remove("current");
    };
    d.onclick = function(){
        tag1.classList.add("d-none");
        tag2.classList.add("current");
    };
});

