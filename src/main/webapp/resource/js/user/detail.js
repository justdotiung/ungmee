//비밀번호 변경 이벤트
window.addEventListener("load", function() {
	var change = this.document.querySelector("#change");
	var changeBtn = change.querySelector(".chage-button");
	var div = changeBtn.nextElementSibling;
	var pw = change.querySelector(".pw-button");
	var pwEquel = change.querySelector(".pw-button1");
	var error = change.querySelector(".error");
	var pwBtn = change.querySelector("input[type=button]");
	var scrf = document.querySelector("input[type=hidden]");
	var isValide = false;
	// var div = changeBtn.parentElement.nextSibling;

	this.console.log(changeBtn.nodeType);

	changeBtn.onclick = function() {
		div.classList.add("current");
	}

	pwEquel.oninput = function() {
		console.log(pw.value);
		if (pw.value != pwEquel.value) {
			error.innerText = "비밀번호가 일치하지 않습니다."
			isValide = false;
		} else {
			error.classList.add("reverse")
			error.innerText = "일치합니다"
			isValide = true;
		}
	}
	pwBtn.onclick = function(){
        alert(scrf.values);
        var pwd = pw.value;
        alert(pwd);
	    var request = new XMLHttpRequest();
	    request.open("post","change?"+scrf.value);
	    request.send(pwd);
	}

});

//이름변경 이벤트
window.addEventListener("load", function() {
	var nickNameDiv = this.document.querySelector("#nickname");
	var nickName = nickNameDiv.querySelector("input[type=text]");
	var nickNameBtn = nickNameDiv.querySelector(".eraser");

	nickNameBtn.onclick = function() {
		alert("들어옴");
		//rquest 가 로드될때 실행해 달라고 한것임
		var request = new XMLHttpRequest();
		request.addEventListener("load", function() {
			alert(request.responseText);
		})
		request.open("GET", "name?nickName=" + nickName.value);
		request.send();
	};
});

//프로필 변경 이벤트
window.addEventListener("load", function() {
	var profile = this.document.querySelector("#profile");
	var triggerBtn = profile.querySelector("input[type=button]");
	var fileBtn = profile.querySelector("input[type=file]");
	var poto = profile.querySelector(".profile");
	var scrf = document.querySelector("input[type=hidden]");
	// alert(scrf.value);
	triggerBtn.onclick = function() {

		var event = new MouseEvent("click", {
			view : window,
			bubbles : true,
			cancelable : true
		});
		fileBtn.dispatchEvent(event);

		fileBtn.onchange = function() {
			var scrfValue = scrf.value;
			var file = fileBtn.files[0];
			var formData = new FormData();
			formData.append("file", file);

			alert("upload?" + scrf.value);
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

			request.open("POST", "upload?" + scrfValue);
			request.send(formData);

		};
	};

});
