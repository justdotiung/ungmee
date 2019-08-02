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
window.addEventListener("load",function(){
    var section = this.document.querySelector("#notice");
    //버튼이 여러개 -> 부모에게 걸어준다
    var noticeList = section.querySelector(".notice-lists")
    
    noticeList.onclick = function(e){
    	var detailButton = e.target;
    	if(!detailButton.classList.contains("btn-detail"))
            return;
    	
    	var contentDiv = detailButton.parentElement.nextElementSibling;
    	//console.log(typeof content);
    	contentDiv.classList.add("current");
    	
    	//alert("내용을 불러옴");
    }
 
});

