<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="../../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../../../css/member/index.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <!-- header -------------------------------------------------- -->
    <section id="header">
        <h1 class="logo"><img src="../WebContent/ungmee/ummo/logo.jpg">로고</a></h1>
        <div class="member">
            <a href="/user/login">로그인</a>
            <a href="/guest/signup">회원가입</a>
        </div>
    </section>

    <!-- body ---------------------------------------------------- -->
    <main>
        <div id="weather">
            <a href="">날씨API</a><img src="ungmee/img/2x/baseline_cloud_black_18dp.png">
        </div>

        <nav>
            <ul>
                <li><a href="">CourseWho</a></li>
                <li><a href="">CourseWhat</a></li>
                <li><a href="">CourseWhere</a></li>
                <li><a href="">CourseSearch</a></li>
            </ul>
        </nav>

        <div id="Couple-Best">
            <h1>주간베스트커플</h1>
            <ul>
                <li><a href="">커플1</a></li>
                <li><a href="">커플2</a></li>
                <li><a href="">커플3</a></li>
                <li><a href="">커플4</a></li>
                <li><a href="">커플5</a></li>
            </ul>
        </div>


        <section id="Course-Best">
            <h1>주간베스트코스</h1>
            <ul>
                <li><a href="">코스1</a></li>
                <li><a href="">코스2</a></li>
                <li><a href="">코스3</a></li>
                <li><a href="">코스4</a></li>
                <li><a href="">코스5</a></li>
            </ul>
        </section>

        <section id="Course-New">
            <h1>코스최신글</h1>
            <ul>
                <li><a href="">최신글1</a></li>
                <li><a href="">최신글2</a></li>
                <li><a href="">최신글3</a></li>
                <li><a href="">최신글4</a></li>
                <li><a href="">최신글5</a></li>
            </ul>
        </section>

        <section id="Event">
            <h1>이벤트</h1>
            <ul>
                <li><a href="">사내이벤트1</a></li>
                <li><a href="">사내이벤트2</a></li>
                <li><a href="">외부이벤트1</a></li>
                <li><a href="">외부이벤트2</a></li>
            </ul>
            <div><a href="">더보기</a></div>
        </section>

        <section id="Notice">
            <h1>공지사항</h1>
            <div>공지글1</div>
            <div><a href="">더보기</a></div>
        </section>
    </main>
    <!-- footer -------------------------------------------------- -->   
    <section id="footer">
        <div id="footer-logo">
           <img src="../WebContent/ungmee/ummo/logo.jpg">
        </div>

        <div id="copyright">
            "(주)UNG | 대표이사 : 장웅희 | 메일 : UNG1@UNG.COM" <br>
        </div>
    </section>
</body>
</html>