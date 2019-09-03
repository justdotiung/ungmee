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
	//커플 페이지 노출
	var coupleBtn = document.querySelector(".couple-btx");
	var coupleList = document.querySelector(".couple-info-toggle");
	//알림리스트 노출
	var uAtoggle = document.querySelector("#user-alert-toggle");
	var alertBox = document.querySelector(".alert-box");
	var newTable = document.querySelector(".alam-table");
	var logoutBtn = document.querySelector(".logout-btn");

	//알림 마우스over필요한지안한지 (데스크탑만 onmouseover 가능)
	// if(uAtoggle != null){
	// 	uAtoggle.onmouseover = function(e) {
	// 		e.preventDefault();
	// 		alertBox.classList.toggle("d-none");

	// 		uAtoggle.onmouseout = function() {
	// 			alertBox.classList.toggle("d-none");
	// 		}
	// 	}
	// 	newTable.onmouseover = function(e) {
	// 		e.preventDefault();
	// 		alertBox.classList.toggle("d-none");

	// 		newTable.onmouseout = function() {
	// 			alertBox.classList.toggle("d-none");
	// 		}
	// 	}
	// }
	if(coupleBtn != null){
		coupleBtn.onclick = function(e){
			e.preventDefault();
			coupleList.classList.toggle("d-none");
		}
	}
	
	if(logoutBtn != null){
		logoutBtn.onclick = function(e){
			e.preventDefault();
			var xhr = new XMLHttpRequest();
			xhr.addEventListener("load",function(){
				console.log("로그아웃");
				window.location.reload();
			});
			xhr.open("POST","logout");
			xhr.setRequestHeader(header,token);
			xhr.send()
		}
	}

	var isInside = function(target, element){
        
        var currentElement = target;
        do{

            if(currentElement == element){
                console.log("inside");
                return true;
            }

            currentElement = currentElement.parentElement;
            
        }while(currentElement);

        console.log("outside");

		return false;
	};

	var isOutside = function(target, element){
		return !isInside(target, element);
	};
	document.onclick =function(e){

		if(coupleList.classList.contains("d-none")){
			return;
		}

		if(isOutside(e.target, coupleBtn)){
			coupleList.classList.toggle("d-none");
		}
	};
});
