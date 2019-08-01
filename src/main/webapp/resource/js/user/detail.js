window.addEventListener("load",function(){
    var profile = this.document.querySelector("#profile");
    var triggerBtn = profile.querySelector("input[type=button]");
    var fileBtn= profile.querySelector("input[type=file]")
    
    triggerBtn.onclick = function(){
       
        var event = new MouseEvent("click",
            {
                view:window,
                bubbles:true,
                cancelable:true
            }
        );
        fileBtn.dispatchEvent(event);
        
        
    };

    fileBtn.onchange =function(e){
        var files = fileBtn.files;
        var formData = new FormData();
        formData.append("file",files[0]);


        var request = new XMLHttpRequest();
        request.open("POST","supload");
        request.send(formData);
    };
        
   
});
