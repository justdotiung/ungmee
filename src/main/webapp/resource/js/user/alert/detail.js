window.addEventListener("load",function(){
    //기본정보
    var ctxName = this.document.querySelector(".ctx-name").value;
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;
    //신청자 정보
    var cId = this.document.querySelector(".pid").value;
    //수락버튼 
    var accept = document.querySelector(".accept");
    //거절버튼
    var refuse = this.document.querySelector(".refuse");
    
    accept.onclick = function(){
        var xhr = new XMLHttpRequest();
        var info = 'cId='+cId;
        xhr.addEventListener("load",function(){
            console.log(xhr.responseText);
        });
        xhr.open("POST",ctxName+"/couple/info/accept")
        xhr.setRequestHeader(header,token);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(info);
    }
});