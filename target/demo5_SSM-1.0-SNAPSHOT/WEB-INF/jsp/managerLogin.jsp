<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/25
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title></title>
    <style>
        body {
            background-image: linear-gradient(45deg, #aaa, #333);
        }

        #title {
            position: absolute;
            top: 20%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: #fff;
            transition: 1s ease;
        }

        h3 {
            margin: 0;
            text-align: center;
        }

        .box {
            width: 250px;
            margin: auto;
            background-image: radial-gradient(#000 25%, green 215%);
            padding: 50px;
            color: #fff;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border-radius: 40px;
        }

        .item {
            border-style: solid;
            border-color: #d4d4d9;
            -o-border-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFAQMAAAC3obSmAAAABlBMV…k1vE5IAAAAAXRSTlMAQObYZgAAAA5JREFUCNdj+MHQAYY/ABGyA4nEIg1TAAAAAElFTkSuQmCC) 2 stretch;
            border-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFAQMAAAC3obSmAAAABlBMV…k1vE5IAAAAAXRSTlMAQObYZgAAAA5JREFUCNdj+MHQAYY/ABGyA4nEIg1TAAAAAElFTkSuQmCC) 2 stretch;
            border-width: 0 0 1px;
            display: flex;
            align-items: center;
            position: relative;
        }

        .item input {
            width: 100%;
            height: 55px;
            padding: 18px 0 0;
            font-size: 15px;
            box-sizing: border-box;
            display: block;
            position: relative;
            z-index: 2;
            background-color: transparent;
            border: 0;
            outline: 0;
            color: #fff;
        }

        .item .placeholder {
            width: 100%;
            color: #ccc;
            font-size: 15px;
            position: absolute;
            left: 0;
            top: 50%;
            transform: translateY(-50%) scale(1);
            transition: transform .2s linear;
            transform-origin: left;
        }

        .button {
            width: 200px;
            height: 40px;
            background-color: #00aa00;
            margin-top: 40px;
            border-radius: 20px;
            margin-left: 25px;
            color: #fff;
            font-size: large;
            font-weight: bold;
            transition: 0.5s;
            border: 0;
        }

        .button:hover {
            background-color: #ffaa00;
            color: #000;
            font-size: x-large;
        }
    </style>
    <script>
        function small(e) {
            if (!e.value) {
                e.nextElementSibling.style.cssText = 'transform:translateY(-110%) scale(.75);';
            }
        }

        function back(e) {
            if (!e.value) {
                e.nextElementSibling.style.cssText = '';
            }
        }

        function hiddens(e) {
            if (e.value) {
                e.nextElementSibling.style.visibility = "hidden";
            } else {
                e.nextElementSibling.style.visibility = "visible";
            }
        }

        window.onload = () => {
            var submitBtn = document.getElementById("submit");
            var usernameInput = document.getElementById("usernameInput");
            var passwordInput = document.getElementById("passwordInput");
            var placeholder1 = document.getElementById("placeholder1");
            var placeholder2 = document.getElementById("placeholder2");
            //检查输入框是否不为空
            if (usernameInput.value) {
                placeholder1.style.visibility = "hidden";
            }
            if (passwordInput.value) {
                placeholder2.style.visibility = "hidden";
            }
            submitBtn.onclick = () => {
                //检查内容是否为空
                if (usernameInput.value == "" || passwordInput.value == "") {
                    alert("请填写完整")
                    return false;
                }
            }
        }
    </script>
</head>

<body>
<h1 id="title">管理员登录</h1>
<div class="box">
    <h3>登录</h3>
    <form action="loginCheck">
        <div class="item">
            <input id="usernameInput" name="username" type="text" onfocus="small(this)" onblur="back(this)" oninput="hiddens(this)" />
            <span id="placeholder1" class="placeholder">请输入用户名</span>
        </div>
        <div class="item">
            <input id="passwordInput" name="password" type="password" onfocus="small(this)" onblur="back(this)" oninput="hiddens(this)" />
            <span id="placeholder2" class="placeholder">请输入密码</span>
        </div>
        <input type="submit" value="登录" class="button" id="submit">
    </form>
</div>

</body>

</html>
