window.addEventListener("load",function(){
    //영역
    var section = this.document.querySelector("#section");
    //탭 형식 선택
    var ul = section.querySelector("#ul").children;
    var coupleTab = ul[0];
    var followTab = ul[1];
    var eventTab = ul[2];
    //탭 형식 테이블
    var coupleTable = section.querySelector("#couple");
    var followTable = section.querySelector("#follow");
    var eventTable = section.querySelector("#event");

    coupleTab.onclick = function(e){
        e.preventDefault()
        if(e.target.tagName != 'A')
            return;
        coupleTable.classList.remove("d-none"); 
        followTable.classList.add("d-none");
        eventTable.classList.add("d-none");
    }
    followTab.onclick = function(e){
        e.preventDefault()
        if(e.target.tagName != 'A')
            return;      
            
        coupleTable.classList.add("d-none");
        followTable.classList.remove("d-none");
        eventTable.classList.add("d-none");
    }
    eventTab.onclick = function(e){
        e.preventDefault()
        if(e.target.tagName != 'A')
            return;
        coupleTable.classList.add("d-none");
        followTable.classList.add("d-none");
        eventTable.classList.remove("d-none");
    }
});