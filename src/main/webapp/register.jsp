<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="./style.css">
</head>

<body style="background: url('background2.jpg')">
<div class="content">
    <h1>注册</h1>
    <form action="register">
        <div>
            <p>用户名</p>
            <input type="text" id="username" name="username">
            <p class="warnning" id="warnning1">* 用户名为13位学号</p>
        </div>
        <div>
            <p>密码</p>
            <input type="password" id="password" name="password">
            <p class="warnning" id="warnning2">* 密码最少6位，包括至少1个大写字母，1个小写字母，1个数字,1个符号</p>
        </div>
        <input type="submit" value="提交注册" disabled>
    </form>
    <input type="button" value="返回登录" class="registerBtn" id="backBtn">
</div>

<script>

    window.onload = () => {
        //注册跳转
        let backBtn = document.getElementById("backBtn");
        backBtn.onclick = ()=>{
            location.href = "login.jsp";
        }

        //以下全是做输入检测
        //用户名正则，4到16位（字母，数字，下划线，减号）
        var uPattern = /^[0-9]{13}$/;
        //密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字,1个符号
        var pPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
        var warnning1 = document.getElementById("warnning1");
        var warnning2 = document.getElementById("warnning2");
        var input1 = document.getElementsByTagName('input')[0];
        var input2 = document.getElementsByTagName('input')[1];
        var input3 = document.getElementsByTagName('input')[2];
        input1.addEventListener("input", warn1);
        input2.addEventListener("input", warn2);
        var OK1 = false;
        var OK2 = false;

        function warn1() {
            if (input1.value.match(uPattern)) {
                warnning1.style.display = "none";
                OK1 = true;
            } else if (input1.value == "") {
                warnning1.style.display = "none";
                OK1 = false;
            } else {
                warnning1.style.display = "inline";
                OK1 = false;
            }
            //检测是否满足提交条件
            if (OK1 && OK2) {
                input3.disabled = false;
                input3.style.backgroundColor = "#00CC00"
            } else {
                input3.disabled = true;
                input3.style.backgroundColor = "#C5C5C5"
                input3.style.color = "#000";
            }
        }

        function warn2() {
            if (input2.value.match(pPattern)) {
                warnning2.style.display = "none";
                OK2 = true;
            } else if (input2.value == "") {
                warnning2.style.display = "none";
                OK2 = false;
            } else {
                warnning2.style.display = "inline";
                OK2 = false;
            }
            //检测是否满足提交条件
            if (OK1 && OK2) {
                input3.disabled = false;
                input3.style.backgroundColor = "#00CC00"
                input3.style.color = "#fff";
            } else {
                input3.disabled = true;
                input3.style.backgroundColor = "#C5C5C5"
                input3.style.color = "#000";
            }
        }
    }

    function beforeSubmit() {
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        password = password.slice(0, 2) + "******" + password.slice(-2, -1) + password[password.length - 1];
        alert("用户名：" + username + "\n密码：" + password)
    }
</script>
</body>
</html>