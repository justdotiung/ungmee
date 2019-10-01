window.addEventListener("load",function(){
	//기본정보
    var ctx = this.document.querySelector(".ctx");
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;
	
	var section = document.querySelector("#section");
	
    var file = section.querySelector("input[name=file]");
	var dropZone = section.querySelector("#drop-zone");
	var imgForm = dropZone.querySelector("img");
    var addBtn = section.querySelector("#add-button");
	var tagList = section.querySelector(".tag-list");
	var regBtn = section.querySelector("#reg-btn");
	var imgBtn = section.querySelector(".img-btn");
	var uTemplate = section.querySelector(".upload-template");
	
	
	//최대 이미지 파일 업로더 갯수 
	var maxImgList = [];
	//업로드할 파일 리스트
	var uploadFileList = [];
	//추가할 업로드 파일 리스트 카운트
	var uploadAddCount = 1;
	
	//이미지 객체.
	function imgFileHandler(e,imgCount){
		//부모노드
		var parentNode = e.target.parentNode;
		//부모의 부모노드
		var pParentNode = parentNode.parentNode;
		// 파일노드를 담은변수
		var file = pParentNode.nextElementSibling;
		console.log(file.type);
		//멀티파일 리스트
		console.log(pParentNode.tagName);
		var getFiles = file.files;
		console.log('getFiles : '+getFiles[0]);
		console.log('file : '+file);
		//한번에 올릴수있는 파일 갯수
		if(imgCount+getFiles.length>=3){
			console.log("최대 2장까지 가능합니다.")
			return;
		}
		
		//멀티파일 배열만큼 돌아서 이미지인지 판별
		for(var i = 0; i<getFiles.length; i++){
			//가져온 파일들의 i번째 파일
			var getFile = getFiles[i];			
			//이미지파일 우뮤 확인
			if(!getFile.type.match(/image.*/)){
				console.log("이미지파일만 가능");
				return ;
			}	
			
			uploadFileList.push(getFile);
			uploadAddCount++;
			maxImgList.push(file);

			//비동기 파일리더기 		
			var reader = new FileReader();				
			//이미지 로드시 추가 적으로 연산
			reader.onload = function(e) {
				//console.log(e.target.result);
				var imgTag = document.createElement("img");
				imgTag.classList.add("img");
				imgTag.src = e.target.result;
				parentNode.append(imgTag);
			}
			//console.log('e.target.className :'+e.target.className);
			//기본이미지 지우기
			if(e.target.className =='initial-img')
			e.target.style.display='none';
			
			reader.readAsDataURL(getFile);
		}
	
	};
	// 이미지버튼 객체
	var imgBtnClickHandler = function (e){
		var parentNode = e.target.parentNode;
		var pParentNode = parentNode.parentNode;
		var file = pParentNode.nextElementSibling;
		//console.log(file.type);
		//console.log(pParentNode.tagName);
		//비동기로 읽어온 이미지 파일수.
		imgCount = parentNode.querySelectorAll(".img").length;
		
		console.log(imgCount);
		//최대 업로더 갯수 조건
		if(imgCount>=2){
			console.log("더이상 파일업로드가 불가능합니다.");
			return;
		}
		//이미지태그가아니면 
        if(e.target.tagName !='IMG'){
			return;
        }
		//트리거 버튼 객체 
        var event = new MouseEvent("click",{
			view: window,
            bubbles:true,
            cancelable:true
		});
        file.dispatchEvent(event);
		
		file.onchange = function(){
			imgFileHandler(e,imgCount);
		};
	};
	
	//파일선택창 숨기기
	file.style.display = "none";

	imgBtn.onclick = imgBtnClickHandler;
	
	
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
	
	
	
	addBtn.onclick = function(){
		// 함수가 실행될때마다 몇개가있는지 묻는다.
		var spotDiv = section.querySelectorAll(".spot-div");
		console.log(spotDiv.length);
		//최대 2개까지 추가.
		if(spotDiv.length >2){
			return;
		}
		var clonDiv = document.importNode(uTemplate.content,true);
		var clonFile = clonDiv.querySelector("input[name=file]");
		var clonBtn = clonDiv.querySelector(".img-btn");	 
		clonFile.style.display="none";
		clonFile.onchange = imgFileHandler;
		clonBtn.onclick  = imgBtnClickHandler;
		//addBtn 앞에 생성.
		section.insertBefore(clonDiv, addBtn);
	}
	regBtn.onclick = function(){
		var formData = new FormData();
		//formData 추가 
		for(var i = 0; i<uploadAddCount; i++){
			formData.append("files",uploadFileList[i]);
		}
		console.log(formData.getAll("files"));
		var xhr = new XMLHttpRequest();
		xhr.addEventListener("load", function(){
			console.log(xhr.responseText);
		})
		xhr.open("POST","spot-img");
		xhr.setRequestHeader(header,token);
		xhr.send(formData);
	}
});