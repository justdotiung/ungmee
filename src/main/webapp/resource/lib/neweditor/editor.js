/**
 * 
 */
function Resizer(element, container){
	// 크기 조정을 원하는 엘리먼트 노드
	this.element = element;
	// 크기 조절이 될 때 기준이 되는 부모 또는 조상 노드로써 영역을 담당하는 엘리먼트 노드
	this.container = container;
	this.wrapper = null;
	
	// 8방면에 크기 조절이 가능한 포인트 달기
	this.wrapping();
}

Resizer.prototype = {
	wrapping:function(){
		var parent = this.element.parentElement || null;
		if(parent && null);
		
		this.container.style.position = "relative";
		this.wrapper = document.createElement("div");
		this.wrapper.classList.add("test");
		
		this.pointers = [];
		
		this.wrapper.style.display = "inline-block";
		this.wrapper.style.position = "absolute";		
		var old = this.element.parentElement.replaceChild(this.wrapper, this.element);
		this.wrapper.appendChild(old);
		
		for(var i=0; i<8; i++){
			var p = document.createElement("div");
			
			p.style.border = "1px solid #e9e9e9";
			p.style.width = "10px";
			p.style.height = "10px";
						
			this.wrapper.appendChild(p);
			
			this.pointers[i] = p;
		}
		
		
	}
};
/*
var setting = {
	resourceUrl:null,
	targetSelector:null,
	uploadHandlerUrl: null,
	contextName:null
};
var editor = new Editor(setting);
또는
var editor = new Editor(resourceUrl, targetSelector, uploadHandlerUrl);
*/

function Editor(setting){
	
	if(typeof setting == "object"){
		this.resourceUrl = setting.path;
		alert(setting.path == undefined);
		this.targetSelector = setting.targetSelector;
		alert(setting.targetSelector == undefined);
		this.uploadHandlerUrl = setting.uploadHandlerUrl;
		alert(setting.targetSelectorUrl == undefined);
	}
	else
	{
		this.resourceUrl = arguments[0];
		this.targetSelector = arguments[1];
		this.uploadHandlerUrl = arguments[2];
	}
	
	if(this.resourceUrl == undefined){
		alert('에디터 라이브러리에 리소스 경로를 지정하지 않았습니다. \r\n 사용예 : var editor = new Editor("/resource/lib", ".textarea", "/upload");');		
		return;
	}
	else if(this.targetSelector == undefined){
		alert('에디터 라이브러리에 <textarea>를 위한 선택자(selector)를 지정하지 않았습니다. \r\n 사용예 : var editor = new Editor("/resource/lib", ".textarea", "/upload");');		
		return;
	}
	
	// 편집기 css 파일 로드
	this.loadCSS();
	
	// 편집을 위한 TextArea를 Div에 감싸서 대체하기
	this.wrapTextAreaWidthDiv();
	
	// 편집기 HTML 로드
	this.loadHTML();

};

