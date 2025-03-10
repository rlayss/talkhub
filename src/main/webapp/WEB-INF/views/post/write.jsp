<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 4.
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1>TalkHub</h1>
<div>
    <h2>토크허브에 글남기기</h2>
    <p>
        <b>TalkHub에 당신의 목소리를 남겨보세요!</b><br/>
        궁금한 점, 나누고 싶은 정보, 하고 싶은 이야기 모두 환영합니다!
    </p>
    <form action="${pageContext.request.contextPath}/post/write-proceed" method="post">
        <div>
            <label>말머리(*)</label>
            <div>
                <select name="category">
                    <option value="자유">자유</option>
                    <option value="질문">질문</option>
                    <option value="정보">정보</option>
                    <option value="뉴스">뉴스</option>
                </select>
            </div>
        </div>
        <div>
            <label>제목(*)</label>
            <div>
                <input type="text" name="title"/>
            </div>
        </div>
        <div>
            <label>내용(*)</label>
            <div>
                <textarea name="content"></textarea>
            </div>
        </div>

        <div>
            <button type="submit">지금 게시하기</button>
        </div>
    </form>
</div>
</body>
</html>
