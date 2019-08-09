window.addEventListener("load",function(){
    var section = document.querySelector("#body");
    var id = section.querySelector("input[name=id]");
    var pw = section.querySelector("input[name=password]");
    var pwCheck = section.querySelector("input[name=pw-check]");
    var idValid = section.querySelector("#id-valid")
    var pwVaild = section.querySelector("#pw-valid");
    var pwcVaild = section.querySelector("#pwc-valid");
    

    //아이디
//    id.onchange = function(){
//    	alert("id");
//        //아이디 공백 확인
//        if(id.value.includes(" ")){
//            idValid.innerText="공백을 제외하고 입력해주세요";
//            id.focus();
//            e.preventDefault();
//        }
//        //아이디 e-mail 형식 검사
//        var regID = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/i;
//        if(!regID.test(id))
//            idValid.innerText="이메일 형식으로 입력해주세요";
//            id.focus();
//           
//    }

    pw.onkeyup = function(e){
    	//비밀번호 입력여부
    	if(pw.value==""){
    		alert("비밀번호를 입력해주세요")
    		pw.focus();
    	}
    	
        //비밀번호 공백포함
        //if(pw.value.includes(" ")){
        if(pw.value.indexOf(" ") >=0){
            pwVaild.innerText="공백을 제외하고 입력해주세요";
            pwVaild.style.color = "orangered";
            pw.focus();
            e.preventDefault();
        }
        else{
        	pwValid.innerText="공백 제거 완료"
        }
        //비밀번호 영문+숫자, 4~12자 형식 검사
        var regPW = /^[a-zA-Z0-9]{4,12}$/;
        
        if(!regPW.test(pw)){
            pwVaild.innerText="4~12자의 영문 대소문자와 숫자로 입력해주세요"
            pw.focus();
            e.preventDefault();
        }

   }

    //비밀번호 일치여부
    pwCheck.oninput =function(e){
        if(pw.value != pwCheck.value){
        	pwcVaild.innerText="비밀번호가 일치하지 않습니다.";
            pwCheck.focus();
            e.preventDefault();
        }
        else
            pwcVaild.innerText="일치합니다.";
   }
  

});


