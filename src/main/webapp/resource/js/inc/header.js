
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
window.addEventListener("load", function() {
	//커플 페이지 노출
	var coupleBtn = this.document.querySelector(".couple-btx");
	var coupleList = this.document.querySelector(".couple-info-toggle");
	//알림리스트 노출
	var uAtoggle = this.document.querySelector("#user-alert-toggle");
	var alertBox = this.document.querySelector(".alert-box");
	var newTable = this.document.querySelector(".alam-table");
	//html gps 라이브러리
	findLocation();
	//미세먼지 api
	// var key = "Vk0LBbN0X7MW7cwfHY1cB%2BDgKhHubcpgmLXX8NFZm0kjKG%2FKBw%2F1z2UgplRmAxnRVOvVn%2FbgzjOTxIJjc7YYGw%3D%3D";
	// var queryString = "?regId=11A00101&&Servicekey="+key;
	// var url = "http://newsky2.kma.go.kr/service/VilageFrcstDspthDocInfoService/WidOverlandForecast";
	
	// var xhr = new XMLHttpRequest();
	// xhr.addEventListener("load",function(){
	// 	console.log(xhr.responseText);
	// });
	// xhr.open("GET",url+queryString);
	// xhr.send();
	

	//알림 마우스over필요한지안한지 (데스크탑만 onmouseover 가능)
	if(uAtoggle != null){
		uAtoggle.onmouseover = function(e) {
			e.preventDefault();
			alertBox.classList.toggle("d-none");

			uAtoggle.onmouseout = function() {
				alertBox.classList.toggle("d-none");
			}
		}
		newTable.onmouseover = function(e) {
			e.preventDefault();
			alertBox.classList.toggle("d-none");

			newTable.onmouseout = function() {
				alertBox.classList.toggle("d-none");
			}
		}
	}
	if(coupleBtn != null){
		coupleBtn.onclick = function(){
			coupleList.classList.toggle("d-none");
		}
	}
});
