window.addEventListener("load",function(){
    var ctx = this.document.querySelector(".ctx");
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;

    var section = document.querySelector("#section");
    var triggerBtx = section.querySelector(".trigger-button");
    var file = section.querySelector("#file");
	var dropZone = section.querySelector("#drop-zone");
	var imgForm = dropZone.querySelector("img");
    var addBtn = section.querySelector("#add-button");
    var spotDiv = section.querySelector("#spot-div");
	var tagList = section.querySelector(".tag-list");
	//최대 이미지 파일 업로더 갯수 
	var maxImgList = [];
    triggerBtx.onclick = function(e){
		if(maxImgList.length>=2){
			console.log("더이상 파일업로드가 불가능합니다.");
			return;
		}
		console.log(maxImgList.length);
		// console.log(e.target.tagName)
        if(e.target.tagName !='IMG'){
			// console.log("aa");
            return;
        }
		
        var event = new MouseEvent("click",{
			view: window,
            bubbles:true,
            cancelable:true
		});
        file.dispatchEvent(event);
		
        file.onchange = function(){
			if(maxImgList.length>=2){
				console.log("더이상 파일업로드가 불가능합니다.");
				return;
			}
			//멀티파일 리스트
			var getFiles = file.files;
			//한번에 올릴수있는 파일 갯수
			if(getFiles.length>=3){
				console.log("최대 2장까지 가능합니다.")
				return;
			}

			console.log(getFiles.length);
			//멀티파일 배열만큼 돌아서 이미지인지 판별
			for(var i = 0; i<getFiles.length; i++){
				var getFile = getFiles[i];
				console.log(getFile.type);
				//이미지파일 우뮤 확인
				if(!getFile.type.match(/image.*/)){
					console.log("이미지파일만 가능");
					return ;
				}
				maxImgList.push(file);	
				//비동기 파일리더기 						
				var reader = new FileReader();
				console.log("된다");
				//이미지 로드시 추가 적으로 연산
				reader.onload = function(e) {
					console.log(e.target.result);
					dropZone.innerHTML +='<img src="'+e.target.result+'"/>'; 
				}
				reader.readAsDataURL(getFile);
			}
		}
	}
	dropZone.addEventListener("dragenter", function(e) {
		e.preventDefault();

		console.log("들어왔냐?")

		for ( var key in e.dataTransfer)
			console.log(key);

		for ( var key in e.dataTransfer.types[0])
			console.log(e.dataTransfer.types[0]);
	});
	dropZone.addEventListener("dragleave", function(e) {
		e.preventDefault();
		dropZone.classList.remove("invalide");
		dropZone.classList.remove("valide");
		console.log("E떠날거니")
	});
	dropZone.addEventListener("dragover", function(e) {
		e.preventDefault();
		// dropZone.classList.remove("invalide")
		console.log("이동중")
		if (e.dataTransfer.types != "Files") {
			// alert("잘못된것입니다.")
			dropZone.classList.add("invalide")
		} else {
			dropZone.classList.add("valide")
		}
		// window.setInterval()
	});

	dropZone.addEventListener("drop", function(e) {
		e.preventDefault();

		var files = e.dataTransfer.files;
		var size = files.length;

		if (size > 1) {
			alert("파일은 하나씩만 업로드 할 수 있습니다.");
			return;
		}

		var file = files[0];
		console.log(file.type);// 파일종류

		// var regex = new RegExp("image/(jpeg|png|gif)");
		// if (!file.type.match(regex)) {
		// alert("유효하지않은 파일형식입ㄴ미다")
		// return;
		// }

		// if(file.type.match(/image(jpeg|png|gif)/)){
		// alert("유효하지않은 파일형식입ㄴ미다")
		// return;
		// }
		//    

		if (file.size > 10 * 1024 * 1024) {
			alert("10메가 이상의 파일은 업로드 할 수 없습니다.");
			return;
		}
		console.log("내려놨니?")

		var formData = new FormData();
		formData.append("file", file);
		

		var request = new XMLHttpRequest();
		request.addEventListener("load", function() {
			alert(request.responseText);
			if(request.responseText == "okay"){
				var req = new XMLHttpRequest();
				req.addEventListener("load", function() {
					alert(req.respnseText);
				});
			request.open("GET","../../../file-list");
			request.send();
			}
		});
		request.upload.addEventListener("progress", function(e) {
			console.log(e.loaded);
			if (e.lengthComputable){
				console.log(Math.round(e.loaded * 100 / e.total));
				percentSpan.innerText = Math.round(e.loaded * 100 / e.total);
				progressDiv.style.width = Math.round(e.loaded * 100 / e.total)+'%';
			}
		});
		request.open("POST", "../../../upload");
		request.send(formData);
	});
	var addList =[] ;
    addBtn.onclick = function(e){
		addList.push(addBtn);
		if(addList.length >2){
			return;
		}
		var clonDiv = spotDiv.cloneNode(true);
		 section.insertBefore(clonDiv, addBtn);
    }
});