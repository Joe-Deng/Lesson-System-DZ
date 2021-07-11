<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/1/2021
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
    <style>
        .content{
            width: 100%;
            height: 400px;
            position: absolute;
          left: 50%;
            top:50%;
            transform: translate(-50%,-50%);
            text-align: center;
        }

        .content a{
            width: 200px;
            height: 60px;
            background: #0088FF;
            color: #ffffff;
            display: inline-block;
            text-decoration: none;
            border-radius: 20px;
            line-height: 60px;
            font-size: 24px;
        }
    </style>
</head>
<body>
    <div class="content">
        <img src="./icon/fail.png" class="icon">
        <h1>你输入的用户名或密码错误，登录失败</h1>
        <a href="login">重新登录</a>
    </div>
</body>
</html>
