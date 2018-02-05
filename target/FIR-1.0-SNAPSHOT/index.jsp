<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/31
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>欢迎来到五子棋的世界</title>
    <link rel="stylesheet" href="/FIRGAME/resource/css/login.css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type='text/javascript' src='/FIRGAME/dwr/util.js'></script>
    <script type='text/javascript' src='/FIRGAME/dwr/engine.js'></script>
    <script type='text/javascript' src='/FIRGAME/dwr/interface/DwrPush.js'></script>
    <script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/FIRGAME/resource/script/dwrchat.js"></script>
</head>

<body>
<!-- 背景 -->
<canvas id="canvas"></canvas>
<script type="text/javascript" src='/FIRGAME/resource/js/login.js'></script>
<script type="text/javascript" src='/FIRGAME/resource/js/canvas.js'></script>
<script type="text/javascript">
    $(document).ready(function(){
        //TODO
        $("#loginBtn").click(function(){
                DwrPush.check(($("#usernameLogin").val()));
                dwrchat.LAR.checkLogin();
        });
            $("#registerBtn").click(function () {
                if(($("#passwordRegister").val())!=($("#confirmPsw").val())){
                    alert("两次密码不一致，请重试");
                }else {
                    DwrPush.checkDwrRegister(($("#usernameRegister").val()));
                    dwrchat.LAR.checkRegister();
                }

            });



        $("#showbotton").click(function(){
            parent.location.reload();
        });

        // 页面加载的时候进行反转的激活
        /* dwr.engine.setActiveReverseAjax(true); */
        dwr.engine.setActiveReverseAjax(true) ;

    });
</script>

<!-- 登录/注册框 -->
<div id="login_box">
    <h1>五子棋</h1>

    <p  class="register active" id="register">注册</p>
    <p  class="login " id='login'>登录</p>
    <!-- 登录 -->
    <form  aciton='' method='post' id='form_login' class="form">
        <input type="text" class="username" id='usernameLogin' placeholder="账号">
        <br>
        <input type="password" class="password" id='passwordLogin' placeholder="密码">
        <br>
        <input type="button" value="登录" class="loginBtn" id="loginBtn">
    </form>
    <!-- 注册 -->

    <form action='' method='post' id='form_register' class="form">
        <input type="text" class="username" id='usernameRegister' placeholder="账号">
        <br>
        <input type="password" class="password" id='passwordRegister' placeholder="密码">
        <br>
        <input type="password" class="password" id='confirmPsw' placeholder="确认密码">
        <br>
        <input type="button" value="注册" class="loginBtn" id="registerBtn">
    </form>
</div>
<div id="textAreaInput"></div>
</body>

</html>