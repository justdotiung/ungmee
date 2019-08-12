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
    var nickName = section.querySelector(".nick-name").value;
    //var email = section.querySelector(".eamil").value;
    var pw = section.querySelector(".pw");
    var pwCheck = section.querySelector(".pw-check");
    var same = section.querySelector("#same"); //비밀번호비교결과 문구
    var pwValid = section.querySelector("#pw-valid");//비밀번호 유효성
    var birthday = section.querySelector(".birthday").value;
    var solo = section.querySelector(".solo").value;
    var signUpBtn = section.querySelector(".button");
    
    var isValid =false;
//================== 회원공통 ===========================//  
// 유효성 체크    
    function pwLength(){
        var pValue = pw.value;
        if(pValue.length < 5){
            isValid=false;
            alert(pwValid.className);
            pwValid.className.add("error");
            pwValid.innerText="비밀번호는 최소5자 이상입니다.";
        }
        else{
            pwValid.classList.remove("error");
            isvalid=true;

        }
    }
 //비밀번호 확인시 결과
    

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
//비밀번호 입력시 다르면 결과
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

    user.onclick = function(){
        tag1.classList.remove("d-none");
        if(tag2 != null)
            tag2.classList.remove("current");
    };
    partner.onclick = function(){
        tag1.classList.add("d-none");
        tag2.classList.add("current");
    };
});

