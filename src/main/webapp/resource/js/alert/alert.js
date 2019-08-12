window.addEventListener("load",function(){
    var div = this.document.querySelector("#div");
    var ul = div.querySelector("#tab");
    var coupleBtns = ul.querySelectorAll("li");
    var coupleList = div.querySelector("#couple-list")
    var eventList = div.querySelector("#event-list")
    coupleBtns[0].onclick = function(){
        if(eventList.className == "d-none current"){
            eventList.classList.remove("current");
        }
        coupleList.classList.add("current");
    }

    coupleBtns[1].onclick = function(){
       coupleList.classList.remove("current");
        eventList.classList.add("current");
    }



});