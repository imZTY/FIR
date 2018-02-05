<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/31
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="true"%>
<%@include file="../common/tag.jsp" %>
<%--<%@include file="../common/head.jsp" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>五子棋</title>
	<link rel="stylesheet" href="/FIRGAME/resource/css/main.css">
	<script>
		// 计时

			var hour,minute,second;//时 分 秒
			hour=minute=second=0;//初始化
			var millisecond=0;//毫秒
			var int;
			start()
			// function Reset()//重置
			// {
			//   window.clearInterval(int);
			//   millisecond=hour=minute=second=0;
			//   document.getElementById('timetext').value='00时00分00秒000毫秒';
			// }

			function start()//开始
			{
			  int=setInterval(timer,1000);
			}

			function timer()//计时
			{
			 second=second+1;
			  if(second>=60)
			  {
				second=0;
				minute=minute+1;
			  }

			  if(minute>=60)
			  {
				minute=0;
				hour=hour+1;
			  }
			//   document.getElementById('time').innerHTML=hour+'时'+minute+'分'+second+'秒'+millisecond+'毫秒'
			  	document.getElementById('time').innerHTML=hour+'时'+minute+'分'+second+'秒'
			}

			// function stop()//暂停
			// {
			//   window.clearInterval(int);
			// }
		  </script>
    <%--<script type="text/javascript" src="/resource/script/test.js"></script>--%>
</head>

<body>
<!-- <canvas class="text">PK</canvas> -->


<div class="gobang">

    <canvas id="can" width="640" height="640">
        您的浏览器不支持canvas
    </canvas>
</div>


<div id="userInf">
    <div id="user1">
        <p>
            <img src="/FIRGAME/resource/picture/01.png" id="user1_img">
            <span id="playerA">${firGameUserA.userName}</span>
        </p>
    </div>
    <h1>VS</h1>
    <div id="user2">
        <p>
            <img src="/FIRGAME/resource/picture/01.png" id="user2_img">
            <span id="playerB">${firGameUserB.userName}</span>
        </p>
    </div>
</div>

<div id="record">
    <h3>战局分析</h3>
    <p id='win'>胜利局数：
        <span>${firGameUserA.userName}:${firGameUserA.winTimes}—————${firGameUserB.userName}:${firGameUserB.winTimes}</span>
    </p>
    <p id='lose'>失败局数：
        <span>${firGameUserA.userName}:${firGameUserA.falureTimes}—————${firGameUserB.userName}:${firGameUserB.falureTimes}</span>
    </p>
<% Date a=new Date(); %>
    <p id="timer">计&nbsp; &nbsp; 时：
        <span id="time">0时0分0秒</span>
    </p>
</div>

<%--<button onclick="a()">开始游戏</button>--%>

<div id="maskWhite" class="mask">
    <h1>白方胜利</h1>
    <button class="reStart" id='reStartW' onclick="restart('maskWhite')">重新开始</button>
</div>


<div id="maskBlack" class="mask">
    <h1>黑方胜利</h1>
    <button class="reStart" id='reStartB' onclick="restart('maskBlack')">重新开始</button>
</div>

<div class="giveUp">
    <p>投降</p>
    <div class="rootId" id="346363"></div>
</div>
<script>
    //这句话千万不能少 ，表示允许使用推送技术
   /* dwr.engine.setActiveReverseAjax(true);*/
    //定义二维数组作为棋盘
    var maps = new Array(16);
    var len = maps.length;

    for (var i = 0; i < len; i++) {
        maps[i] = new Array();
        for (var j = 0; j < len; j++) {
            maps[i][j] = 0;
            // console.log(maps[i][j]);
        }
    }

    //初始化棋子
    var clientWidth = document.documentElement.clientWidth; //可见区域的宽度
    var black = new Image();
    var white = new Image();
    //与document.creatElement('img')一样

    black.src = "/FIRGAME/resource/picture/black.png";
    white.src = "/FIRGAME/resource/picture/white.png";

    var user1_img = document.getElementById('user1_img');
    var user2_img = document.getElementById('user2_img');
    user2_img.src = '/FIRGAME/resource/picture/userOn.png';
    user1_img.src = '/FIRGAME/resource/picture/user.png';

    var can = document.getElementById('can');
    var ctx = can.getContext("2d"); //获取该canvas的2D绘图环境对象
    ctx.strokeStyle = "#333";


    //棋盘初始化
    draw();
/*
    var rootId;*/
    var isBlack = true;
    function changeRootId(id) {
        console.log("changingRootId..");
        /*return $(".rootId"). attr("id", id);*/
        rootId=id;
    }
    function checkROOT() {
      /*  /!*rootId=($(".rootId").attr("id"));*!/
        if(rootId!=){
            return true;
        }else {
            return false;
        }*/
    }


    /*a();*/
