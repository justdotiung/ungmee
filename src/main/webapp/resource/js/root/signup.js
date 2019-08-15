window.addEventListener("load",function(){
    //프로토콜 토큰
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;
    var ctxNext = this.document.querySelector(".ctx-name").value;
    //영역
    var section = document.querySelector("#section");
    //회원가입 선택
    var user = section.querySelector(".user");
    var partner = section.querySelector(".partner");
    var tag1 = section.querySelector("#tag1");
    var tag2 = section.querySelector("#tag2");
    // 회원정보 데이터
    var nickName = section.querySelector(".nick-name");
    var email = section.querySelector(".email");
    var pw = section.querySelector(".pw");
    var pwCheck = section.querySelector(".pw-check");
    var birthday = section.querySelector(".birthday");
    var gender = section.querySelectorAll(".gender");//라디오버튼 배열로받음.
    var event = section.querySelector(".event");
    var solo = section.querySelector(".type");
    //유효성체크 변수
    var isValid =false;//유효성 변수
    var sameValid = section.querySelector("#same-valid"); //비밀번호비교결과 문구
    var pwValid = section.querySelector("#pw-valid");//비밀번호 유효성
    var nameValid = section.querySelector("#name-valid");//이름 유효성
    var emailValid = section.querySelector("#email-valid");//이메일 유효성
    var birthdayValid = section.querySelector("#birthday-valied");//생일 유효성

    var signUpBtn = section.querySelector(".button");
    //정규식 체크
    var regwhiteSpace = /\s/g;//공백체크 !공백없음
    var regName=/^[A-z|가-힣]{1,4}$/;//닉네임 정규식
    var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    var regPw = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

   //"^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$";
    var regBirthday = /^(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
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
    // 공백체크
    //닉네임 체크
    function nicNameValid(){
        if(nickName.value != "" && !nickName.value.match(regwhiteSpace) && nickName.value.match(regName)){
            nameValid.classList.remove("error");
            nameValid.innerText="";
            isValid=true;
            return;
        }else{
            nameValid.classList.add("error");
            nameValid.innerText="공백없이 영문과 한글포함 최대 4자까지만가능합니다.";
            isvalid=false;
            return;
        }
    }
    nickName.onblur = function(){
        nicNameValid();
    }
    //이메일 체크
    function isEmailValid(){
        if(email.value ==null || !email.value.match(regEmail)|| email.value.match(regwhiteSpace)){
            emailValid.classList.add("error")
            emailValid.innerText="공백없이 이메일을 정확하게 입력하세요.";
            isValid = false;
            return ;
        }
        else{
            emailValid.classList.remove("error");
            emailValid.innerText="";
            isValid = true;
            return ;
        }
    }
    email.onblur = function(){
        isEmailValid();
    }
    //비밀번호 유효성 체크    
    function pwLength(){
        var pValue = pw.value;
        if(!pValue.match(regPw) || pValue.match(regwhiteSpace)){
            isValid=false;
            pwValid.classList.add("error");
            pwValid.innerText="공백없이 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함해야 합니다.";
            pw.focus();
            return ;
        }
        else{
            pwValid.classList.remove("error");
            pwValid.innerText="";
            isvalid=true;
            return ;
        }
    }
    //비밀번호 비교체크
    pwCheck.oninput =function(){
        if(pw.value != pwCheck.value){
            sameValid.classList.add("error");
            sameValid.innerText="공백있거나 비밀번호가 일치하지 않습니다.";
            isValid=false;
            return ;
        }else{
            sameValid.classList.remove("error");
            sameValid.innerText="일치합니다.";
            isvalid=true;
            return ;
        }
   }
    //비밀번호확인 비교체크
    pw.onchange = function(){
        pwLength();
        if(pwCheck.value != null && pwCheck.value != ''){
            if(pw.value != pwCheck.value){
                sameValid.classList.add("error");
                sameValid.innerText="공백있거나 비밀번호가 일치하지 않습니다.";
                isValid=false;
                return ;
            }else{
                sameValid.classList.remove("error");
                sameValid.innerText="일치합니다.";
                isvalid=true;
                return ;
            }    
        }
    }
    //생일날짜 체크
    function isBirthdayValied(){
        if(!birthday.value.match(regBirthday)){
            isValid = false;
            birthdayValid.classList.add("error");
            birthdayValid.innerText="잘못된 입력입니다.";
            return ;
        }
        else{
            isValid=true;
            birthdayValid.classList.remove("error");
            birthdayValid.innerText="";
            return;
        }
    }
    birthday.onblur = function(){
        isBirthdayValied();
    }
    //성별 체크
    function genderCheck(){     
        for ( var i = 0 ; i < gender.length ; i ++ ) {
            if ( gender[i].checked == true ) {
               // console.log(gender[i].value)
                isvalid =true;
                return gender[i].value;
            }else{
                isvalid=false;
                return;
            }
        }
    }
    //이벤트체크
    function eventCheck(){
        if(event.checked == true){
            return event.value;
        }else{
            event.value= "2"; 
            return event.value;
        }  
    }
    //전송버튼
    signUpBtn.onclick = function(){
        eventCheck();
        genderCheck();
        if(!isValid){
            alert("잘못입력하셨습니다.");
            return ;
        }
       
        var queryString ="email="+email.value+
                        "&pw="+pw.value+
                        "&roleId="+solo.value+
                        "&nickName="+nickName.value+
                        "&gender="+genderCheck()+
                        "&echeck="+eventCheck()+
                        "&birthday="+birthday.value;
       
        alert(queryString);
        var request = new XMLHttpRequest();
            request.addEventListener("load",function(){
                alert("회원가입 완료")
               // alert(request.responseText);
                window.location.href = 'index';
                
            })
        request.open("POST","solo-signup");
        request.setRequestHeader(header,token);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(queryString);
    }

});

