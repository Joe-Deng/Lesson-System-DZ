<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cancelLogin</title>
</head>
<body>
<%
    //清除session
    HttpSession session1 = request.getSession();
    session1.invalidate();
    System.out.println("session已销毁");

    //返回之前的页面
    String referer = request.getHeader("Referer");  //这个发送请求的地址（跳转前的地址）
    System.out.println("返回："+referer);
//    response.sendRedirect(referer);
    response.sendRedirect("login.jsp");
%>
</body>
</html>
