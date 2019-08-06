window.addEventListener("load",function(){
    var name = this.document.querySelector("input[type=text]").value;
    this.alert(name);
    
    var evtSource = new EventSource(name+"/sse-event/pratice");


    evtSource.addEventListener("ping", function(e) {
        var newElement = document.createElement("li");
       
        var obj = JSON.parse(e.data);
        newElement.innerHTML = "ping at " + obj.time;
        eventList.appendChild(newElement);
      }, false);

});