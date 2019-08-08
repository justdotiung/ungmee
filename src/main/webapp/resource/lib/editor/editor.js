/**
 * 
 */

var set = {
   path:"",
   target:"",
   uploadHandler: null
};

function Editor(setting){
   
   if(arguments.length == 1){
      this.path = setting.path;
      this.selector = setting.selector;
   }
   else
   {
      this.path = arguments[0];
      this.selector = arguments[1];
   }
   
   if(this.path == undefined){
      alert('에디터에 라이브러리에 경로를 지정하지 않았습니다. \r\n 사용예 : var editor = new Editor("/resource/lib", ".textarea");');      
      return;
   }
   else if(this.selector == undefined){
      alert('에디터에 라이브러리에 <textarea>를 위한 선택자(selector)를 지정하지 않았습니다. \r\n 사용예 : var editor = new Editor("/resource/lib", ".textarea");');      
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
      link.setAttribute("href", this.path + "/editor.css")
         
      if (typeof link!="undefined")
         document.getElementsByTagName("head")[0].appendChild(link)
   },
   wrapTextAreaWidthDiv: function(){
      this.textArea = document.querySelector(this.selector);
   
      if(this.textArea == null){
         alert("선택자에 오류가 있어서 <textarea>를 정상적으로 로드하지 못했습니다.");
         return;
      }
      
      this.parentElement = this.textArea.parentElement;
      this.htmlEditor = document.createElement("div");
      
      // 텍스트 상자를 숨기고 그 자리에 같은 크기의 편집기를 추가하기
      this.htmlEditor.style.border="1px solid #e9e9e9";
      this.htmlEditor.style.width = this.textArea.offsetWidth + "px";
      this.htmlEditor.style.minHeight = this.textArea.offsetHeight + "px";
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
      request.open("GET", this.path+"/editor.html");
      request.send(null);
   },
   htmlLoadHandler:function(request){
      this.htmlEditor.innerHTML = request.responseText;
   },
   setPath : function(path){
      this.path = path;
   }
};