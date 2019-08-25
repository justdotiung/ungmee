window.addEventListener("load",function(){
    //프로토콜 토큰
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;
    //var ctxNext = this.document.querySelector(".ctx-name").value;
    //영역
    var section = document.querySelector("#signup");
    //회원가입 선택
    var user = section.querySelector(".user");
    var partner = section.querySelector(".partner");
    var tag1 = section.querySelector("#tag1");
    var tag2 = document.querySelector("#tag2");
    // 회원정보 데이터
    var nickName = section.querySelector(".nick-name");
    var email = section.querySelector(".email");
    var pw = section.querySelector(".pw");
    var pwCheck = section.querySelector(".pw-check");
    var birthday = section.querySelector(".birthday");
    var gender = section.querySelectorAll(".gender");//라디오버튼 배열로받음.
    var event = section.querySelector(".event");
    var roleId = section.querySelector(".roleId");

    //유효성체크 변수
    var isValid =false;//유효성 변수
    var isunDuplicate = false;//이메일 유효성
    var sameValid = section.querySelector("#same-valid"); //비밀번호비교결과 문구
    var pwValid = section.querySelector("#pw-valid");//비밀번호 유효성
    var nameValid = section.querySelector("#name-valid");//이름 유효성
    var emailValid = section.querySelector("#email-valid");//이메일 유효성
    var birthdayValid = section.querySelector("#birthday-valied");//생일 유효성
    var emailDuplicate = section.querySelector(".email-dup");//이메일 중복 체크
    var signUpBtn = section.querySelector(".button");
    //정규식 체크
    var regwhiteSpace = /\s/g;//공백체크 !공백없음
    var regName=/^[A-z|가-힣]{1,4}$/;//닉네임 정규식
    var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    var regPw = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/; //"^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$";
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
            return true;
        }else{
            nameValid.classList.add("error");
            nameValid.innerText="공백없이 영문과 한글포함 최대 4자까지만가능합니다.";
            return false;
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
            return false;
        }
        else{
            emailValid.classList.remove("error");
            emailValid.innerText="";
            return true;
        }
    }
    email.onblur = function(){
        isEmailValid();
    }
    //이메일 중복체크
    emailDuplicate.onclick=function(){
        var request = new XMLHttpRequest();
        request.addEventListener("load",function(){
            //console.log(request.responseText);
            if(request.responseText == 'true'){
                alert("이미사용중인 이메일 입니다.")
                isunDuplicate = false;
            }
            else{
                alert("가능한 이메일 입니다.")
                isunDuplicate = true;
            }
        });
        request.open("GET","duplicate?email="+email.value);
        request.send();
    }
    //비밀번호 유효성 체크    
    function pwLength(){
        var pValue = pw.value;
        if(!pValue.match(regPw) || pValue.match(regwhiteSpace)){
            pwValid.classList.add("error");
            pwValid.innerText="공백없이 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함해야 합니다.";
            pw.focus();
            return false;
        }
        else{
            pwValid.classList.remove("error");
            pwValid.innerText="";
            return true;
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
            isValid=true;
            return ;
        }
   }

    //비밀번호확인 비교체크
    pw.onchange = function(){
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
    //=====================solo 회원 정보 ===========================================
    //생일날짜 체크
    function isBirthdayValied(){
        if(!birthday.value.match(regBirthday)){
            birthdayValid.classList.add("error");
            birthdayValid.innerText="생일을 제대로 입력해주세요.";
            return false;
        }
        else{
            birthdayValid.classList.remove("error");
            birthdayValid.innerText="";
            return true;
        }
    }
    birthday.onblur = function(){
        isBirthdayValied();
    }
    //성별 체크
    function genderCheck(){  
        for ( var i = 0 ; i < gender.length ; i ++ ) {
            if(gender[i].checked == true){
                return gender[i].value; 
            }
        }
        return ;
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
      
        if(!nicNameValid()){
        //    alert("닉네임을 잘못입력하셨습니다.");
            return ;
        }
        
        if(!isEmailValid()){
        //    alert("이메일을 잘못입력하셨습니다.");
            return ;
        }
        if(!isunDuplicate){
            alert("이메일중복 체크하셔야 합니다.");
            return ;
        }
        
        if(!pwLength()){
        //   alert("비밀번호를 잘못입력하셨습니다.");
            return ;
        }
        if(!isValid){
            return ;
        }
        if(!isBirthdayValied()){
            return ;
        }

        var queryString ="email="+email.value+
                        "&pw="+pw.value+
                        "&roleId="+roleId.value+
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



//파트너 =====

window.addEventListener("load",function(){
	  //프로토콜 토큰
    var header = this.document.querySelector(".header").value;
    var token = this.document.querySelector(".token").value;
	//사용자 입력칸에 대한 변수
	var section = document.querySelector("#partner-section");
    var password = section.querySelector("input[name=password]");
    var email = section.querySelector("input[name=email]");
    var pwCheck = section.querySelector("input[name=pw-check]");
    var nickname = section.querySelector("input[name=nickname]");
    var bossName = section.querySelector("input[name=boss-name]");
    var phone = section.querySelector("input[name=phone]");
    //유효성검사 span태그 변수
    var emailValid = section.querySelector("#email-valid");
    var pwVaild = section.querySelector("#pw-valid");
    var pwcVaild = section.querySelector("#pwc-valid");
    var nicknameValid = section.querySelector("#nickname-valid");
    var bossNameValid = section.querySelector("#bossname-valid");
    var phoneValid = section.querySelector("#phone-valid");
    //사용자 입력 여부 확인에 대한 변수
    var nickname = section.querySelector("input[name=nickname]");
    var bossName = section.querySelector("input[name=boss-name]");
    var phone = section.querySelector("input[name=phone]");
    var partnerName = section.querySelector("input[name=partner-name]");
    var partnerType = section.querySelector("input[name=partner-type]");
    var checkSelect = section.querySelector(".check-select");
    var checkSns = section.querySelector(".check-sns");
    var joinButton = section.querySelector(".a");
    var roleId = section.querySelector(".roleId");
    var address = section.querySelector("#sample6_address");
    //daum 주소 api
    var postButton = section.querySelector(".btn-primarybox");
    
    
    //정규식 유효성검사
    var regWhitespace = /\s/g;//공백체크 !공백없음
    var regBossName = /^[A-z|가-힣]{1,4}$/;//사장님 이름 정규식
    var regNickname = /^[A-z|가-힣]{1,10}$/; //닉네임 정규식
    var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //아이디 정규식 : 이메일형삭
    var regPw = /^[a-zA-Z0-9]{4,12}$/;  //비밀번호 정규식 : 4~12글자 수의 영대소문자+숫자 
    var regPhone = /^(01[016789]{1})([1-9]{1}[0-9]{2,3})([0-9]{4})$/; //핸드폰 정규식
    
    
    //아이디
    email.onkeyup = function(){
        if(!email.value.match(regWhitespace) && email.value.match(regEmail)){
          emailValid.innerText="올바른 입력입니다.";
          emailValid.style.color = "green";
        }else{
    	  emailValid.innerText="공백을 포함하지 않은 유효한 이메일 형식으로 입력부탁드립니다.";
    	  emailValid.style.color = "orangered";
    	  email.focus();
        }
    }

    //비밀번호
    password.onkeyup = function(){
    	if(pwCheck.value != ""){
    			if(password.value != pwCheck.value){
    				pwcVaild.innerText="비밀번호가 정말 일치하지 않습니다.";
    				pwcVaild.style.color = "orangered";
    				pwCheck.focus();
    			}
    			else{
    				pwcVaild.innerText="일치합니다.";
    				pwcVaild.style.color = "green";
    				pwCheck.focus();
    			}
    	}
    	if(!password.value.match(regWhitespace) && password.value.match(regPw)){
    		pwVaild.innerText="올바른 입력입니다.";
    		pwVaild.style.color = "green";
        }
    	else{
        	pwVaild.innerText="비밀번호는 공백 미포함, 4~12자의 영대소문자와 숫자로 입력부탁드립니다";
        	pwVaild.style.color = "orangered";
        	password.focus();
        }
 };
    //비밀번호 일치여부
    pwCheck.onkeyup =function(){
        if(password.value != pwCheck.value){
            pwcVaild.innerText="비밀번호가 일치하지 않습니다.";
            pwcVaild.style.color = "orangered";
            pwCheck.focus();
        }
        else{
            pwcVaild.innerText="일치합니다.";
            pwcVaild.style.color = "green";
        }
   };
  
   //닉네임 
   nickname.onkeyup = function(){
   	if(!nickname.value.match(regWhitespace) && nickname.value.match(regNickname)){
   		nicknameValid.innerText="올바른 입력입니다.";
   		nicknameValid.style.color = "green";
       }else{
    	nicknameValid.innerText="닉네임은 공백없이 영문과 한글포함 최대 10자까지만 가능합니다.";
        nicknameValid.style.color = "orangered";
        nickname.focus();
       }
  }
   
   //사장님 이름 
   bossName.onkeyup = function(){
   	if(!bossName.value.match(regWhitespace) && bossName.value.match(regBossName)){
   		bossNameValid.innerText="올바른 입력입니다.";
   		bossNameValid.style.color = "green";
       }else{
    	bossNameValid.innerText="이름은 공백없이 영문과 한글포함 최대 4자까지만 가능합니다.";
    	bossNameValid.style.color = "orangered";
    	bossName.focus();
       }
  }
   
   //핸드폰
   phone.onkeyup = function(){
	   	if(!phone.value.match(regWhitespace) && phone.value.match(regPhone)){
	   		phoneValid.innerText="올바른 입력입니다.";
	   		phoneValid.style.color = "green";
	       }else{
	    	phoneValid.innerText="휴대폰 번호를 정확하게 입력부탁드립니다";
	    	phoneValid.style.color = "orangered";
	    	phone.focus();
	       }
	  }
   
   //약관동의 체크
   function checkAll(){
       if(checkAll.checked == true){
           return checkAll.value;
       }else{
    	   checkAll.value= "2"; 
           return checkAll.value;
       }  
   }
   
   function checkSelect(){
       if(checkSelect.checked == true){
           return checkSelect.value;
       }else{
    	   checkSelect.value= "2"; 
           return checkSelect.value;
       }  
   }
   
 
 //다음 주소 API
  postButton.onclick = function(){
//	  function sample6_execDaumPostcode() {
	  daum.postcode.load(function(){
		  	new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	  
/*다음API 예제 4	  
   daum.postcode.load(function(){
       new daum.Postcode({
           oncomplete: function(data) {
               // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

               // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
               var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
               var extraRoadAddr = ''; // 도로명 조합형 주소 변수

               // 법정동명이 있을 경우 추가한다. (법정리는 제외)
               // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
               if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                   extraRoadAddr += data.bname;
               }
               // 건물명이 있고, 공동주택일 경우 추가한다.
               if(data.buildingName !== '' && data.apartment === 'Y'){
                  extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
               }
               // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
               if(extraRoadAddr !== ''){
                   extraRoadAddr = ' (' + extraRoadAddr + ')';
               }
               // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
               if(fullRoadAddr !== ''){
                   fullRoadAddr += extraRoadAddr;
               }

               // 우편번호와 주소 정보를 해당 필드에 넣는다.
               document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
               document.getElementById('sample4_roadAddress').value = fullRoadAddr;
               document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

               // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
               if(data.autoRoadAddress) {
                   //예상되는 도로명 주소에 조합형 주소를 추가한다.
                   var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                   document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

               } else if(data.autoJibunAddress) {
                   var expJibunAddr = data.autoJibunAddress;
                   document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

               } else {
                   document.getElementById('guide').innerHTML = '';
               }
           }
*/
       }).open();
   });
  };

//};

  //이벤트체크
  function eventCheck(){
      if(checkSelect.checked == true){
          return checkSelect.value;
      }else{
    	  checkSelect.value= "F"; 
          return checkSelect.value;
      }  
  }
  
 //전송버튼
	joinButton.onclick = function(){
	 //입력여부
	    if(email.value==""){
	    	alert("이메일을 입력해주세요");
	    	email.focus();
		}
		if(password.value==""){
			alert("비밀번호를 입력해주세요");
			password.focus();
		}
	    if(nickname.value==""){
	    	alert("닉네임을 입력해주세요");
	    	nickname.focus();
	    }	
	    if(bossName.value==""){
	    	alert("이름을 입력해주세요");
	    	bossName.focus();
	    }
	    if(phone.value==""){
	    	alert("전화번호를 입력해주세요");
	    	phone.focus();
	    }
	    if(partnerName.value==""){
	    	alert("상호명을 입력해주세요");
	    	partnerName.focus();
	    }
	    if(partnerType.value==""){
	    	alert("업종을 입력해주세요");
	    	partnerType.focus();
	    }
	    
	    
       var queryString ="email="+email.value+
                       "&pw="+password.value+
                       "&roleId="+roleId.value+
                       "&nickName="+nickname.value+
                       "&bName="+bossName.value+
                       "&phone="+phone.value+
                       "&pName="+partnerName.value+
                       "&pType="+partnerType.value+
                       "&echeck="+eventCheck()+
                       "&address="+address.value
                       ;
      
       alert(queryString);
       var request = new XMLHttpRequest();
           request.addEventListener("load",function(){
               Console.log(request.responseText);
               
        });
       request.open("POST","partner-signup");
       request.setRequestHeader(header,token);
       request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
       request.send(queryString);
   };

});