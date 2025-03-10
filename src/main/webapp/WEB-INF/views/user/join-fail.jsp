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
<div >
    <h2>토크허브에 회원가입하기</h2>
    <p>
        <b>TalkHub</b>에 가입하고 자유롭게 이야기하세요! 다양한 주제에 대해 토론하고, 새로운 사람들과 소통할 수 있습니다.
    </p>
    <form action="${pageContext.request.contextPath}/user/join-proceed" method="post">
        <div >
            <label>아이디(*)</label>
            <div>
                <input type="text" name="id" value="${param.id}"/>
            </div>
            <c:if test="${idError != null}">
                <div style="color:red; font-size: small">${idError}</div>
            </c:if>
            <c:if test="${idDuplicatedError != null}">
                <div style="color:red; font-size: small">${idDuplicatedError}</div>
            </c:if>
        </div>
        <div >
            <label>비밀번호(*)</label>
            <div>
                <input type="password" name="password" value="${param.password}"/>
            </div>
            <c:if test="${passwordError != null}">
                <div style="color:red; font-size: small">${passwordError}</div>
            </c:if>
        </div>
        <div >
            <label>활동명(*)</label>
            <div>
                <input type="text"  name="nickname"  value="${param.nickname}"/>
            </div>
            <c:if test="${nicknameError != null}">
                <div style="color:red; font-size: small">${nicknameError}</div>
            </c:if>
        </div>
        <div >
            <label>성별(*)</label>
            <div>
                <select name="gender">
                    <option value="남">남</option>
                    <option value="여">여</option>
                    <option value="비공개">비공개</option>
                </select>
            </div>
        </div>
        <div >
            <label>출생년도(*)</label>
            <div>
                <select name="birth">
                    <c:forEach var="i" begin="1970" end="2025">
                        <option value="${i}">${i}년</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <c:if test="${dbError != null}">
            <div style="color:red; font-size: small">${dbError}</div>
        </c:if>
        <div >
            <button type="submit" >가입하기</button>
        </div>
    </form>
</div>
</body>
</html>