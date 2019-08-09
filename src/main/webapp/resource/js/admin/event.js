
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

//notice 내용 자세히보기
/*
window.addEventListener("load", function() {

	var section = this.document.querySelector("#event");
	//버튼이 여러개 -> 부모에게 걸어준다
	//var eventList = section.querySelector(".event-lists")

//	eventList.onclick = function(e) {
//		var detailButton = e.target;
//		if (!detailButton.classList.contains("btn-detail"))
//			return;

		var contentDiv = detailButton.parentElement.nextElementSibling;
		//console.log(typeof content);
		contentDiv.classList.add("current");

		//alert("내용을 불러옴");
		console.log(f);
//	}

});
*/

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