Editor.prototype = {
	loadCSS: function(){
		var link=document.createElement("link")
		link.setAttribute("rel", "stylesheet")
		link.setAttribute("type", "text/css")
		link.setAttribute("href", this.resourceUrl + "/editor.css")
		console.log(this.resourceUrl);
		
		if (typeof link!="undefined")
			document.getElementsByTagName("head")[0].appendChild(link)
	},
	wrapTextAreaWidthDiv: function(){
		this.textArea = document.querySelector(this.targetSelector);
	
		if(this.textArea == null){
			alert("선택자에 오류가 있어서 <textarea>를 정상적으로 로드하지 못했습니다.");
			return;
		}
		
		this.parentElement = this.textArea.parentElement;
		this.htmlEditor = document.createElement("div");
		
		// this.htmlEditor 스타일 리셋
		this.htmlEditor.style.textAlign = "left";
		
		// 텍스트 상자를 숨기고 그 자리에 같은 크기의 편집기를 추가하기
		this.htmlEditor.style.border="1px solid #e9e9e9";
		//this.htmlEditor.style.width = this.textArea.offsetWidth + "px";
		this.htmlEditor.style.minHeight = this.textArea.offsetHeight + "px";

		// htmlLoadHandler에서 초기화 하는 멤버 변수들
		this.toolbar = null;
		this.htmlArea = null;
		this.optionBar = null;
		this.urlBox = null;
		this.fontSizeBox = null;
		this.fontColorBox = null;
		
		/*// TextArea에 코드 에디터 설정
		this.textEditor = CodeMirror.fromTextArea(this.textArea, {
			lineNumbers : true
		});*/
		
		this.parentElement.appendChild(this.htmlEditor);
		this.textArea.style.display = "none";
		
		
	},	
	loadHTML: function(){
		//편집기 영역에 편집기의 View를 담당하는 HTML 페이지를 로드한다.
		var request = new XMLHttpRequest();
		request.onload = this.htmlLoadHandler.bind(this, request);		
		request.onerror = function(e) {
			alert("예기치 못한 오류가 발생하였습니다.");
		};
		request.open("GET", this.resourceUrl+"/editor.html");
		request.send(null);
	},
	htmlLoadHandler:function(request){
		this.htmlEditor.innerHTML = request.responseText;
		this.htmlEditor.firstElementChild.appendChild(this.textArea);
				
		// 로드된 페이지에서 버튼 참조변수 선언하기
		// HTML 문서가 로그되면 편집 영역 객체 얻기
		this.toolbar = this.htmlEditor.querySelector(".com.newlecture.single-editor .toolbar");
		this.htmlArea = this.htmlEditor.querySelector(".com.newlecture.single-editor>.html-area");		
		this.optionBar = this.htmlEditor.querySelector(".com.newlecture.single-editor .option-bar");
		this.urlBox = this.optionBar.querySelector(".url-box");
		this.fontSizeBox = this.optionBar.querySelector(".font-size-box");
		this.fontColorBox = this.optionBar.querySelector(".font-color-box");
		
		var boldButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-bold");
		var underlineButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-underline");
		var italicButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-italic");
		
		var leftButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-left");
		var centerButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-center");
		var rightButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-right");
		
		var fontSizeButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-font-size");
		var fontColorButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-font-color");
		
		var imageButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-image");
		var linkButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-link");
		var htmlButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-html");
		var codeButton = this.toolbar.querySelector(".com.newlecture.single-editor>.toolbar .btn-code");
		
		// 파일 선택 버튼
		var fileButton = this.toolbar.querySelector("input[type='file']");
		
		var linkTextBox = this.optionBar.querySelector(".link-text");
		var linkUrlBox = this.optionBar.querySelector(".link-url");
		var addLinkButton = this.optionBar.querySelector(".btn-add-link");

		// 이벤트 바인딩
		this.htmlArea.addEventListener("dragener", this.htmlAreaDragEnterHandler.bind(this));
		this.htmlArea.addEventListener("dragleave", this.htmlAreaDragLeaveHandler.bind(this));
		this.htmlArea.addEventListener("dragover", this.htmlAreaDragOverHandler.bind(this));
		this.htmlArea.addEventListener("drop", this.htmlAreaDropHandler.bind(this));

		boldButton.onclick = this.boldHandler.bind(this);
		underlineButton.onclick = this.underlineHandler.bind(this);
		italicButton.onclick = this.italicHandler.bind(this);

		leftButton.onclick = this.leftHandler.bind(this);
		centerButton.onclick = this.centerHandler.bind(this);
		rightButton.onclick = this.rightHandler.bind(this);

		fontColorButton.onclick = this.fontColorButtonClickHandler.bind(this);
		this.fontColorBox.onclick = this.fontColorBoxClickHandler.bind(this);
		fontSizeButton.onclick = this.fontSizeButtonHandler.bind(this);
		this.fontSizeBox.onclick = this.fontSizeBoxClickHandler.bind(this);

		imageButton.onclick = this.imageButtonClickHandler.bind(this);
		linkButton.onclick = this.linkButtonClickHandler.bind(this);
		htmlButton.onclick = this.htmlButtonClickHandler.bind(this);
		codeButton.onclick = this.codeButtonClickHandler.bind(this);

	},
	htmlAreaDragEnterHandler:function(e){
		e.preventDefault();
		console.log("드랍존에 들어옴");
	},
	htmlAreaDragLeaveHandler:function(e){
		e.preventDefault();
		console.log("드랍존을 벗어남");
	},
	htmlAreaDragOverHandler:function(e){
		e.preventDefault();
		console.log("드랍존에서 움직이고 있음");
	},
	htmlAreaDropHandler:function(e){
		e.preventDefault();
		console.log("드랍");

		var files = e.dataTransfer.files;
        var size = files.length;
        
        if(size > 1){
            alert("파일은 하나씩만 업로드 할 수 있습니다.");
            return;
        }

        var file = files[0];
        console.log(file.type); // 파일 종류
        /*var regex = new RegEx("image/(jpeg|png|gif)");
        if(!file.type.match(regex)){
            alert("유효한 파일 형식 아닙니다.");
            return;
        }*/

        if(file.size > 10*1024*1024 ){
            alert("10메가 이상의 파일은 업로드 할 수 없습니다.");
            return;
        }

        if(this.uploadHandlerUrl == null){
			alert("파일 업로드를 처리하는 서버 url 이 설정되지 않았습니다.");
			return;
		}

		var formData = new FormData();
		formData.append("file", file);
		
		var request = new XMLHttpRequest(); // XML을 HTTP으로 요청을 보내고 응답을 받을 수 있는 도구		
		request.onerror = function(e) {
			alert("예기치 못한 오류가 발생하였습니다.");
		};
		request.onload = this.fileUploadHandler.bind(this,request);
		request.open("POST",
				//"../../upload?"+csrfParameter+"="+csrfToken,
				this.uploadHandlerUrl,
				true); // 데이터를 요청하기 위한 설정 // 세번째 파라메터 -> 비동기(true) or 동기(false) 설정
		
		request.send(formData);
	},
	fileUpload:function(){

		if(this.uploadHandlerUrl == null){
			alert("파일 업로드를 처리하는 서버 url 이 설정되지 않았습니다.");
			return;
		}

		var formData = new FormData();
		formData.append("file", file);
		
		var request = new XMLHttpRequest(); // XML을 HTTP으로 요청을 보내고 응답을 받을 수 있는 도구

		request.onerror = function(e) {
			alert("예기치 못한 오류가 발생하였습니다.");
		};

		request.onload = function(e) {
			this.fileUploadHandler.bind(this,request.responseText);
		};

		request.open("POST",
				//"../../upload?"+csrfParameter+"="+csrfToken,
				this.uploadHandlerUrl,
				true); // 데이터를 요청하기 위한 설정 // 세번째 파라메터 -> 비동기(true) or 동기(false) 설정
		
		request.send(formData);
	},
	/*fileUploadComplete:function(responseText){
		var path = responseText; // uploaded file path and name,
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
		
		// htmlEditor 와 textArea의 내용을 동기화. 
		setTimeout(function() {			
			this.textArea.value = this.htmlArea.innerHTML;
		}.bind(this), 200);

	},*/
	boldHandler:function(e){
		// 편집기에서 선택된 텍스트를 해제 시키는 것도 버튼의 기본 행위에 해당함.
		e.preventDefault();

		document.execCommand('bold');
	},
	underlineHandler:function(e){
		// 편집기에서 선택된 텍스트를 해제 시키는 것도 버튼의 기본 행위에 해당함.
		e.preventDefault();

		document.execCommand('underline');
	},
	italicHandler:function(e){
		// 편집기에서 선택된 텍스트를 해제 시키는 것도 버튼의 기본 행위에 해당함.
		e.preventDefault();

		document.execCommand('italic');
	},
	leftHandler:function(e){
		// 편집기에서 선택된 텍스트를 해제 시키는 것도 버튼의 기본 행위에 해당함.
		e.preventDefault();

		document.execCommand('justifyLeft');
	},
	centerHandler:function(e){
		// 편집기에서 선택된 텍스트를 해제 시키는 것도 버튼의 기본 행위에 해당함.
		e.preventDefault();

		document.execCommand('justifyCenter');
	},
	rightHandler:function(e){
		// 편집기에서 선택된 텍스트를 해제 시키는 것도 버튼의 기본 행위에 해당함.
		e.preventDefault();

		document.execCommand('justifyRight');
	},
	fontColorButtonClickHandler:function(e){
		// 편집기에서 선택된 텍스트를 해제 시키는 것도 버튼의 기본 행위에 해당함.
		e.preventDefault();

		//var optionBar = this.htmlEditor.querySelector(".com.newlecture.single-editor .option-bar");

		if(this.optionBar.classList.contains("hidden")){
			this.optionBar.classList.remove("hidden");
			
			this.fontColorBox.style.display = "flex";
			this.fontSizeBox.style.display = "none";
			this.urlBox.style.display = "none";
		}
		else{
			this.optionBar.classList.add("hidden");
			
			this.fontColorBox.style.display = "none";
			this.fontSizeBox.style.display = "flex";
			this.urlBox.style.display = "flex";
		}
	},
	fontColorBoxClickHandler:function(e){
		if(e.target.nodeName != "INPUT"){
			return;
		}
		
		var color = "#979797";
		
		switch(e.target.value){
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
		
		this.optionBar.classList.add("hidden");
		this.fontColorBox.style.display = "none";
	},
	fontSizeButtonHandler:function(e){
		// 편집기에서 선택된 텍스트를 해제 시키는 것도 버튼의 기본 행위에 해당함.
		e.preventDefault();
		    		
		if(this.optionBar.classList.contains("hidden")){
			this.optionBar.classList.remove("hidden");
			
			this.fontColorBox.style.display = "none";
			this.fontSizeBox.style.display = "flex";
			this.urlBox.style.display = "none";
		}
		else{
			this.optionBar.classList.add("hidden");
			
			this.fontColorBox.style.display = "flex";
			this.fontSizeBox.style.display = "none";
			this.urlBox.style.display = "flex";
		}

	},
	fontSizeBoxClickHandler:function(e){
		if(e.target.nodeName != "INPUT"){    			
			return;
		}
		
		var size = "1";
		
		if(e.target.classList.contains("btn-size-sm")){
			size = "2";
		}
		else if(e.target.classList.contains("btn-size-md")){
			size = "3";
		}
		else if(e.target.classList.contains("btn-size-lg")){
			size = "4";
		}
		else if(e.target.classList.contains("btn-size-xlg")){
			size = "5";
		}
		else if(e.target.classList.contains("btn-size-xxlg")){
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
		
		this.optionBar.classList.add("hidden");
		this.fontSizeBox.style.display = "none";
	},
	imageButtonClickHandler:function(e){
		// 1. 사용자가 업로드할 파일을 선택할 수 있도록
		var event = new MouseEvent("click", {
			'view' : window,
			'bubbles' : true,
			'cancelable' : true
		});
		
		var fileButton = this.toolbar.querySelector("input[type='file']");
		fileButton.dispatchEvent(event);
		fileButton.onchange = this.fileButtonChangeHandler.bind(this);
	},
	fileButtonChangeHandler:function(e){
		var fileButton = this.toolbar.querySelector("input[type='file']");
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
		
		xhr.onload = this.fileUploadHandler.bind(this, xhr);
		xhr.onerror = function(e) {
			alert("예기치 못한 오류가 발생하였습니다.");
		};
		//alert(this.uploadHandlerUrl);
		xhr.open("POST",
				//"../../upload?"+csrfParameter+"="+csrfToken,
				this.uploadHandlerUrl,					
				true); // 데이터를 요청하기 위한 설정 // 세번째 파라메터 -> 비동기(true) or 동기(false) 설정
		xhr.send(formData);
	},
	fileUploadHandler: function(xhr) {
		var htmlArea = this.htmlArea;
		
		var path = xhr.responseText; // uploaded file path and name,
		console.log(path);
		
		var wrapper = document.createElement("div");
		var img = document.createElement('img');
		//img.classList.add("newlecture-new-img");
		img.src = path;
		img.style.maxWidth = "80%";
		img.style.maxHeight = "80%";
		//img.style.border = "1px solid #e9e9e9";
		img.style.boxShadow = "0 4px 15px 0 rgba(0, 0, 0, 0.15)";
		img.contentEditable = true;
		wrapper.appendChild(img);
		console.log("innerHTML:"+wrapper.innerHTML);

		if (document.all) {
			var range = document.getSelection().createRange();
			range.pasteHTML(img);
			range.collapse(false);
			range.select();
		} else {
			this.htmlArea.focus();
			//document.execCommand("insertHTML", false, '<img src="'+path+'" contenteditable="true" style="max-width:90%;max-height:90%;border:1px solid #595959;" />');
			document.execCommand("insertHTML", false, wrapper.innerHTML);
			
			img.addEventListener("load", function(e){
				console.log("loaded");
				new Resizer(img, htmlArea);
			});
			//document.execCommand("insertImage", false, path);
		}
		
		img.style.border = "1px solid red";		
		
		// 이미지가 포함된 후에 그 포함된 내용을 전송을 위한 textArea에 설정.
		setTimeout(function() {			
			this.textArea.value = this.htmlArea.innerHTML;
		}.bind(this), 200);
	},
	linkButtonClickHandler:function(e){
		if(this.optionBar.classList.contains("hidden")){
			this.optionBar.classList.remove("hidden");
			
			this.fontColorBox.style.display = "none";
			this.fontSizeBox.style.display = "none";
			this.urlBox.style.display = "flex";
		}
		else{
			this.optionBar.classList.add("hidden");
			
			this.fontColorBox.style.display = "flex";
			this.fontSizeBox.style.display = "flex";
			this.urlBox.style.display = "none";
		}
		
		selection = {anchorNode:document.getSelection().anchorNode, anchorOffset:document.getSelection().anchorOffset, focusNode:document.getSelection().focusNode, focusOffset:document.getSelection().focusOffset};//.anchorNode;
	},
	htmlButtonClickHandler:function(e){
		if(this.htmlArea.style.display != "none"){
			this.textArea.style.height = this.htmlArea.offsetHeight+"px";
			this.textArea.style.width = this.htmlArea.offsetWidth-5+"px";			
			this.textArea.value = this.getHtml();
			this.textArea.style.display = "inline-block";
			
			this.htmlArea.style.display = "none";
		}
		else{
			this.textArea.style.display = "none";
			this.htmlArea.innerHTML = this.textArea.value;
			this.htmlArea.style.display = "block";
		}
	},
	codeButtonClickHandler:function(e){
		
		
		
		this.htmlArea.focus();
		document.execCommand("insertHTML", false, '<div style="min-height:20px;border:1px solid #e9e9e9;"><pre></pre></div>');
	},
	setResourceUrl:function(resourceUrl){
		this.resourceUrl = resourceUrl;
	},
	getHtml:function(){
		return this.htmlArea.innerHTML;
	}
};


/*

//===========================================================================================================
@RequestMapping(value = "upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
@ResponseBody
public String upload(
		MultipartFile file, HttpServletRequest request,
		Principal principal) {
	
	String writerId = "newlec";//principal.getName();
	String url = String.format("/resources/member/%s",writerId);
	
	ServletContext ctx = request.getServletContext();
	String contextPath = ctx.getContextPath();
	String path = ctx.getRealPath(url);
	
	File p = new File(path);
	if (!p.exists())
		if (!p.mkdirs())
			System.out.println("예기치 않은 이유로 폴더 생성에 실패하였습니다.");
	
	String fname = file.getOriginalFilename();
	String fpath = path + File.separator + fname;
	System.out.println(fpath);
	
	//=== 파일 저장하기 ============================================================
	
	InputStream fis = null;
	OutputStream fos = null;
	
	try {
		fis = file.getInputStream();
		fos = new FileOutputStream(fpath);
		
		int count = -1;
		
		byte[] buf = new byte[1024];
		while ((count = fis.read(buf)) != -1)
			fos.write(buf, 0, count);

		fis.close();
		fos.close();

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		try {
			fis.close();
			fos.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// 현재 업로드된 파일의 url 경로와 파일명을 반환한다.
	String result = contextPath + url + "/" + fname;
	
	System.out.println(result);
	
	return result;
	
}
*/