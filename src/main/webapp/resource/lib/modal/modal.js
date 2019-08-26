/*
"messaeg", "type"
또는 
{
	type:"message", // message | wait | content | input	
	url:"/notice/partial/list",
	message:"hello"	
}
*/

var CSS = {};
CSS.set = function(element, attrs){
	for(var key in attrs)
		element.style[key] = attrs[key];
}

function Modal(setting) {
	
	// 속성들
	this.screen = null;
	this.dialog = null;
	
	var type = null;
	var url = null;
	var message = null;
	var title = "알림 메시지";
	
	if(setting == undefined){
		type = "wait";
		message = "처리중...";
	}
	else if(typeof setting == "string" && arguments.length == 2 && arguments[0].indexOf("url") == 0){
		type = "content";
		url = arguments[0].substr(4);
		title = arguments[1];
	}
	else if(typeof setting == "object"){
		type = setting.type;
		title = setting.title;
		
		if(url != undefined)
			url = setting.url;
	}
	else{
		type = "message";
		message = setting;
		title = arguments[1];
	}
	
	// 인스턴스 멤버 속성들 정의
	this.url = url;
	this.type = type;
	this.message = message;
	this.title = title;
	
	this.okButtonCallback = null;
	this.cancelButtonCallback = null;
};

Modal.prototype = {
	createScreen: function(){
		var screen = document.createElement("div");
		CSS.set(screen, {
			width:"100%",
			height:"100%",
			position:"fixed",
			top:"0px",
			left:"0px",
			background:"rgba(0,0,0,0.3)",
			opacity:"0",
			transition:"500ms opacity"
		});
		
		this.screen = screen;
		
	},
	createDialog: function(){
		var dialog = document.createElement("div");
		CSS.set(dialog, {
			display:"flex",
			flexDirection:"column",
			minWidth:"300px",
			maxWidth:"90%",
			minHeight:"100px",
			position:"absolute",
			top:"50%",
			left:"50%",
			transform:"translate(-50%, -100%)",
			background:"#fff",
			boxShadow:"0 0 20px rgba(0,0,0,0.3)",
			borderRadius:"10px",
			transition:"500ms transform",
			padding:"10px"
		});
		
		var titleBox = document.createElement("div");
		titleBox.innerText = this.title;
		titleBox.classList.add("title-box");
		CSS.set(titleBox, {
			display:"flex",
			alignItems:"center",
			textIndent:"10px",
			color:"#333333",
			borderButtom:"#797979",
			borderTopLeftRadius:"10px",
			height:"18px",
		    lineHeight: "18px",
		    padding: "10px",
	    	borderBottom: "1px solid #e5e5e5"
		});
		
		var contentBox = document.createElement("div");
		contentBox.classList.add("content-box");
		CSS.set(contentBox, {
			flexGrow:1,
			background:"#ffffff"
		});
		
		var buttonBox = document.createElement("div");
		buttonBox.classList.add("button-box");
		CSS.set(buttonBox, {
			//height:"50px",
			background:"#fefff8",
			borderTop:"#fefff8",
			textAlign:"center",
			marginTop:"10px"
		});
		
		var okButton = document.createElement("input");
		okButton.classList.add("ok-button");
		
		CSS.set(okButton, {
			cursor:"pointer",
			color:"#fff",
	    	backgroundColor: "#007bff",
	    	borderColor: "#007bff",
	    	fontWeight: "400",
	    	textAlign: "center",
	    	verticalAlign: "middle",
	    	border: "1px solid transparent",
	    	padding: ".375rem .75rem",
	    	fontSize: "1rem",
	    	lineHeight: "1.5",
	    	borderRadius: ".25rem",
			font: "400 13.3333px Arial",
			display:"none"
		});
		
		if(this.okButtonCallback != null)
			okButton.style.display = "inline-block";
		
		okButton.type="button";
		okButton.value="OK";
		okButton.onclick = this.okButtonClickHandler.bind(this);		
		
		var cancelButton = document.createElement("input");
		cancelButton.classList.add("cancel-button");
		CSS.set(cancelButton, {
			cursor:"pointer",
			marginLeft:"5px",
			color:"#fff",
			backgroundColor: "#6c757d",
		    borderColor: "#6c757d",
	    	fontWeight: "400",
	    	textAlign: "center",
	    	verticalAlign: "middle",
	    	border: "1px solid transparent",
	    	padding: ".375rem .75rem",
	    	fontSize: "1rem",
	    	lineHeight: "1.5",
	    	borderRadius: ".25rem",
			font: "400 13.3333px Arial",
			display:"none"
		});
		if(this.cancelButtonCallback != null)
			cancelButtonCallback.style.display = "inline-block";
		cancelButton.type="button";
		cancelButton.value="Cancel";
		cancelButton.onclick = this.cancelButtonClickHandler.bind(this);
				
		var closeButton = document.createElement("input");
		closeButton.type="button";
		closeButton.value="X";
		closeButton.onclick = this.closeButtonClickHandler.bind(this);
		CSS.set(closeButton, {
			position:"absolute",
			right:"-20px",
			top:"-20px",
			fontSize:"20px",
			width:"40px",
			height:"40px",
			border:"none",
			borderRadius:"20px",
			background:"#000000",
			color:"#ffffff",
			display:"flex",
			alignItems:"center",
			justifyContent:"center",
			fontWeight:"bold",
			cursor:"pointer"
		});
		
		buttonBox.append(okButton);
		buttonBox.append(cancelButton);
		
		dialog.appendChild(closeButton);
		dialog.appendChild(titleBox);
		dialog.appendChild(contentBox);
		dialog.appendChild(buttonBox);
		
		this.dialog = dialog;
	},
	createWaitDialog : function(){
		
		var ajaxIcon = document.createElement("img");
		ajaxIcon.src = "images/ajax-loader-1.gif";
		
		CSS.set(ajaxIcon, {
			minWidth:"32px",
			minHeight:"32px",
			position:"absolute",
			top:"50%",
			left:"50%",
			transform:"translate(-50%, -50%)"
		});

		this.dialog = dialog;
		return ajaxIcon;
	},
	createContentDialog : function() {
		this.createDialog();
		var contentBox = this.dialog.querySelector(".content-box");
		
	},
	createInputDialog : function() {
		this.createDialog();
		
	},
	createMessageDialog : function() {
		this.createDialog();
		var contentBox = this.dialog.querySelector(".content-box");
		
		contentBox.innerHTML = this.message;
		CSS.set(contentBox, {
			padding:"10px",
			textAlign:"center",
		    borderBottom: "1px solid rgb(229, 229, 229)"
		});
		
	},
	show : function() {
		this.createScreen();		
				
		switch(this.type){
		case "wait":
			this.createWaitDialog();
			break;
		case "content":
			this.createContentDialog();
			break;
		case "input":
			this.createInputDialog();
			break;
		default: // "message"
			this.createMessageDialog();
		}				
		
		document.body.appendChild(this.screen);		
		this.screen.addEventListener('transitionend', () => {
			document.body.appendChild(this.dialog);
			
			var dialog = this.dialog;
			setTimeout(function(){
				dialog.style.transform="translate(-50%, -50%)";
			},10);
			
		});
		
		var screen = this.screen;
		setTimeout(function(){
			screen.style.opacity = "1";			
		},10);
				
	},
	hide:function(e){
		if(this.screen){
			this.screen.remove();
			this.screen = null;
		}
		if(this.dialog){
			this.dialog.remove();
			this.dialog = null;
		}
	},
	closeButtonClickHandler : function(e) {				
		this.hide();
	},
	okButtonClickHandler : function(e) {			
		if(this.okButtonCallback != null)
			this.okButtonCallback();
		
		this.hide();
	},	
	cancelButtonClickHandler : function(e) {			
		if(this.cancelButtonCallback != null)
			this.cancelButtonCallback();
		
		this.hide();
	},
	addEventListener:function(eventName, callback){	
		
		switch(eventName){
		case "ok":
			this.okButtonCallback = callback;			
			break;
		case "cancel":
			this.cancelButtonCallback = callback;			
			break;
		}
	
	},
	isInside:function(target, element){
    
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
	},
	isOutside:function(target, element){
	    return !this.isInside(target, element);
	}
};