<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/25
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>选课管理系统</title>
<link rel="stylesheet" href="/LessonSystem/manager.css">
<script src="/LessonSystem/jquery-1.11.3.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-size: 18px;
        }

        body {
            background-color: #4E4B66;
        }

        header {
            background-color: #14142B;
            color: #fff;
            text-align: center;
            height: 60px;
            border-bottom: 5px solid #111;
            box-sizing: border-box;
        }

        footer {
            background-color: #14142B;
            position: fixed;
            bottom: 0px;
            left: 0px;
            width: 100%;
            height: 60px;
            text-align: center;
            color: #ccc;
        }

        center {
            background-color: #D9DBE9;
            width: 80%;
            position: absolute;
            top: 60px;
            left: 10%;
            min-height: calc(100% - 120px);
            /* border-radius: 10px; */
            overflow: hidden;
        }

        center .top-options {
            background-color: #D9DBE9;
            display: inline-block;
            width: 100%;
            height: 60px;
        }

        center .option-button {
            background-color: #14142B;
            color: #aaa;
            width: 49%;
            height: 60px;
            position: absolute;
            text-align: center;
            line-height: 60px;
            font-size: 24px;
            cursor: pointer;
        }

        #lessonSysBtn {
            left: 0px;
            border-radius: 0px 0px 10px 0px;
        }

        #instructSysBtn {
            right: 0px;
            border-radius: 0px 0px 0px 10px;
        }

        .active_option {
            background-color: #D9DBE9 !important;
            color: #000 !important;
            cursor: default !important;
        }

        center .match-bar {
            background-color: #aaa;
            width: 80%;
            height: 60px;
            position: fixed;
        }

        select {
            width: 200px;
            height: 40px;
            outline: none;
            border-radius: 10px;
            font-size: 18px;
        }

        select option {
            font-size: 18px;
            line-height: 40px;
        }

        label {
            font-size: 20px;
            font-weight: 600;
            margin-right: 10px;
        }

        #match-form {
            position: relative;
            top: 10px;
        }

        .match-item {
            width: 300px;
            margin: 0px 20px;
            position: absolute;
            left: 0;
        }

        button {
            width: 100px;
            height: 40px;
            border-radius: 10px;
            border: 0;
            cursor: pointer;
            transition: 0.5s;
            font-weight: bold;
            max-width: 40%;
        }

        button:hover {
            /* background-color: rgba(247, 132, 0, 0.644) !important; */
            color: #fff;
            box-shadow: 0px 0px 5px #000;
        }

        #submitButton {
            position: absolute;
            right: 50px;
            background-color: #28A745;
        }

        #result-table {
            width: 100%;
            height: 600px;
            background-color: #aaa;
            margin-top: 80px;
            overflow: auto;
        }

        .tb-row {
            display: block;
            /* background-color: aqua; */
            width: 100%;
            height: 40px;
            position: relative;
            padding-bottom: 10px;
        }

        .tb-col {
            display: block;
            background-color: #fff;
            width: 20%;
            height: 40px;
            float: left;
            margin-left: 5%;
            border-radius: 10px;
            line-height: 40px;
            overflow: hidden;
        }

        #lessonID {
            width: 20%;
        }

        #lessonName {
            width: 55%;
        }

        #delete {
            width: 24px;
            height: 24px;
            position: relative;
            border-radius: 50%;
            top: 8px;
        }

        #delete svg {
            top: 0px;
            left: 0;
            position: absolute;
        }

        #diolog {
            background-color: azure;
            width: 40%;
            height: 250px;
            position: fixed;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            display: none;
            z-index: 1000;
        }

        #confirmDelete {
            width: 35%;
            position: absolute;
            left: 10%;
            bottom: 10%;
            background-color: #B10000;
        }

        #cancleDelete {
            width: 35%;
            position: absolute;
            right: 10%;
            bottom: 10%;
        }

        #warnning-word {
            width: 80%;
            margin-top: 10%;
            font-size: 24px;
        }
    </style>
</head>

<body>
<header>
    <h1>选课管理系统</h1>
</header>
<left></left>
<center>
    <div class="top-options">
        <div class="option-button active_option" id="lessonSysBtn">课程系统</div>
        <div class="option-button" id="instructSysBtn">授课系统</div>
    </div>
    <div class="match-bar">
        <div id="match-form">
            <div class="match-item">
                <label>学院</label>
                <select name="college_id" id="collegeSelect"></select>
            </div>
            <button id="submitButton">查询</button>
        </div>
    </div>
    <div id="result-table">
        <div class="tb-row">
            <!-- <div class="tb-col" id="lessonID">20171310</div>
            <div class="tb-col" id="lessonName">近代史纲要</div>
            <div class="tb-col" id="delete">
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M24 12C24 15.1826 22.7357 18.2348 20.4853 20.4853C18.2348 22.7357 15.1826 24 12 24C8.8174 24 5.76516 22.7357 3.51472 20.4853C1.26428 18.2348 0 15.1826 0 12C0 8.8174 1.26428 5.76516 3.51472 3.51472C5.76516 1.26428 8.8174 0 12 0C15.1826 0 18.2348 1.26428 20.4853 3.51472C22.7357 5.76516 24 8.8174 24 12V12ZM6 11.25C5.80109 11.25 5.61032 11.329 5.46967 11.4697C5.32902 11.6103 5.25 11.8011 5.25 12C5.25 12.1989 5.32902 12.3897 5.46967 12.5303C5.61032 12.671 5.80109 12.75 6 12.75H18C18.1989 12.75 18.3897 12.671 18.5303 12.5303C18.671 12.3897 18.75 12.1989 18.75 12C18.75 11.8011 18.671 11.6103 18.5303 11.4697C18.3897 11.329 18.1989 11.25 18 11.25H6Z" fill="#B90012"/>
                </svg>
            </div> -->
        </div>
        <!-- 提示弹窗 -->
        <div id="diolog">
            <button id="confirmDelete">确定</button>
            <button id="cancleDelete">取消</button>
        </div>
    </div>

