<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="dragTest.css">
    <link rel="stylesheet" href="flexBoxs.css">

    <script src="../jquery-1.11.3.min.js"></script>

    <script src="DragImageList.js"></script>
    <script>
        ;window.addEventListener("load",LoginCheck)

        function LoginCheck() {
            console.log("LoginChecking..")
            let loginBtn = document.getElementById("login");
            let loginOutBtn = document.getElementById("loginOut");
            let username = "<%=session.getAttribute("username")%>"
            console.log("session中的username:"+username)
            if(username != null && username!="null"){
                console.log("当前还有信息")
                loginBtn.style.display = "none";
                loginOutBtn.style.display = "block";
            }else {
                loginBtn.style.display = "block";
                loginOutBtn.style.display = "none";
            }

            //为按钮添加事件
            loginBtn.addEventListener("click",()=>{
                location.href = "../login.jsp";
            })

            loginOutBtn.addEventListener("click",()=>{
                location.href = "../cancelLogin.jsp";
            })
        }
    </script>
    <base href="home">

    <title>相册首页</title>
</head>

<body>
<div class="imageList-container movable hide">
    <div id="pullback"><svg t="1613860886171" class="iconBack" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2130" width="24" height="24"><path d="M398.912 513.152l377.28-384.256c27.904-28.416 27.904-74.432 0-102.784-27.84-28.352-73.024-28.352-100.8 0L247.808 461.504C233.792 475.776 226.88 494.464 226.944 513.152 226.88 531.84 233.792 550.464 247.808 564.736l427.584 435.392c27.84 28.352 73.024 28.352 100.8 0 27.904-28.352 27.904-74.368 0-102.656L398.912 513.152z" p-id="2131" fill="#ffffff"></path></svg></div>
    <div class="imageList">
        <ul>
            <li draggable="true" class="draggableImg"><i></i>
                <p>summer</p><textarea cols="5" rows="1"></textarea></li>
            <li draggable="true" class="draggableImg"><i></i>
                <p>海滩</p><textarea rows="1"></textarea></li>
            <li draggable="true" class="draggableImg"><i></i>
                <p>星空</p><textarea rows="1"></textarea></li>
            <li draggable="true" class="draggableImg"><i></i>
                <p>鬼舞姬</p><textarea rows="1"></textarea></li>
            <li draggable="true" class="draggableImg"><i></i>
                <p>樱花</p><textarea rows="1"></textarea></li>
            <li draggable="true" class="draggableImg"><i></i>
                <p>夜晚</p><textarea rows="1"></textarea></li>
            <li draggable="true" class="draggableImg"><i></i>
                <p>夕阳</p><textarea rows="1"></textarea></li>
            <li draggable="true" class="draggableImg"><i></i>
                <p>落日</p><textarea rows="1"></textarea></li>
        </ul>
        <p></p>
    </div>
    <div class="imageOperation">
        <button id="addImg" onclick="openField()">添加图片</button>
        <form id="uploadField" action="${pageContext.request.contextPath}/upload" method="POST" enctype="multipart/form-data">
            <div  id="chooseFile">
                <input  type="file" name="photo">选择图片
            </div>
            <input  type="submit" id="uploadFile" value="上传图片">
            <button id="closeFieldBtn">关闭</button>
        </form>
        <button id="removeImg">删除图片</button>
    </div>
    <div class="userOperation">
        <button id="login">登录</button>
        <button id="loginOut">退出登录</button>
    </div>
</div>

<!-- 版权于 DZ125 @邓洲 所有 -->

<div class="main-container" data-mcs-theme="minimal-dark">
    <div class="introduction">
        <h1>介绍（版本1）</h1>
        <p>左边是侧边栏</p>
        <p>右边是相册栏</p>
        <p>拖动左边侧边栏的照片到右边的相册</p>
        <p>拖动照片到相册空白区添加相册图片</p>
        <p>点击侧边栏右上角的按钮可以锁住，再次点击可以解锁侧边栏回弹</p>
        <p>双击相册右边图片锁定，再双击解锁</p>
    </div>
    <div class="mImgContent">
        <!-- <div class="cardDSC">记录下所有的美好</div> -->
        <div class="box">
            <div class="droppableImage"></div>
        </div>
    </div>
</div>

</body>
</html>
