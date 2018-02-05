<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/31
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<%@include file="common/head.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>历史战绩</title>
    <style>
        * {
            margin: 0px;
            padding: 0;
        }
        body {
            background: #f7fafc;
        }
        h1 {
            text-align: center;
            font-family: KaiTi;
            margin: 10px;
        }

        .box {
            width: 960px;
            max-width: 960px;

            margin: 10px auto;
            height: 600px;
        }



        .history .result {
            text-align: center;
            font-family: KaiTi;
            font-size: 25px;
        }



        .date {
            width: 220px;
            height: 20px;
margin-left: 25px;

        }

        .date span {
            color: gray;

            margin-left: 40px;
        }

        .history {
    width: 220px;
    height: 270px;
    border: 0px solid #000;
    border-radius: 5px;
    margin-left: 75px;
    margin-bottom: 20px;
    overflow: hidden;
   background: #ffffff;
   float:left;

}

    </style>
    <script type="text/javascript" src="/FIRGAME/resource/script/test.js"></script>
</head>
<body>
<div class="box">
    <c:forEach var="record" items="${firGameRecordList}">
        <div class="history" id="${record.finishTime}">


            <c:if test="${record.result > 0}">
            <p class="result">胜利<p>
            </c:if>
            <c:if test="${record.result < 0}">
            <p class="result">失败<p>
            </c:if>



            <div class="can" id="${record.finishTime}${record.result}">
                <canvas width="210" height="210" class="gobang"></canvas>
            </div>

            <p class="date">
                <span><fmt:formatDate value="${record.finishTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
            </p>


        </div>
    </c:forEach>

</div>

<script src='js/history.js'></script>
</body>
</html>
