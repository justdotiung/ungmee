/*
"messaeg", "type"
또는 
{
   type:"message", // message | wait | content | input   
   url:"/notice/partial/list",
   message:"hello",
   title:"안내메시지"   
}
*/

var CSS = {};
CSS.set = function(element, attrs){
   for(var key in attrs)
      element.style[key] = attrs[key];
}

function Modal(setting) {
   
   // 속성들 ====================================
   this.screen = null;
   this.dialog = null;
   
   this.type = null;
   this.url = null;
   this.inputElement = "textarea";
   this.placeHolder = null;
   this.message = null;
   this.title = "알림 메시지";
   
   // 초기 설정 ====================================
   
   if(setting == undefined){
      this.type = "wait";
      this.message = "처리중...";
   }
   else if(typeof setting == "string"){
   
      // 메시지 다이얼로그
      this.type = "message";
      this.buttonType = "ok";
      this.message = arguments[0];
      this.title = arguments[1];
      
      // 컨텐츠 다이얼로그
      if(arguments[0].indexOf("url:") == 0) {
         this.type = "content";
         this.url = arguments[0].substr(4);
      }
      else if(arguments[0].indexOf("input:") == 0) {
         this.type = "input";
         var tokens = arguments[0].split(":");
         this.inputElement = tokens[1];         
         this.placeHolder = tokens[2];
      }
      
      if(arguments.length == 2) this.title = arguments[1];
      if(arguments.length == 3) this.buttonType = arguments[2];
      
   }
   else{
      this.type = "message";
      this.message = arguments[0];
      this.title = arguments[1];
   }
   
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
         background:"#ffffff",
         boxSizing: "border-box"
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
                  
      if(this.buttonType.indexOf("ok") >= 0)
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
      
      if(this.buttonType.indexOf("cancel") >= 0)
         cancelButton.style.display = "inline-block";
      
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
      var contentBox = this.dialog.querySelector(".content-box");
      var buttonBox = this.dialog.querySelector(".button-box");
      var okButton = buttonBox.querySelector(".ok-button");
      CSS.set(okButton, {
         display:"inline-block"
      });
      
      var inputElement = document.createElement(this.inputElement);
      inputElement.placeholder = this.placeHolder;
      inputElement.classList.add("input-element");
      CSS.set(inputElement,{
         minWidth:"200px",         
         width:"100%",   
         minHeight:"30px",            
         height:"100%",
         boxSizing: "border-box",
         paddingLeft:"5px",
         border:"1px solid #ced4da",
         borderRadius:".25rem",
         textAlign:"center"
      });
      if(this.inputElement == "textarea")
         CSS.set(inputElement,{
            minHeight:"150px",            
            height:"100%"      
         });
      
      
      contentBox.append(inputElement);
      
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
         this.okButtonCallback(this.getInputText());
      
      this.hide();
   },   
   cancelButtonClickHandler : function(e) {         
      if(this.cancelButtonCallback != null)
         this.cancelButtonCallback(this.getInputText());
      
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
      
      return this;
   
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
   },
   getInputText:function(){
      
      if(this.type != "input"){
         alert("입력 대화상자일 때만 사용이 가능한 메소드입니다.");
         return;
      }
      
      var contentBox = this.dialog.querySelector(".content-box");
      
      var inputElement = this.dialog.querySelector(".input-element");      
      return inputElement.value;   
      
   }
};


