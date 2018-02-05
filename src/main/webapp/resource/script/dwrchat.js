<!-- append脚本 -->

var name
var password;
var userId;
var dwrchat={

    //NO.1 用于聊天的方法
    chat:{
            /* 获取当前时间*/
            p: function (s) {
                return s < 10 ? '0' + s: s;
            },
            getTime:function (){
                var myDate = new Date();
                var year=myDate.getFullYear();
                var month=myDate.getMonth()+1;
                var date=myDate.getDate();
                var h=myDate.getHours();       //获取当前小时数(0-23)
                var m=myDate.getMinutes();     //获取当前分钟数(0-59)
                var s=myDate.getSeconds();
                var now=year+'-'+dwrchat.chat.p(month)+"-"+dwrchat.chat.p(date)+" "+dwrchat.chat.p(h)+':'+dwrchat.chat.p(m)+":"+dwrchat.chat.p(s);
                return now;
            },
            //TODO
            //用于后台调取的函数
            callback:function (msg){
                //alert('test！');
                return $("#ul").html($("#ul").html()+"<br />"+msg);
            },
    },

    //lAR = Login And Register
    //NO.2 用于登录和注册的方法
    LAR:{

            successLogin: function() {
                name=($(".checkusername").attr("id"));
                password=($("#passwordLogin").val());
                /*alert("Hello " + name + "!");*/
                url="/FIRGAME/woaiguangzhongyi/"+name+"/"+password+"/centre";
                window.location.href=url.toString();

            },
            getName:function() {//TODO mark
                dwrchat.LAR.doLoginAndRegister();
                /*name=disp_prompt();
                finishLogin();   这里的作用已经忘记*/
            },


            doLogin:function(msg){
                $("#textAreaInput").html($("#textAreaInput").html()+msg);

                //TODO 欠一个新用户连接进入提示

                //非本机用户的数据将被自动删除
                if(($("#usernameLogin").val())!=($(".checkusername").attr("id"))){
                    $(".checkpassword").remove();
                    $(".checkuserid").remove();
                    $(".checkusername").remove();
                }else{
                    return 1;
                }
            },
            doRegister:function(msg){
                $("#textAreaInput").html($("#textAreaInput").html()+msg);

                //TODO 欠一个新用户连接进入提示

                //非本机用户的数据将被自动删除
                if(($("#usernameRegister").val())!=($(".checkusername").attr("id"))){
                    $(".checkpassword").remove();
                    $(".checkuserid").remove();
                    $(".checkusername").remove();
                }else{
                    return 1;
                }
            },
            getCheckData:function() {
                password=($(".checkpassword").attr("id"));
                userId=($(".checkuserid").attr("id"));
            },
            checkLogin:function() {
                setTimeout(function () {
                    if((userId==undefined)){
                        alert("用户不存在，请注册");
                        parent.location.reload();
                    } else if(($("#passwordLogin").val())==password){
                        alert("登录成功");
                        dwrchat.LAR.successLogin();
                    }else{
                        alert("密码错误，请重试"+userId+password);
                        parent.location.reload();
                    }
                }, 666);
            },
            checkRegister:function() {
                setTimeout(function () {
                    if((userId!=undefined)){
                        alert("用户已存在，请重新注册");
                        parent.location.reload();
                    } else {
                        DwrPush.addUser(($("#usernameRegister").val()),($("#passwordRegister").val()));
                        alert("注册成功，请登录");
                        parent.location.reload();
                    }
                }, 666);
            },

    },

    //NO.3 公用方法
    public:{
            //获取RGB颜色
            getRGB:  function (){
                var r=Math.floor(Math.random()*256);
                var g=Math.floor(Math.random()*256);
                var b=Math.floor(Math.random()*256);
                return "rgb("+r+','+g+','+b+")";//所有方法的拼接都可以用ES6新特性`其他字符串{$变量名}`替换
            },

            setColor:function() {
                $("#ul #"+userId).addClass("text-right");
            },
            updatePeople:function () {
                /*return $("#onlineNumber").html("在线人数:"+sessionStorage.getItem("PEOPLE"));TODO */

            },
            feedBack:function () {
                DwrPush.refresh();
            },
            setPeople:function (people) {
                sessionStorage.setItem("PEOPLE",people);
            },
    },

}