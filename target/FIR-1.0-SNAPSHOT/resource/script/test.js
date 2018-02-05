function finalll(id,recordString) {

    var black = new Image();
    var white = new Image();
    var bak= new Image();
    //与document.creatElement('img')一样

    black.width=7;
    black.height=7;
    white.height=7;
    white.width=7;
    black.src = "/FIRGAME/resource/picture/black.png";
    white.src = "/FIRGAME/resource/picture/white.png";
    bak.src = "/FIRGAME/resource/picture/bak.jpg";

var can = document.getElementById(id);
var ctx = can.getContext("2d"); //获取该canvas的2D绘图环境对象
ctx.strokeStyle = "#333";

can.setAttribute("width","222px");
can.setAttribute("height","222px");
can.setAttribute("background","/FIRGAME/resource/picture/bak.jpg");
/*var tempIdString="\"#"+id+"\"";

    $("#id").css(
        {
            /!*"margin-left":"30px",
            "margin-top":" 10px",*!/
            "width":"222",
            "height":"222px",
            /!*border:1px solid;*!/
            "background-color":"yellow",
            /!*"overflow":"hidden"*!/
        }
    );*/



draw()
    // 绘制格子
    function draw() {
        for (var m = 0; m < 15; m++) {
            for (var n = 0; n < 15; n++) {
                ctx.strokeRect(m * 13 + 7, n * 13 + 7, 13, 13);
                //（x,y,width,height）绘制格子
            }
        }
    }

drawend(recordString);

function drawend(bbb) {
    var arr = Array(16);
    for (i = 0; i < 15; i++) //i访问是几个二维数组
     {
        arr[i]=Array(16);
        for (j = 0; j < 15; j++) {
            arr[i][j]=bbb.charAt(16*i+j);
            if (arr[i][j] == 1) {
                pageFallChess(i,j,1);
            }
            else if(arr[i][j]==2){
                pageFallChess(i,j,2);
            }
        }
      }
    }

function pageFallChess(row,col,COLOR) {
        if (COLOR==2) {
            ctx.drawImage(black, col * 13, row * 13); //下黑子
        } else if(COLOR==1){
            ctx.drawImage(white, col * 13, row * 13);//下白子
        }
    }

}