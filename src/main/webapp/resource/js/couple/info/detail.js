window.addEventListener("load",function(){
    //프로토콜 기본정보
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;
    var ctxName = this.document.querySelector(".ctx-name").value;
    //영역
    var section = this.document.querySelector("#section");
    //커플 기본정보
    var profileDiv = this.document.querySelector("#couple-profile");
    var fileBtn = this.document.querySelector("input[name=file]");
    var nameBtn = this.document.querySelector(".name-update");
    var messageBtn = this.document.querySelector(".message-update");
    var coupleDeleteBtn = this.document.querySelector(".couple-delete"); 
    //유효성 정규식
    var imgExp= /\.(jpg|gif|tif|bmp|png)$/i;
    //update 속성값
    var poto = profileDiv.querySelector(".profile");
    var name = section.querySelector("input[name=name]");   
    var message = section.querySelector("input[name=message]");
    //이미지 트리거버튼
    profileDiv.onclick = function(e){
       // console.log(e.target.tagName)
        if(e.target.tagName !='IMG')
            return;

        var event = new MouseEvent("click",{
            view: window,
            bubbles:true,
            cancelable:true
        });
        fileBtn.dispatchEvent(event);
       
        fileBtn.onchange = function(){

            var file = fileBtn.files[0];
            console.log(file.name)
            if(!file.name.match(imgExp)){
                console.log("하이")
                alert("이미지파일만 가능합니다.")
                return ;
            }
            var formData = new FormData();
            formData.append("file",file)
            var xhr = new XMLHttpRequest();
            xhr.addEventListener("load",function(){
                //이미지 비동기 이루엄
				/* ============================================ */
				var reader = new FileReader();
				reader.onload = function(evt) {
                    poto.src = evt.target.result;
				}
				reader.readAsDataURL(file);
            });
            xhr.open("POST", "profile-upload");
            xhr.setRequestHeader(header,token);
            xhr.send(formData);
        }
    }
    //이름변경 모달이용
    nameBtn.onclick = function(){
        console.log(name.value);
        var modal = new Modal(name.value,"변경하시겠습니까?");
        modal.addEventListener("ok",function(){
            var xhr = new XMLHttpRequest();
            xhr.addEventListener("load",function(){
                window.location.reload();
            });
            xhr.open("GET","name-update?name="+name.value);
            xhr.send();
        });
        modal.show();
    }
    //메시지변경 모달이용
    messageBtn.onclick = function(){
        console.log(name.value);
        new Modal("input:input:예)홍길동","변경하시겠습니까?","ok")     
        .addEventListener("ok",function(inputText){
            var xhr = new XMLHttpRequest();
            xhr.addEventListener("load",function(){
                window.location.reload();
            });
            xhr.open("GET","message-update?message="+inputText);
            xhr.send();
        })
        .show();
    }
    //input/textarea
    // var modal = new Modal("input:input:예)홍길동","이름입력","ok,cancel");
    //커플끊기 모달이용
    coupleDeleteBtn.onclick = function(){
        console.log(name.value);
        var modal = new Modal("내용은 영구 삭제 됩니다.","헤어지시겠습니까?");
        modal.addEventListener("ok",function(){
            var xhr = new XMLHttpRequest();
            xhr.addEventListener("load",function(){
                window.location.href=ctxName+"/index";
            });
            xhr.open("GET","breakup");
            xhr.send();
        });
        modal.show();
    }
});

