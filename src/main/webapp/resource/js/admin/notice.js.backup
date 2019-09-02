//window.addEventListener("load",function(){
//    var section = this.document.querySelector("#noticelist");
//    var content = section.querySelector(".content")
//    var DetailButton = section.querySelector(".btn-detail");
//    
//    DetailButton.onclick = function(e){
//        alert("test");
//        var detail = document.createElement("div");
//        detail.className = "content";
//        content.appendChild(detail);
//    };
// 
//});

//스마트에디터
window.addEventListener("load", function() {
	var ctxName = document.querySelector("input[name=ctx-name]").value;
	
	alert("ctxName =:"+ctxName);
	var oEditors = [];
	
	//추가 글꼴 목록
	//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];
	
	nhn.husky.EZCreator
			.createInIFrame({
				oAppRef : oEditors,
				elPlaceHolder : "content",
				sSkinURI : ctxName + "/resource/lib/SmartEditor/SmartEditor2Skin.html",
				htParams : {
					bUseToolbar : true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseVerticalResizer : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseModeChanger : true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
					//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
					fOnBeforeUnload : function() {
						//alert("완료!");
					}
				}, //boolean
				fOnAppLoad : function() {
					//예제 코드
					//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
				},
				fCreator : "createSEditor2"
			});
	
	function pasteHTML() {
		var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
		oEditors.getById["content"].exec("PASTE_HTML", [ sHTML ]);
	}
	
	function showHTML() {
		var sHTML = oEditors.getById["content"].getIR();
		alert(sHTML);
	}
	
	function submitContents(elClickedObj) {
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됩니다.
		//textarea 의 id 를 content로 각각 맞춰주기 변경 시 전부 변경!
		// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
	
		try {
			elClickedObj.form.submit();
		} catch (e) {
		}
	}
	
	function setDefaultFont() {
		var sDefaultFont = '궁서';
		var nFontSize = 24;
		oEditors.getById["content"].setDefaultFont(sDefaultFont, nFontSize);
	}
});



//notice 내용 자세히보기
window.addEventListener("load",function(){
    var section = this.document.querySelector("#notice");
    //버튼이 여러개 -> 부모에게 걸어준다
    var noticeLists = section.querySelector(".notice-lists");
    noticeLists.onclick = function(e){
        var contentDiv = e.target.parentElement.nextElementSibling;
        console.log("00"+e.target);
        console.log("00"+e.target.className);
        contentDiv.classList.add("current");
    };
//    noticeLists.addEventListener("click",function(e){
//        console.log("gma")
//         if(e.target.type !='button')
//             return;
//             console.log("gkgk")
//         for(var i = 0; i<detailButton.length; i++){
//             if(detailButton[i].onclick)
//             console.log("gpgp")
//                 content[i].classList.add("current");
//         }
//    })
   
    //     console.log('e'+e.currentTarget);
    //     for(var i =0; i<detailButtons.length; i++)
    //    console.log(detailButtons.length);
    //     // var detailButton = e.target;
    //    // if(!detailButton.classList.contains("btn-detail"))
    //     // return;

 	
    // 	// var contentDiv = detailButton.parentElement.nextElementSibling;
    // 	// //console.log(typeof content);
    // 	// contentDiv.classList.add("current");

    //     alert("내용을 불러옴");
    //     content.classList.add("current");
    // }
  
 
});


//스크롤 페이징

var pageLoaded = 1;

window.addEventListener("scroll", function(e){
    var pageHeight=document.documentElement.offsetHeight,
        windowHeight=window.innerHeight,
        scrollPosition=window.scrollY || window.pageYOffset || document.body.scrollTop + (document.documentElement && document.documentElement.scrollTop || 0);

        //var x = 3 || 0;
        //alert(x);
        if (pageHeight <= windowHeight+scrollPosition+200) {
            //alert('At the bottom');
            
             //var num = morepage.value;
             var request = new XMLHttpRequest();
             request.addEventListener("load" ,function() {
                 //버튼이 여러개 -> 부모에게 걸어준다
                 
                var json = JSON.parse(request.responseText);
                 console.log(request.responseText);
                 //alert(json);
                 
                 var template = document.querySelector("main .notice-template");
                 //body.innerHTML = ""; //다 지우기
                 for (var i = 0; i < json.length; i++) {
                 var cloneTr = document.importNode(template.content, true);  
                 var categoryEl = cloneTr.querySelector(".categoryName");
                 var writerEl = cloneTr.querySelector(".writerId");
                 var regdateEl = cloneTr.querySelector(".regDate");
                 var titleEl = cloneTr.querySelector(".title");
                 var contentEl = cloneTr.querySelector(".content");
                 categoryEl.innerText = json[i].categoryName;
                 writerEl.innerText = json[i].writerId;
                 regdateEl.innerText = json[i].regDate;
                 titleEl.innerText = json[i].title;
                 contentEl.innerText = json[i].content;         
                 console.log(json[i].id);
                 
                 notice.append(cloneTr);
                }
                 
                 
                 var noticeLists = document.querySelectorAll(".notice-template-section");
                 
                 for(var i =0;  i < noticeLists.length; i++){
                    noticeLists[i].onclick =function(e){

                        var contentDiv = e.target.parentElement.nextElementSibling;
                        // console.log("00"+e.target);
                        // console.log("00"+e.target.className);
                        contentDiv.classList.add("current");
                    }
                }
                
                   
            });
            request.open("GET", "list-json?p=" + (++pageLoaded));
            request.send();
        }
    });
    
//             morepage.value = ++num;
//             console.log(num);
//             var json = JSON.parse(request.responseText);
//             alert(json);
//             var template = document.querySelector("main .notice-template");
//             //body.innerHTML = ""; //다 지우기
//             for (var i = 0; i < json.length; i++) {
//                 var cloneTr = document.importNode(template.content, true);  
//                 var categoryEl = cloneTr.querySelector(".categoryName");
//                 var writerEl = cloneTr.querySelector(".writerId");
//                 var regdateEl = cloneTr.querySelector(".regDate");
//                 var titleEl = cloneTr.querySelector(".title");
//                 var contentEl = cloneTr.querySelector(".content");
//                 categoryEl.innerText = json[i].categoryName;
//                 writerEl.innerText = json[i].writerId;
//                 regdateEl.innerText = json[i].regDate;
//                 titleEl.innerText = json[i].title;
//                 contentEl.innerText = json[i].content;         
//                 console.log(json[i].id);
//                 notice.append(cloneTr);
//        }
  





        //visible height + pixel scrolled = total height 
       // if(
            //window.offsetHeight + window.scrollTop == window.scrollHeight
            
      //      this.document.height == this.window.)
      //  {
      //      alert("End");
      //  }
    




   // alert("온스크롤");
    // var section = document.querySelector("#reg-notice");
    // var notice = section.querySelector("#notice-lists");
    // var maxHeight = document.height();
    // var currentScroll = window.scrollTop() + window.height();
    
    // if(maxHeight <= currentScroll + 100){
    //    notice.append("notice");
    // }
    
//    if(window.scrollTop() == document.height() - window.height()){
//        pageLoaded = pageLoaded +1;
//        alert(pageLoaded);
//        notice.append(pageLoaded);