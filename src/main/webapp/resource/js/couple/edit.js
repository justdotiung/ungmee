window.addEventListener("load",function(){
    var section = this.document.querySelector("#myinfo");
    var file = section.querySelector("input[type=file]");
    var triggerButton = section.querySelector(".triggerButton");
    
    triggerButton.onclick = function(e){
        alert("test");

        var event = new MouseEvent("click",{
            view: window,
            bubbles:true,
            cancelable:true
        });
        file.dispatchEvent(event);
    };
 
});