function drawend(bbb) {
    var arr = Array(16);
    for (i = 0; i < 15; i++) //i访问是几个二维数组
    {
        arr[i]=Array(16);
        for (j = 0; j < 15; j++) {
            arr[i][j]=bbb.charAt(16*i+j);
            if (arr[i][j] == 1) {
                pageFallChess(i,j,1);
                }//下黑子
            else if(arr[i][j]==2){
                pageFallChess(i,j,2);
            }
        }
    }
}

    function pageFallChess(row,col,COLOR) {
            if (COLOR==2) {
                ctx.drawImage(black, col * 40, row * 40); //下黑子
                maps[row][col] = 2; //黑子为2
            } else if(COLOR==1){
                ctx.drawImage(white, col * 40, row * 40);//下白子
                maps[row][col] = 1; //白子为1
            }
    }

    var row, col, index = 0;

        //下子
        can.onclick = function play(e) {
                if(checkROOT(rootId)){
                    // alert(e.clientX);
                    //获取棋盘偏移量
                    var l = this.offsetLeft + 20;
                    var t = this.offsetTop + 20;
                    //棋盘相对于body的距离

                    //获取点击相对棋盘坐标
                    var x = e.clientX - l;
                    var y = e.clientY - t;
                    console.log(x)

                    if (x % 40 < 20) {
                        col = parseInt(x / 40);
                    } else {
                        col = parseInt(x / 40) + 1;
                    }
                    row = y % 40 < 20 ? parseInt(y / 40) : parseInt(y / 40) + 1;
                     //alert(row+"行"+col+"行");  //第几列行第几列
                    if (maps[row][col] === 0) {
                        DwrPush.changeROOT(1,1);
                        DwrPush.fallChess(row,col,1);
                    }
                }else {
                    console.log("别着急，还没到你落棋哦");
                }
            }


    function iswin(t, row, col) {

        var orgrow=row, orgcol=col, total;
        function reset() {
            total = 1;
        }
        reset();
        // total是棋子数


        //判断每行是否有五个
        while (col > 0 && maps[row][col - 1] == t) { //当前子左边还有
            total++;
            col--;

        }
        ;
        row = orgrow;
        col = orgcol;
        while (col + 1 < 16 && maps[row][col + 1] == t) { //当前子右边还有
            col++;
            total++;
        }
        ;
        //alert(total);
        celebrate();

        //判断每列是否有五个
        reset();

        while (row > 0 && maps[row - 1][col] == t) { //当前子上面还有
            total++;
            row--;
        }
        row = orgrow;
        col = orgcol;
        while (row + 1 < 16 && maps[row + 1][col] == t) { //下面
            total++;
            row++;
        }
        celebrate();

        //左上 右下有没有五个
        reset();
        while (row > 0 && col > 0 && maps[row - 1][col - 1] == t) { //左上1
            row--;
            col--;
            total++;
        }
        row = orgrow;
        col = orgcol;
        while (row + 1 < 16 && col + 1 < 16 && maps[row + 1][col + 1] == t) { //右下1
            row++;
            col++;
            total++;
        }
        // alert(total)
        celebrate();

        //左下 右上有没有五个
        reset();
        // alert(total);
        while (row > 0 && col + 1 < 16 && maps[row - 1][col + 1] == t) { //右上
            row--;
            col++;
            total++;
        }
        row = orgrow;
        col = orgcol;
        while (row + 1 < 16 && col > 0 && maps[row + 1][col - 1] == t) { //左下
            row++;
            col--;
            total++;
        }
        // alert(total);
        celebrate();
        function celebrate() { //显示哪边赢
            var can = document.getElementById('can');
            var ctx = can.getContext("2d");
           /* if (total >= 5) {
                if (t == 1) {
                    document.getElementById('maskWhite').style.display = 'block';
                    console.log("结果矩阵"+maps.toString());

                    // can.height = can.height;
                    // draw()
                }
            }*/
        }
    }




				function restart(id) {
					var can = document.getElementById('can');
					var ctx = can.getContext("2d");
					el=document.getElementById(id)
					el.style.display = 'none'
					can.height = can.height;
					draw()
                    parent.location.reload();
				}

    // 绘制格子
    function draw() {
        for (var m = 0; m < len - 1; m++) {
            for (var n = 0; n < len - 1; n++) {
                ctx.strokeRect(m * 40 + 20, n * 40 + 20, 40, 40);
                //（x,y,width,height）绘制格子
            }
        }
    }
</script>


</body>

</html>
