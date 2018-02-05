<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/1
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<%@include file="common/head.jsp" %>
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
    <style>
        .start {

            width: 250px;
            height: 60px;
            margin-left: -125px;
            margin-top: 10px;
            border: 1px solid grey;
            text-align: center;
            line-height: 60px;
            position: absolute;
            top: 80px;
            left: 50%;
            z-index: 2;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            color: #000;
            font-size: 22px;
        }



        .history {

            width: 250px;
            height: 60px;
            margin-left: -125px;
            margin-top: 10px;
            border: 1px solid grey;
            text-align: center;
            line-height: 60px;
            position: absolute;
            top: 160px;
            left: 50%;
            z-index: 2;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            color: #000;
            font-size: 22px;
        }

        .rank {
            width: 250px;
            height: 250px;
            max-height: 280px;
            position: absolute;
            top: 280px;
            left: 50%;
            margin-left: -125px;
            overflow: auto;
            border: 1px solid grey;
            text-align: center;
        }

        .rank table {
            width: 250px;
            margin: 0 auto;
            border: 0px;
            border-collapse: collapse;
            border-spacing: 0;

        }
        .thead{
            width: 180px;
            height: 40px;
            position: absolute;
            top: 220px;
            left: 50%;
            margin-left: -40px;
            font-family: kaiti;
            font-size: 22px;
            line-height: 40px;
            letter-spacing: 5px;
            font-weight: bold;
        }
        .rank table tr {
            height: 30px;
        }

        .rank table tr td {
            border-bottom: 1px solid grey;
        }
        .rank table tr:nth-child(1) td {
            border-bottom: 0px solid #000;
            font-weight: bold;
        }

        .start:hover,
        .history:hover {
            width: 252px;
            height: 62px;
        }

        .onlineNumber {
            width: 150px;
            overflow: hidden;
            position: absolute;
            bottom: 5%;
            left: 50%;
            margin-left: -45px;
        }

        .exit {
            width: 150px;
            overflow: hidden;
            position: absolute;
            bottom: 2%;
            left: 50%;
            margin-left: -25px;
            color: #000;
        }

        .wait {
            width: 200px;
            height: 100px;
            border: 1px solid grey;
            text-align: center;
            background: rgba(255, 255, 255, 0.5);
            z-index: 9999;
            position: absolute;
            top: 50%;
            margin-top: -70px;
            left: 50%;
            margin-left: -100px;
            border-radius: 5px;
            display: none;
        }

        .wait p {
            font-size: 22px;
            height: 30px;
            line-height: 30px;
        }

        .mask {
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            background: rgba(255, 255, 255, 0.6);
            z-index: 999;
            display: none;
        }
        a{
            color: #000;
            text-decoration: none;
        }
    </style>
   <%-- <script type="text/javascript" src="/resource/script/centre.js"></script>--%>