</center>
<footer>
    <h1>footer</h1>
</footer>
</body>

<script>
    const BaseURL = "http://localhost:8080/LessonSystem";
    let collegeList = [];
    let lessonList = [];
    let diologIndex = 0;
    window.onload = () => {
        let lessonSysBtn = document.getElementById("lessonSysBtn");
        let instructSysBtn = document.getElementById("instructSysBtn");
        // let collegeSelect = document.getElementById("collegeSelect");


        lessonSysBtn.onclick = () => {
            instructSysBtn.classList.remove("active_option");
            lessonSysBtn.classList.add("active_option");
        }

        instructSysBtn.onclick = () => {
            instructSysBtn.classList.add("active_option");
            lessonSysBtn.classList.remove("active_option");
        }



    }

    $(function() {
        $("#collegeSelect")[0].onclick = () => {
            if (collegeList.length == 0) {
                $.ajax({
                    url: BaseURL + "/dz/college/get_all",
                    success: res => {
                        collegeList = res;
                        console.log(collegeList)
                        refreshListView();
                    },
                    error: err => {
                        throw (err)
                    }
                });
            }
        }

        function refreshListView() {
            // let fragment = document.createDocumentFragment();
            for (let college of collegeList) {
                $("#collegeSelect").append(`<option value="${college.id}">${college.name}</option>`)
            }
        }

        $("#submitButton")[0].onclick = () => {
            // 发送ajax请求获取数据
            let url = BaseURL + "/dz/lesson/search?college_id=" + $("#collegeSelect")[0].value;
            console.log(url);
            $.ajax({
                url,
                success: function(response) {
                    console.log(response)
                    lessonList = response;
                    for (let lesson of lessonList) {
                        $("#result-table").append(`<div class="tb-row"><div class="tb-col" id="lessonID">${lesson.id}</div><div class="tb-col" id="lessonName">${lesson.name}</div><div class="tb-col" id="delete"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" clip-rule="evenodd" d="M24 12C24 15.1826 22.7357 18.2348 20.4853 20.4853C18.2348 22.7357 15.1826 24 12 24C8.8174 24 5.76516 22.7357 3.51472 20.4853C1.26428 18.2348 0 15.1826 0 12C0 8.8174 1.26428 5.76516 3.51472 3.51472C5.76516 1.26428 8.8174 0 12 0C15.1826 0 18.2348 1.26428 20.4853 3.51472C22.7357 5.76516 24 8.8174 24 12V12ZM6 11.25C5.80109 11.25 5.61032 11.329 5.46967 11.4697C5.32902 11.6103 5.25 11.8011 5.25 12C5.25 12.1989 5.32902 12.3897 5.46967 12.5303C5.61032 12.671 5.80109 12.75 6 12.75H18C18.1989 12.75 18.3897 12.671 18.5303 12.5303C18.671 12.3897 18.75 12.1989 18.75 12C18.75 11.8011 18.671 11.6103 18.5303 11.4697C18.3897 11.329 18.1989 11.25 18 11.25H6Z" fill="#B90012"/></svg></div></div>`);
                    }
                }
            });
        }



        $("#result-table").on("click", '#delete', e => {
            let row = $($(e.target).parents('.tb-row')[0]);
            let lessonId = row.children("#lessonID")[0].innerText;
            console.log(lessonId)
            //弹出会话框，提示是否删除
            $("#diolog").css("display", "block");
            diologIndex = lessonList.findIndex(item => item.id == lessonId);

            $("#diolog").append(`
      <p id="warnning-word">确认要删除课程《${lessonList[diologIndex].name}》？ 所有选择了该课程的班级和同学都会取消该课程。</p>
      `)

            $("#confirmDelete")[0].onclick = () => {
                deteleLesson(diologIndex);
                row.remove();
                $("#diolog").css("display", "none");
                $("#warnning-word").remove();
            }

        })

        $("#cancleDelete")[0].onclick = () => {
            $("#diolog").css("display", "none");
            $("#warnning-word").remove();
        }

        function deteleLesson(num) {
            console.log("删除" + num + "号数据")
            lessonList.splice(num, 1)
            console.log(lessonList);
            //发送网络请求删除数据库的数据
        }
    })
</script>
</html>
