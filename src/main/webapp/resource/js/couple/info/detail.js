window.addEventListener("load",function(){
    //프로토콜 기본정보
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;
    //커플 기본정보
    var profileDiv = this.document.querySelector("#couple-profile");
    var poto = profileDiv.querySelector(".profile");
    var fileBtn = this.document.querySelector("input[name=file]");
    var nameBtn = this.document.querySelector(".name-update");
    var messageBtn = this.document.querySelector(".message-update");
    var coupleDeleteBtn = this.document.querySelector(".couple-delete"); 
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

    }
    //메시지변경 모달이용
    messageBtn.onclick = function(){

    }
    //커플끊기 모달이용
    coupleDeleteBtn.onclick = function(){

    }
});

