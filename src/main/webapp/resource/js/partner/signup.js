window.addEventListener("load",function(){
	var section = document.querySelector("#partner-section");
    var pw = section.querySelector("input[name=pw]");
    var email = section.querySelector("input[name=email]");
    var pwCheck = section.querySelector("input[name=pw-check]");
    var emailValid = section.querySelector("#email-valid")
    var pwVaild = section.querySelector("#pw-valid");
    var pwcVaild = section.querySelector("#pwc-valid");
    
    //정규식 유효성검사
    var regwhiteSpace = /\s/g;//공백체크 !공백없음
    var regName=/^[A-z|가-힣]{1,4}$/;//닉네임 정규식
    var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //아이디 정규식 : 이메일형삭
    var regPw = /^[a-zA-Z0-9]{4,12}$/;  //비밀번호 정규식 : 4~12글자 수의 영대소문자+숫자 
    
    
    //아이디
    email.onkeyup = function(){
        //아이디 공백 확인
        if(email.value.indexOf(" ") >=0){
            emailValid.innerText="공백을 제외하고 입력해주세요";
            pwVaild.style.color = "orangered";
            email.focus();
        }
        //아이디 e-mail 형식 검사
        
        if(!email.value.match(regEmail)){
            emailValid.innerText="이메일 형식으로 입력해주세요";
            emailValid.style.color = "orangered";
            email.focus();
            
        }else{
        	  emailValid.innerText="올바른 입력입니다.";
        	  emailValid.style.color = "green";
        }

    pw.onkeyup = function(){
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
           
        }
        else{
        	pwValid.innerText="공백 제거 완료"
        }
        //비밀번호 영문+숫자, 4~12자 형식 검사
        var regPW = /^[a-zA-Z0-9]{4,12}$/;
        
        if(!regPW.test(pw)){
            pwVaild.innerText="4~12자의 영문 대소문자와 숫자로 입력해주세요"
            pw.focus();
        
        }

   }

    //비밀번호 일치여부
    pwCheck.oninput =function(){
        if(pw.value != pwCheck.value){
        	pwcVaild.innerText="비밀번호가 일치하지 않습니다.";
            pwCheck.focus();

        }
        else
            pwcVaild.innerText="일치합니다.";
   };
  
    };
    });
