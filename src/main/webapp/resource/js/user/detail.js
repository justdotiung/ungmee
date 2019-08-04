//프로필 변경 이벤트
window.addEventListener("load", function() {
	var profile = this.document.querySelector("#profile");
	var triggerBtn = profile.querySelector("input[type=button]");
	var fileBtn = profile.querySelector("input[name=file]");
	var poto = profile.querySelector(".profile");
	var token = this.document.querySelector("input[name=token]").value;
	var header = this.document.querySelector("input[name=header]").value;

	triggerBtn.onclick = function() {

		var event = new MouseEvent("click", {
			view : window,
			bubbles : true,
			cancelable : true
		});
		fileBtn.dispatchEvent(event);

		fileBtn.onchange = function() {
			var file = fileBtn.files[0];
			var formData = new FormData();
			formData.append("file", file);
			
			// alert("upload?" + scrf.value);
			// alert(token);
			// alert(header);
			var request = new XMLHttpRequest();

			request.addEventListener("load", function() {
				//이미지 비동기 이루엄
				/* ============================================ */
				var reader = new FileReader();
				//온로드 < 이벤트
				//function() < 이벤트 함수
				//evt < 이벤트 객체 (필요에 따라서 쓰일수있다.)
				reader.onload = function(evt) {
					poto.src = evt.target.result;
					alert(request.responseText);
				}
				//리더기 역할을 하게된다 시점을 모르게된다 읽는 시점
				reader.readAsDataURL(file);

				//--- 로컬파일 읽기 요청-------------------------

			});
			request.open("post", "upload");
			request.setRequestHeader(header,token);
			request.send(formData);
		};
	};
});

//이름변경 이벤트
window.addEventListener("load", function() {
	var nickNameDiv = this.document.querySelector("#nickname");
	var nickName = nickNameDiv.querySelector("input[type=text]");
	var nickNameBtn = nickNameDiv.querySelector(".eraser");

	nickNameBtn.onclick = function() {
		alert("들어옴");
		alert(nickName.value);
		//rquest 가 로드될때 실행해 달라고 한것임
		var request = new XMLHttpRequest();
		request.addEventListener("load", function() {
			alert(request.responseText);
		})
		request.open("GET", "nickname?nickName=" + nickName.value);
		request.send();
	};
});

//비밀번호 변경 이벤트
window.addEventListener("load", function() {
	var change = this.document.querySelector("#change");
	var select = change.querySelector(".chage-button");
	var div = select.nextElementSibling;//노드선택
	var pw = change.querySelector(".pw-button");
	var pwEquel = change.querySelector(".pw-button1");
	var error = change.querySelector(".error");
	var changeBtn = change.querySelector("input[type=button]");
	var token = this.document.querySelector("input[name=token]").value;
	var header = this.document.querySelector("input[name=header]").value;
	var isValide = false;
	// var div = select.parentElement.nextSibling;
	this.console.log(select.nodeType);

	select.onclick = function() {
		div.classList.add("current");
	}

	pwEquel.oninput = function() {
		console.log(pw.value);
		if (pw.value != pwEquel.value) {
			error.classList.remove("reverse")
			error.innerText = "비밀번호가 일치하지 않습니다."
			isValide = false;
		} else {
			
			error.classList.add("reverse")
			error.innerText = "일치합니다"
			isValide = true;
		}
	}
	changeBtn.onclick = function(e){
		//비밀번호 틀리면 넘기지못하게하는것
		e.preventDefault();

		var pwd = pw.value;
		var formData = new FormData();
		formData.append("pwd",pwd)	
		
		var request = new XMLHttpRequest();
		request.addEventListener("load",function(){
			alert(request.responseText);
			//변경후 text박스 초기화 
			pw. value="";
		});
		request.open("post","changepw");
		request.setRequestHeader(header,token);
	    request.send(formData);
	}
});
//커플 신청 이벤트
window.addEventListener("load",function(){
	var coupleBtn = this.document.querySelector("");

});
//이벤트동의변경 이벤트
window.addEventListener("load", function() {
	var eventDiv = this.document.querySelector("#event-check");
	var changBtn = eventDiv.querySelector("input[type=button]");
	var eState = eventDiv.querySelector("input[type=hidden]").value;
	var eventState = eventDiv.querySelector(".event-state");
	changBtn.onclick = function() {
		var formData = new FormData();
		if(eState =='비동의')
			eState = "동의";
		else
			eState = "비동의";
			
			var request = new XMLHttpRequest();
			request.addEventListener("load", function() {
				alert(request.responseText);
				eventState.innerText=eState;

			})
			request.open("GET", "changeev?eCheck=" + eState);
			request.send();
	};
});


