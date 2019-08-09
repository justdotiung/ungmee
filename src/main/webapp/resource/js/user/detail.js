// var token = null;
// var header = null;

// //프로필 변경 이벤트
// window.addEventListener("load", function() {
// 	token = this.document.querySelector("input[name=token]").value;
// 	header = this.document.querySelector("input[name=header]").value;

// 	//var x;

// 	token = 3;

// });

// window.addEventListener("load", function() {

// 	//프로필 변경
// 	var editProfile1 = function(){

// 	};

// 	//프로필 변경
// 	var editProfile2 = function(){
		
// 	};

// 	//프로필 변경
// 	var editProfile3 = function(){
		
// 	};

// 	editProfile1();
// 	editProfile2();
// 	editProfile3();

// });


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
		
//		submitBtn.onclick = function(){
//			var f1 = fileBtn1.files[0];
//			var f2 = fileBtn2.files[0];
//			
//			var formData = new FormData();
//			formData.append("file", f1);
//			formData.append("file", f2);
//		}

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
		//alert("들어옴");
		//alert(nickName.value);
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
	var changeBtn = change.querySelector(".btn");
	var token = this.document.querySelector("input[name=token]").value;
	var header = this.document.querySelector("input[name=header]").value;
	
	var isValide = false;
	// var div = select.parentElement.nextSibling;
	this.console.log(select.nodeType);

	select.onclick = function() {
		if(div.className !='d-none current')
			div.classList.add("current");
		else
			div.classList.remove("current");
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
			
			if(!isValide){
				e.preventDefault();
				alert("비밀번호가 일치하지 않습니다.");
				return;
			}
			
			var pwd = pw.value;
			var formData = new FormData();
			formData.append("pwd",pwd)	
			
			var request = new XMLHttpRequest();
			request.addEventListener("load",function(){
				alert(request.responseText);
				//변경후 text박스 초기화 
				pw.value="";
				pwEquel.value="";
				div.classList.remove("current");
			});
			request.open("POST","password/update");
			request.setRequestHeader(header,token);
			request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//post를 쿼리스트링으로 보낸다.
			request.send("pwd="+pwd);
		}
	}
});

//커플 신청 관리 코드 =========================================
window.addEventListener("load",function(){
	var token = this.document.querySelector("input[name=token]").value;
	var header = this.document.querySelector("input[name=header]").value;
	
	var infoDiv = this.document.querySelector("#info-div");
	var coupleName = infoDiv.querySelector(".couple-name");//커플명
	var Receiver = infoDiv.querySelector(".receiver");//상대방이메일
	var findReceiver = infoDiv.querySelector(".find-receiver");//상대방이메일찾기버튼
	var loveDate = infoDiv.querySelector(".love-date");//사귄날짜
	var message = infoDiv.querySelector(".message");//커플상태메세지
	var proposeId = infoDiv.querySelector(".hidden").value;//내아이디
	var submitBtn = infoDiv.querySelector(".btn");//보내기
	
	var proposeBtn = infoDiv.querySelector(".propose");//신청하기
	var infoForm = infoDiv.querySelector("#info-form");//신청폼
	
	
	var emailValide = false;//이메일 유효성
	var isValide =false; //유효성 변수
	var nameCheck = document.querySelector("#name-check");
	var emailCheck = document.querySelector("#email-check");
	var dateCheck = this.document.querySelector("#date-check");

	if(proposeBtn != null){
		proposeBtn.onclick = function(){
			infoForm.classList.add("current");
		}
	}

	//커플이름 검사 검사. 유니크키만들까말까?
	function nameValide(){
		if(!coupleName.value){
		//	coupleName.focus();
			nameCheck.classList.add("error");
			isValide=false;
			return ;
		}
		else{
			nameCheck.classList.remove("error");
			isValide= true;
		}
	}
	coupleName.onblur = function(){
		nameValide();
	}

	var partnerId = null; // 상대방아이디
	

	//상대방 이메일 입력 검사
	function idValide(){
		if(!Receiver.value){
			//Receiver.focus();
			emailCheck.classList.add("error");
			isValide=false;
			return ;
		}
		else{
			emailCheck.classList.remove("error");
			isValide= true;
		}
	}
	Receiver.onblur = function(){
		idValide();
	}	
	//상대방 유효성 검사정보 알아보기
	findReceiver.onclick =function(){
		var request = new XMLHttpRequest();
		request.addEventListener("load",function(){
			if(request.responseText != ''){
				emailCheck.classList.remove("error");
				partnerId = JSON.parse(request.responseText).id;
				//	alert("res:" + partnerId);
				// console.log("partnerid="+partnerId);
				// console.log("proposeid="+proposeId);
				if(partnerId == proposeId){
					alert("자신을 사랑하는것은 위반입니다.");	
					return ;
				}
				emailValide=true;
				alert("유효한 아이디입니다.");
			}
			else{
				emailCheck.classList.add("error");
				emailValide=false;
				alert("존재하지않는 아이디입니다.");
			}
		});
		request.open("GET","partner?email="+Receiver.value);
		request.send();
	}

	//커플일자 유효성 검사
	function dateValide(){
		if(!loveDate.value){
			//loveDate.focus();
			dateCheck.classList.add("error");
			isValide=false;
			return ;
		}
		else{
			dateCheck.classList.remove("error");
			isValide= true;
			return ;
		}
	}
	loveDate.onblur = function(){
		dateValide();
	}
	
	//커플정보 보내기
	submitBtn.onclick = function(e){
		e.preventDefault();
		nameValide();
		idValide();
		dateValide();
		
		if(!isValide){
			return ;
		}
		if(!emailValide){
			alert("찾아보기 클릭하기");
			return ;
		}
		var queryString = "coupleName="+coupleName.value+
						"&accepterId="+partnerId+
						"&sloveDate="+loveDate.value+
						"&message="+message.value+
						"&proposeId="+proposeId;
		//alert(queryString);
		
		var request = new XMLHttpRequest();
		request.addEventListener("load",function(){
	
			infoForm.classList.remove("current");
			if(request.responseText=='check'){
				window.location.reload();
				alert("신청완료");
			}
		});
		request.open("POST","propose");
		request.setRequestHeader(header,token);
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		request.send(queryString);
	}
	
});
//프러포즈 취소
window.addEventListener("load",function(){
	var proposeCancel = this.document.querySelector(".propose-cancel");//프로포즈취소
	if(proposeCancel != null){
		proposeCancel.onclick = function(){
			var request = new XMLHttpRequest();
			request.addEventListener("load",function(){
				window.location.reload();
				alert("프로포즈 실패");
			});
			request.open("GET","propose/cancel");
			request.send()
		}
	}
});
//이벤트동의변경 이벤트
window.addEventListener("load", function() {
	var eventDiv = this.document.querySelector("#event-check");
	var changBtn = eventDiv.querySelector("input[type=button]");
	var eState = eventDiv.querySelector("input[type=hidden]").value;
	changBtn.onclick = function() {	
		var request = new XMLHttpRequest();
		request.addEventListener("load", function() {
			window.location.reload();
			alert('변경되었습니다.');
		})
		request.open("GET", "event/update?e=" + eState);
		request.send();
	};
});
