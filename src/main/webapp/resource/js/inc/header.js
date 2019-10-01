/*
//사용자 위치정보 위도 경도 
window.addEventListener("load",findLocation());
	function findLocation() {
		if (navigator.geolocation) { 
			window.navigator.geolocation.getCurrentPosition(showYourLocation); 
		} else { 
			loc.innerHTML = "이 문장은 사용자의 웹 브라우저가 Geolocation API를 지원하지 않을 때 나타납니다!"; 
		}
	}
	function showYourLocation(position){
		var po = "lat : "+ position.coords.latitude +", long :"+ position.coords.longitude;
		console.log(po);
	}
*/
window.addEventListener("load", function() {
	var ctx = document.querySelector(".ctx").value;
	var token = document.querySelector(".token").value;
	var header = document.querySelector(".header").value;
	//메뉴바
	var userList = document.querySelector("#user-menu");
	//class명에 tab 들어간것을 다 선택
	var tabDivs = document.querySelectorAll(".tab");
	//알림리스트 노출
	var alertBox = document.querySelector(".alert-box");//알람박스
	//로그아웃버튼
	var logoutBtn = document.querySelector(".logout-btn");

	//알림 마우스over필요한지안한지 (데스크탑만 onmouseover 가능)
	// if(alamBtn != null){
	// 	alamBtn.onmouseover = function(e) {
	// 		e.preventDefault();
	// 		alertBox.classList.toggle("d-none");

	// 		alamBtn.onmouseout = function() {
	// 			alertBox.classList.toggle("d-none");
	// 		}
	// 	}
	// 	newContent.onmouseover = function(e) {
	// 		e.preventDefault();
	// 		alertBox.classList.toggle("d-none");

	// 		newContent.onmouseout = function() {
	// 			alertBox.classList.toggle("d-none");
	// 		}
	// 	}
	// }

// 로그인시 메뉴 선택 이벤트 
	/*
	userList.onclick = function(e){
		//그룹화된 타겟이거나 A태그가 아니면 
		if(e.target.tagName != 'A' || !e.target.classList.contains("tab-btn"))
			return;
		
		e.preventDefault();
		
		//타겟 접근 더 간단하게 한다. 선택된 타겟의 다음 노드...
		e.target.nextElementSibling.classList.toggle("d-none");
		//조건문반복
		for(var i = 0; i<tabDivs.length; i++){
			//엘리먼트가 같지않다면 
			if(e.target.nextElementSibling !== tabDivs[i])
				//가려준다
				tabDivs[i].classList.add("d-none");
		}
	}
	*/
// 로그아웃 버튼 이벤트
	if(logoutBtn != null){
		logoutBtn.onclick = function(e){
			e.preventDefault();
			var xhr = new XMLHttpRequest();
			xhr.addEventListener("load",function(){
				console.log("로그아웃");
				window.location.reload();
			});
			xhr.open("POST",ctx+"/logout");
			xhr.setRequestHeader(header,token);
			xhr.send()
		}
	}
// 영역밖 클릭시 이벤트
	var isInside = function(target, element){
        
        var currentElement = target;
        do{

            if(currentElement === element){
                console.log("inside");
                return true;
            }

            currentElement = currentElement.parentElement;
            
        }while(currentElement);

        //console.log("outside");

		return false;
	};

	var isOutside = function(target, element){
		return !isInside(target, element);
	};
// 영역 클릭 이벤트 
	document.onclick =function(e){
		//리스트영역밖이면 상관없이 사라짐		
		if(isOutside(e.target, userList)){
			//coupleList.classList.add("d-none");
			alertBox.classList.add("d-none");
			return;
		}
		
	}
});
