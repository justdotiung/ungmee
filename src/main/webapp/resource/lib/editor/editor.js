/**
 * 
 */

importCSS("editor.css");

window.addEventListener("load", function() {
	
	var textAreas = document.querySelectorAll("textarea");	
	
	for(var i=0; i<textAreas.length; i++){
		
		(function(){
			var textArea = textAreas[i];
			var parentElement = textArea.parentElement;
			var htmlEditor = document.createElement("div");
			
						
			// 텍스트 상자를 숨기고 그 자리에 같은 크기의 편집기를 추가하기
			htmlEditor.style.border="1px solid #e9e9e9";
		    htmlEditor.style.width = textArea.offsetWidth + "px";
		    htmlEditor.style.minHeight = textArea.offsetHeight + "px";
		    parentElement.appendChild(htmlEditor);
			textArea.style.display = "none";
			
			//편집기 영역에 편집기의 View를 담당하는 HTML 페이지를 로드한다.
		    var request = new XMLHttpRequest();
		    request.onload = function (e) {
		    	htmlEditor.innerHTML = request.responseText;
		    	
		    	// HTML 문서가 로그되면 편집 영역 객체 얻기
		    	var toolbar = htmlEditor.querySelector(".com.newlecture.single-editor .toolbar");
		    	var htmlArea = htmlEditor.querySelector(".com.newlecture.single-editor>.html-area");		    	
		    	var optionBar = htmlEditor.querySelector(".com.newlecture.single-editor .option-bar");
		    	var urlBox = optionBar.querySelector(".url-box");
		    	var fontSizeBox = optionBar.querySelector(".font-size-box");
		    	var fontColorBox = optionBar.querySelector(".font-color-box");
		    	
		    	var boldButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-bold");
		    	var underlineButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-underline");
		    	var italicButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-italic");
		    	
		    	var leftButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-left");
		    	var centerButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-center");
		    	var rightButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-right");
		    	    	
		    	var fontSizeButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-font-size");
		    	var fontColorButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-font-color");
		    	
		    	var imageButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-image");
		    	var linkButton = toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-link");
		    	/*var htmlButton = toolbar.querySelector("input[value='html']");*/
		    	
		    	// 파일 선택 버튼
		        var fileButton = toolbar.querySelector("input[type='file']");
		    	
		        var linkTextBox = optionBar.querySelector(".link-text");
		        var linkUrlBox = optionBar.querySelector(".link-url");
		        var addLinkButton = optionBar.querySelector(".btn-add-link");
		        
		        /*=== 파일 업로드 코드 ================================================================*/
		        var fileUpload = function(file){
		        	var formData = new FormData();
	    			formData.append("file", file);
	    			
	    			var xhr = new XMLHttpRequest(); // XML을 HTTP으로 요청을 보내고 응답을 받을 수 있는 도구
	    			
	    			xhr.onload = function(e) {

	                    var path = xhr.responseText; // uploaded file path and name,
	                    console.log(path);
	                    
	    				var img = document.createElement('img');
	    				img.src = path;
	    				img.style.maxWidth = "80%";
	    				img.style.maxHeight = "80%";
	    				img.style.border = "1px solid #e9e9e9";

	        			if (document.all) {
	        				var range = document.getSelection().createRange();
	        				range.pasteHTML(img);
	        				range.collapse(false);
	        				range.select();
	        			} else {
	        				document.execCommand("insertHTML", false, '<img src="'+path+'" style="max-width:90%;max-height:90%;border:1px solid #595959;" />');
	        			}
	        			
	        			// 이미지가 포함된 후에 그 포함된 내용을 전송을 위한 textArea에 설정. 
	        			setTimeout(function() {        		
	        				textArea = htmlArea.parentElement.parentElement.previousElementSibling;
	    		            textArea.value = htmlArea.innerHTML;
	        			}, 200);
	    			};

	    			xhr.onerror = function(e) {
	    				alert("예기치 못한 오류가 발생하였습니다.");
	    			};
	    			xhr.open("POST",
	    					//"../../upload?"+csrfParameter+"="+csrfToken,
	    					"/ungmeespring/admin/notice/upload",
	    					true); // 데이터를 요청하기 위한 설정 // 세번째 파라메터 -> 비동기(true) or 동기(false) 설정
	    			xhr.send(formData);
		        }
		        
		        // ==== 클립보드에 있는 캡쳐 이미지를 업로드하기 위한 코드 ====================================
		        htmlEditor.addEventListener("paste", function (evt) {
					/*if(evt.clipboardData.items.length > 1){
						alert("하나 이상의 아이템은 붙여넣기를 할 수 없습니다.");
						return;
					}*/
					
					var item = evt.clipboardData.items[0];
			        
			        if (item.type.indexOf("image") > -1) { // 클립보드 데이터가 아미지인 경우
			            var file = item.getAsFile();
			            fileUpload(file);
			        } else {
			            //alert("이미지 파일이 아닙니다.");
			        }
				});		             
		        
		        
		        // 기존 텍스트 상자에 있는 내용을 편집 모드로 가져온다.
		        htmlArea.innerHTML = textArea.value;
		        
		        htmlArea.onclick = function (evt) {
		        	textArea = htmlArea.parentElement.parentElement.previousElementSibling;
		            textArea.value = htmlArea.innerHTML;
		        };
		        
		        htmlArea.onmouseup = function (evt) {
		        	textArea = htmlArea.parentElement.parentElement.previousElementSibling;
		            textArea.value = htmlArea.innerHTML;
		            console.log("onmouseup : " + textArea.className);
		        };
		        
		        htmlArea.onkeyup = function (evt) {
		        	textArea = htmlArea.parentElement.parentElement.previousElementSibling;
		            textArea.value = htmlArea.innerHTML;
		            console.log("onkeyup : " + textArea.className);
		        };
		                
		        /*optionBar.querySelector("label").onmousedown = function(evt){
		        	console.log("label");
		        	
		        	// 편집기에서 텍스트 선택이 해제되지 않게하는 비법??? ㅜㅜ
		        	evt.preventDefault();
		        	
		        };*/
		    	
		    	boldButton.onclick = function(){
		    		document.execCommand('bold');    		
		    	};
		    	
		    	underlineButton.onclick = function(evt){
		    		document.execCommand('underline');
		    		// 편집기에서 텍스트 선택이 해제되지 않게하는 비법??? ㅜㅜ
		        	evt.preventDefault();
		    	};
		    	
		    	italicButton.onclick = function(evt){
		    		// 편집기에서 텍스트 선택이 해제되지 않게하는 비법??? ㅜㅜ
		    		evt.preventDefault();

		    		document.execCommand('italic');
		    	};
		    	/*----------------------------------------------------*/
		    	leftButton.onclick = function(evt){
		    		document.execCommand('justifyLeft');
		    		// 편집기에서 텍스트 선택이 해제되지 않게하는 비법??? ㅜㅜ
		        	evt.preventDefault();
		    	};
		    	
		    	centerButton.onclick = function(evt){
		    		document.execCommand('justifyCenter');
		    		// 편집기에서 텍스트 선택이 해제되지 않게하는 비법??? ㅜㅜ
		        	evt.preventDefault();
		    	};
		    	
		    	rightButton.onclick = function(evt){
		    		document.execCommand('justifyRight');
		    		// 편집기에서 텍스트 선택이 해제되지 않게하는 비법??? ㅜㅜ
		        	evt.preventDefault();
		    	};
		    	
		    	/*--- font-color handlers -------------------------------------------------*/
		    	fontColorButton.onclick = function(evt){
		    		evt.preventDefault();
		    		if(optionBar.classList.contains("hidden")){
		    			optionBar.classList.remove("hidden");
		    			
		    			fontColorBox.style.display = "flex";
		    			fontSizeBox.style.display = "none";
		    			urlBox.style.display = "none";
		    		}
		    		else{
		    			optionBar.classList.add("hidden");
		    			
		    			fontColorBox.style.display = "none";
		    			fontSizeBox.style.display = "flex";
		    			urlBox.style.display = "flex";
		    		}
		    		
		    	};
		    	
		    	fontColorBox.onclick = function(evt){
		    		
		    		if(evt.target.nodeName != "INPUT"){
		    			return;
		    		}
		    		
		    		var color = "#979797";
		    		
		    		switch(evt.target.value){
		    		case "color-warning":
		    			color = "#ff0000";
		    			break;
		    		case "color-notice":
		    			color = "#dd8a00";
		    			break;
		    		case "color-highlight":
		    			color = "#709629";
		    			break;
		    		case "color-normal":
		    			color = "#979797";
		    			break;
		    		case "color-strong":
		    			color = "#000000";
		    			break;
		    		}
		    		
		    		
		    		document.execCommand('foreColor', false, color);
		    		/*var span = document.createElement("span");
		    		span.textContent = document.getSelection();
		    		span.style.color = color;
		    		
		    		console.log(span.outerHTML);
		    		document.execCommand('insertHTML', false, span.outerHTML);*/
		    		
		    		optionBar.classList.add("hidden");
		    		fontColorBox.style.display = "none";
		    	};
		    	
		    	
		    	/*--- font-size handlers -------------------------------------------------*/
		    	fontSizeButton.onclick = function(evt){
		    		evt.preventDefault();
		    		
		    		if(optionBar.classList.contains("hidden")){
		    			optionBar.classList.remove("hidden");
		    			
		    			fontColorBox.style.display = "none";
		    			fontSizeBox.style.display = "flex";
		    			urlBox.style.display = "none";
		    		}
		    		else{
		    			optionBar.classList.add("hidden");
		    			
		    			fontColorBox.style.display = "flex";
		    			fontSizeBox.style.display = "none";
		    			urlBox.style.display = "flex";
		    		}
		    	};
		    	
		    	fontSizeBox.onclick = function(evt){
		    		
		    		if(evt.target.nodeName != "INPUT"){    			
		    			return;
		    		}
		    		
		    		var size = "1";
		    		
		    		if(evt.target.classList.contains("btn-size-sm")){
		    			size = "2";
		    		}
		    		else if(evt.target.classList.contains("btn-size-md")){
		    			size = "3";
		    		}
		    		else if(evt.target.classList.contains("btn-size-lg")){
		    			size = "4";
		    		}
		    		else if(evt.target.classList.contains("btn-size-xlg")){
		    			size = "5";
		    		}
		    		else if(evt.target.classList.contains("btn-size-xxlg")){
		    			size = "6";
		    		}
		    		else{
		    			alert("예기치 않은 오류가 발생하였습니다.");
		    			return;
		    		}
		    		
		    		document.execCommand("fontSize", false, size);
		    		
		    		/*var sel = document.getSelection();
		    		alert(sel);
		    		var range = sel.getRangeAt(0);
		    		alert(range);*/
		    		
		    		/*var span = document.createElement("span");
		    		span.innerHTML = document.getSelection();
		    		span.style.fontSize = size;
		    		
		    		console.log(span.outerHTML);
		    		document.execCommand('insertHTML', false, span.outerHTML);*/
		    		
		    		optionBar.classList.add("hidden");
		    		fontSizeBox.style.display = "none";
		    	};
		    	
		    	/*fontFamilyButton.onclick = function(evt){
		    		evt.preventDefault();
		    		document.execCommand('justifyRight');
		    	};*/
		    	/*----------------------------------------------------*/
		    	imageButton.onclick = function(evt){
		    		    		
		    		// 1. 사용자가 업로드할 파일을 선택할 수 있도록
		    		var event = new MouseEvent("click", {
		    			'view' : window,
		    			'bubbles' : true,
		    			'cancelable' : true
		    		});
		    		
		    		fileButton.dispatchEvent(event);
		    		fileButton.onchange = function(){
		    			
		    			var file = fileButton.files[0];
		    			//var csrfParameter = document.querySelector("meta[name='_csrf_parameter']").content;
		    			//var csrfToken = document.querySelector("meta[name='_csrf']").content;
		    			
		    			var size = file.size;
		    			if(size > 10*1024*1024){
		    				alert("죄송합니다. 10MB를 넘는 파일은 전송할 수 없습니다.");
		    				return;
		    			}
		    			
		    			// 파일의 MIME 형식이 "image/"로 시작되지 않으면 오류 출력
		    			if(file.type.indexOf("image/") != 0){
		    				alert("이미지 형식이 아닙니다.");
		    				return;
		    			}
		    			
		    			var formData = new FormData();
		    			formData.append("file", file);
		    			
		    			var xhr = new XMLHttpRequest(); // XML을 HTTP으로 요청을 보내고 응답을 받을 수 있는 도구
		    			
		    			xhr.onload = function(e) {

		                    var path = xhr.responseText; // uploaded file path and name,
		                    console.log(path);
		                    
		    				var img = document.createElement('img');
		    				img.src = path;
		    				img.style.maxWidth = "80%";
		    				img.style.maxHeight = "80%";
		    				//img.style.border = "1px solid #e9e9e9";
		    				img.style.boxShadow = "0 4px 15px 0 rgba(0, 0, 0, 0.15)";

		        			if (document.all) {
		        				var range = document.getSelection().createRange();
		        				range.pasteHTML(img);
		        				range.collapse(false);
		        				range.select();
		        			} else {
		        				document.execCommand("insertHTML", false, '<img src="'+path+'" style="max-width:90%;max-height:90%;border:1px solid #595959;" />');
		        			}
		        			
		        			// 이미지가 포함된 후에 그 포함된 내용을 전송을 위한 textArea에 설정. 
		        			setTimeout(function() {        		
		        				textArea = htmlArea.parentElement.parentElement.previousElementSibling;
		    		            textArea.value = htmlArea.innerHTML;
		        			}, 200);
		    			};

		    			xhr.onerror = function(e) {
		    				alert("예기치 못한 오류가 발생하였습니다.");
		    			};
		    			xhr.open("POST",
		    					//"../../upload?"+csrfParameter+"="+csrfToken,
		    					"/ungmeespring/admin/notice/upload", //나중에 컨텍스트위치 없애자 //업로드 컨트롤러 주소
		    					true); // 데이터를 요청하기 위한 설정 // 세번째 파라메터 -> 비동기(true) or 동기(false) 설정
		    			xhr.send(formData);
		    			
		    			
		    			
		    		};

				};
				
				/*--- link handlers ---------------------------------------------------------------------------*/
		    		
				var urlFragment = null;
				var selection = {anchorNode:null, anchorOffset:null, focusNode:null, focusOffset:null};
				
		    	linkButton.onclick = function(){
		    		if(optionBar.classList.contains("hidden")){
		    			optionBar.classList.remove("hidden");
		    			
		    			fontColorBox.style.display = "none";
		    			fontSizeBox.style.display = "none";
		    			urlBox.style.display = "flex";
		    		}
		    		else{
		    			optionBar.classList.add("hidden");
		    			
		    			fontColorBox.style.display = "flex";
		    			fontSizeBox.style.display = "flex";
		    			urlBox.style.display = "none";
		    		}
		    		
		    		selection = {anchorNode:document.getSelection().anchorNode, anchorOffset:document.getSelection().anchorOffset, focusNode:document.getSelection().focusNode, focusOffset:document.getSelection().focusOffset};//.anchorNode;
		    	};
		    	
		    	addLinkButton.onclick = function(){
		    		/*
		    		var urlFragment = document.getSelection().getRangeAt(0).cloneContents();
		    		if(urlFragment.childNodes.length==0){
		    			alert("링크를 걸기위한 텍스트를 선택하지 ")
		    		}*/
		    		
		    		if(document.getSelection().anchorNode.nodeName=="DIV"){
		    			document.getSelection().setBaseAndExtent(selection.anchorNode, selection.anchorOffset,selection.focusNode,selection.focusOffset);
		    		}
		    		
		    		var a = document.createElement("a");
		    		a.href = linkUrlBox.value;
		    		a.textContent = linkTextBox.value;
		    		
		    		var container = document.createElement("div");
		    		container.appendChild(document.getSelection().getRangeAt(0).cloneContents());
		    		
		    		document.execCommand("insertHTML", false, a.outerHTML);
		    		
		    		linkUrlBox.value = "";
		    		linkTextBox.value = "";
		    		
		    		optionBar.classList.add("hidden");
		    	};
		    	    	
		    	/*htmlButton.onclick = function(){
		    		document.execCommand('justifyRight');
		    	};*/    	    
		        
		    	//htmlArea.focus();
		        
		    };

		    request.open("GET", "reg");
		    request.send(null);
		})();	
	}
	
	    
    
});




