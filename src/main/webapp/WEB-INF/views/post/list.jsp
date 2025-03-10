<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 7.
  Time: 오전 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TalkHub</title>
</head>
<body>

<h1>TalkHub</h1>
<hr/>
<h2>TalkHub 게시판</h2>
<ul>
    <c:forEach var="one" items="${posts}">
        <li style="display: flex; justify-content: space-between">
            <div>
                <a href="${pageContext.request.contextPath}/post/view?id=${one.id}">📝[${one.category}] ${one.title}</a>
            </div>
            <div >
                ✍️ ${one.writerId}  | 🕒 ${one.writedAt} | 👀 ${one.views } | ❤️ ${one.likes}
            </div>
        </li>

    </c:forEach>

</ul>

</body>
</html>
