<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 4.
  Time: 오후 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>
<h1>TalkHub</h1>
<h3>TalkHub에 로그인하기</h3>
<p>
    "TalkHub에 오신 것을 환영합니다!".
    지금 로그인하고, 다양한 주제에 대해 자유롭게 이야기하세요.
</p>
<form action="${pageContext.request.contextPath}/user/login-proceed">
    <div>
        <label>아이디</label>
        <div>
            <input type="text" name="id"/>
        </div>
    </div>
    <div>
        <label>비밀번호</label>
        <div>
            <input type="password" name="password"/>
        </div>
    </div>
    <div>
        <button type="submit">사용자인증</button>
    </div>
</form>
</body>
</html>
