<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 7.
  Time: 오전 10:46
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
<hr/>
<h3>[${post.category}] ${post.title}</h3>
<div>
    <div>작성자 ${post.writerId} <span style="color:#dddddd">|</span> 작성일 ${post.writedAt}</div>
    <div>조회 ${post.views} <span style="color:#dddddd">|</span> 추천 ${post.likes} </div>
</div>
<hr/>
<p style="white-space: pre-wrap">${post.content }</p>
<hr/>

<c:choose>
    <c:when test="${alreadyLiked}">
        <button type="button" disabled>이미 추천을 하였습니다.</button>
    </c:when>
    <c:otherwise>
        <a href="${pageContext.request.contextPath}/post/like-proceed?id=${post.id}">
            <button type="button">추천하기</button>
        </a>
    </c:otherwise>
</c:choose>


</body>
</html>



