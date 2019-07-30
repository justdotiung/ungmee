window.addEventListener("load",function(){
    var profile = this.document.querySelector("#profile");
    var triggerBtn = profile.querySelector("input[type=button]");
    var fileBtn= profile.querySelector("input[type=file]")
    triggerBtn.onclick = function(){
        console.log("gg");
        var event = new MouseEvent("click",
            {
                view:window,
                bubbles:true,
                cancelable:true
            }
        );
        fileBtn.dispatchEvent(event);
    };
});