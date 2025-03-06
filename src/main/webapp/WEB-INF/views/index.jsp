<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 4.
  Time: 오전 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>TalkHub</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1 >TalkHub</h1>
<p class="color-primary underline">
  토크허브를 통해 사람들과 의견을 나누세요.
</p>
<c:choose>
  <c:when test="${authentication}">
    <div>
      <a href="">마이페이지</a>
      <a href="${pageContext.request.contextPath}/user/logout-proceed">로그아웃</a>
    </div>
  </c:when>
  <c:otherwise>
    <div>
      <a href="${pageContext.request.contextPath}/user/login">로그인</a>
      <a href="${pageContext.request.contextPath}/user/join">회원가입</a>
    </div>
  </c:otherwise>
</c:choose>
<p>
  <b class="color-primary">TalkHub</b> 에 오신 것을 <span>환영</span>합니다!
</p>
</body>
</html>
