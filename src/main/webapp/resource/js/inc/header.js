window.addEventListener("load",function(){
    var ar = this.document.querySelector(".toggle");
    var alertList = this.document.querySelector("#alert-list");
    ar.onclick = function(e){
        e.preventDefault();
    }
    ar.onclick = function(e){
        e.preventDefault();
        alertList.classList.toggle("inline");
    }
 
});