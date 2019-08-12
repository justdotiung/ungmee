window.addEventListener("load",function(){
    //프로토콜 토큰
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;
    //영역
    var section = document.querySelector("#section");
    //회원가입 선택
    var user = section.querySelector(".user");
    var partner = section.querySelector(".partner");
    var tag1 = section.querySelector("#tag1");
    var tag2 = section.querySelector("#tag2");
    // 회원정보 데이터
    var nickName = section.querySelector(".nick-name");
    var email = section.querySelector(".eamil");
    var pw = section.querySelector(".pw");
    var pwCheck = section.querySelector(".pw-check");
    var same = section.querySelector("#same"); //비밀번호비교결과 문구
    var pwValid = section.querySelector("#pw-valid");//비밀번호 유효성
    var nameValid = section.querySelector("#name-valid");//이름 유효성
    
    var birthday = section.querySelector(".birthday");
    var solo = section.querySelector(".solo");
    var signUpBtn = section.querySelector(".button");
    var isValid =false;//유효성 변수

    var regName=/^[A-z|가-힣]{1,4}$/;//닉네임 정규식
    var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    //일반회원 선택
    user.onclick = function(){
        tag1.classList.remove("d-none");
        if(tag2 != null)
            tag2.classList.remove("current");
    };
    //제휴사회원 선택
    partner.onclick = function(){
        tag1.classList.add("d-none");
        tag2.classList.add("current");
    };
    //================== 회원공통 ===========================//  
    //닉네임 체크
    function nicNameValid(){
        if(nickName.value != "" && nickName.value.match(regName)){
            nameValid.classList.remove("error");
            nameValid.innerText="";
            isValid=true;
            return;
        }else{
            nameValid.classList.add("error");
            nameValid.innerText="영문과 한글포함 최대 4자까지만가능합니다.";
            isvalid=false;
            return;
        }
    }
    nickName.onblur = function(){
        nicNameValid();
    }
    //비밀번호 유효성 체크    
    function pwLength(){
        var pValue = pw.value;
        if(pValue.length < 5){
            isValid=false;
            pwValid.classList.add("error");
            pwValid.innerText="비밀번호는 최소5자 이상입니다.";
        }
        else{
            pwValid.classList.remove("error");
            isvalid=true;

        }
    }
    //비밀번호 비교체크
    pwCheck.oninput =function(){
        if(pw.value != pwCheck.value){
            same.classList.add("error");
            same.innerText="비밀번호가 일치하지 않습니다.";
            isValid=false;
        }else{
            same.classList.remove("error");
            same.innerText="일치합니다.";
            isvalid=true;
        }
   }
    //비밀번호확인 비교체크
    pw.onchange = function(){
        pwLength();
        if(pwCheck.value != null && pwCheck.value != ''){
            if(pw.value != pwCheck.value){
                same.classList.add("error");
                same.innerText="비밀번호가 일치하지 않습니다.";
                isValid=false;
            }else{
                same.classList.remove("error");
                same.innerText="일치합니다.";
                isvalid=true;
            }    
        }
    }
    signUpBtn.onclick = function(){
        // var queryString ="email"++
        //                 "pw"++
        //                 "roleId"++
        //                 "nickName"++
        //                 "profile"+;
       
        if(!isValid){
            return ;
        }

        var request = new XMLHttpRequest();
        request.open("POST","solo/signup");
        request.setRequestHeader(header,token);
        request.send(queryString);
    }

});

