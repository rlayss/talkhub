<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 6.
  Time: 오후 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>프로필 - TalkHub</title>
</head>
<body>
<h1>프로필 확인</h1>
<hr/>
<ul>
    <li>아이디 : ${user.id}</li>
    <li>활동명 : ${user.nickname}</li>
    <li>성별 : ${user.gender}</li>
    <li>생년 : ${user.birth}</li>
    <li>가입시기 : ${user.createdAt}</li>
</ul>
</body>
</html>