</head>
<script type="text/javascript">
    var playerA=0;
    var playerB=0;
    var gamingPeople=0;
    var people=0;
    var centre={
        update:{
            updatePeople:function () {
                return $("#onlineCentreNumber").html(sessionStorage.getItem("PEOPLE"));
            },
            feedBack:function () {
                console.log("feedBack");
                DwrPush.refresh();
            },
            setPeople:function (people) {
                console.log("setPeople");
                sessionStorage.setItem("PEOPLE",people);
            },
        },
        game:{
            /*setGamingPeople:function (number) {
                $("#textAreaInput").html($("#textAreaInput").html()+msg);
                gamingPeople=number;
            },
            setPlayerA:function (number) {
                $("#textAreaInput").html($("#textAreaInput").html()+msg);
                playerA=number;
            },
            setPlayerB:function (number) {
                $("#textAreaInput").html($("#textAreaInput").html()+msg);
                playerB=number;
            }*/
        }
    }
    $(document).ready(function(){
        //这句话千万不能少 ，表示允许使用推送技术
        dwr.engine.setActiveReverseAjax(true);
        DwrPush.refreshCentrePeople();
        DwrPush.setPlayerA(0);
        function checkB() {

        };
        function checkA() {

        };
        //TODO
        $("#startGame").click(function(){
            console.log("进入匹配模式");
            DwrPush.setGamingPeople(1);
            setTimeout(function () {

                gamingPeople=parseInt(($(".gamingPeople").attr("id")));
                if (gamingPeople>=30){DwrPush.setGamingPeople(-30);}
                console.log(gamingPeople);
                var momentgamingPeople=gamingPeople;
                if(momentgamingPeople%2!=0){
                    room1=(parseInt(momentgamingPeople)+1)/2;
                    setInterval(function(){
                        DwrPush.setPlayerA(${firGameUser.userId},room1);
                        DwrPush.getPlayerB(room1);
                        playerB=parseInt($(".playerB").attr("id"));
                        console.log(playerB+" B");
                        console.log("这是第"+momentgamingPeople+"个点击开始游戏的人，属于房间"+room1);
                        if (playerB!=0){
                            DwrPush.setPlayerA(0,room1);
                            DwrPush.setPlayerB(0,room1);
                            url="/FIRGAME/woaiguangzhongyi/"+room1+"/${firGameUser.userId}/"+playerB+"/${firGameUser.userId}/game";
                            console.log(url);
                            window.location.href=url.toString();}
                    },1600);

                }else{
                    room2=momentgamingPeople/2;
                    setInterval(function () {
                        DwrPush.getPlayerA(room2);
                        DwrPush.setPlayerB(${firGameUser.userId},room2);
                        playerA=parseInt($(".playerA").attr("id"));
                        console.log(playerA+" A");
                        console.log("这是第"+momentgamingPeople+"个点击开始游戏的人，属于房间"+room2);
                        if (playerA!=0){

                            url="/FIRGAME/woaiguangzhongyi/"+room2+"/"+playerA+"/${firGameUser.userId}/${firGameUser.userId}/game";
                            console.log(url);
                            window.location.href=url.toString();}
                    },1600);

                }
            },666);
        });
        $("#exitCentre").click(function () {
            alert("这里是退出");

        });
        $("#toRecordPage").click(function () {
            /*alert("即将前往历史记录页面");*/
            url="/FIRGAME/woaiguangzhongyi/${firGameUser.userId}/record";
            console.log(url);
            window.location.href=url.toString();
        });



        // 页面加载的时候进行反转的激活
        /* dwr.engine.setActiveReverseAjax(true); */
        dwr.engine.setActiveReverseAjax(true) ;

    });
</script>
<script>
    window.onload = function () {


        var mask = document.getElementsByClassName('mask')
        var wait = document.getElementsByClassName('wait')
        var start = document.getElementsByClassName('start')

        start[0].onclick = function () {

            mask[0].style.display = "block"
            wait[0].style.display = "block"


        }



    }
</script>
<body>
<!-- 背景 -->
<div id="wait" class="wait">

        <p>正在为您匹配对手
            <br>...</p>
    </div>
    <div class="mask"></div>

<canvas id="canvas"></canvas>
<script type="text/javascript" src='/FIRGAME/resource/js/canvas.js'></script>
<p class="start" id="startGame">开始游戏</p>
<p class="history" id="toRecordPage">历史战绩</p>

<p class="thead">排行榜</p>
<div id="rank" class="rank">

    <table>

        <tr >
            <td> 昵称 </td>
            <td>胜利局数</td>
        </tr>

        <c:forEach var="user" items="${firGameUserList}">
            <tr>
            <td><a href="/FIRGAME/woaiguangzhongyi/${user.userId}/record">${user.userName}</a></td>
            <td><span> ${user.winTimes}</span><br></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="findFriends">
    <div class="playerA" id="0"></div>
    <div class="playerB" id="00"></div>
    <div class="gamingPeople" id="000"></div>
    <div class="playerRoomId" id="0000"></div>
</div>
<p class="onlineNumber"> 在线人数: <span id="onlineCentreNumber">999</span></p>
<a  class="exit" id="exitCentre">退出登录</a>
</body>

</html>
