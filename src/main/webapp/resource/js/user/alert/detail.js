window.addEventListener("load",function(){
    //기본정보
    var ctxName = this.document.querySelector(".ctx-name").value;
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;
    var section = this.document.querySelector("#section");
    //신청자 정보
    var cId = this.document.querySelector(".cid").value;
    //수락버튼 
    var accept = document.querySelector(".accept");
    //거절버튼
    var refuse = this.document.querySelector(".refuse");
   
    //수락버튼 클릭이벤트
    accept.onclick = function(){
        var xhr = new XMLHttpRequest();
        var info = 'cId='+cId;
        console.log(info);
        xhr.addEventListener("load",function(){
            if(xhr.responseText != -2)
                window.location.href=ctxName+"/index";
            else
                section.innerHTML="이미 커플상태입니다.";
        }); 
        xhr.open("POST",ctxName+"/couple/info/accept")
        xhr.setRequestHeader(header,token);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(info);
    }
    //거절버튼 클릭이벤트
    refuse.onclick = function(){
        var xhr = new XMLHttpRequest();
        xhr.addEventListener("load",function(){
            //데이터베이스 업데이트 되었다면 
            if(xhr.responseText != -1)
                window.location.href=ctxName+"/index";
            else
                alert("예기치못한 오류 발생");
        });
        xhr.open("GET",ctxName+"/couple/info/refuse?coupleId="+cId );
        xhr.send();

    }
});