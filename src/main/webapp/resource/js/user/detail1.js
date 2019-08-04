

//프로필 변경 이벤트
window.addEventListener("load", function() {
	var profile = this.document.querySelector("#profile");
	var triggerBtn = profile.querySelector("input[type=button]");
	var fileBtn = profile.querySelector("input[name=file]");
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
        
        var scrfValue = scrf.value;
        var file = fileBtn.files[0];
        var formData = new FormData();
        formData.append("file", file);
        
        fileBtn.onchange = function() {

			alert("upload?" + scrf.value);
			var request = new XMLHttpRequest();
			alert(" 요청해볼게요")
			requset.open("post", "upload?" + scrfValue,true);
			request.send(formData);

		};
	};

});
