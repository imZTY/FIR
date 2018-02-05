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

				black.src = "picture/black.png";
				white.src = "picture/white.png";

				var user1_img = document.getElementById('user1_img')
				var user2_img = document.getElementById('user2_img')

				var can = document.getElementById('can');
				var ctx = can.getContext("2d"); //获取该canvas的2D绘图环境对象
				ctx.strokeStyle = "#333";
				//棋盘初始化


				draw()


				var isBlack = true;
				//下子
				can.onclick = function play(e) {
					// alert(e.clientX);
					//获取棋盘偏移量
					var l = this.offsetLeft + 20;
					var t = this.offsetTop + 20;
					//棋盘相对于body的距离

					//获取点击相对棋盘坐标
					var x = e.clientX - l;
					var y = e.clientY - t;
					console.log(x)
					var row, col, index = 0;

					if (x % 40 < 20) {
						col = parseInt(x / 40);
					} else {
						col = parseInt(x / 40) + 1;
					}
					row = y % 40 < 20 ? parseInt(y / 40) : parseInt(y / 40) + 1;
					// alert(row+"行"+col+"行");  //第几列行第几列

					if (maps[row][col] === 0) {
						if (isBlack) {
							user1_img.src = 'picture/user.png'
							user2_img.src = 'picture/userOn.png'
							ctx.drawImage(black, col * 40, row * 40); //下黑子
							isBlack = false;
							maps[row][col] = 2; //黑子为2
							iswin(2, row, col);
						} else {
							user1_img.src = 'picture/userOn.png'
							user2_img.src = 'picture/user.png'
							ctx.drawImage(white, col * 40, row * 40);
							isBlack = true;
							maps[row][col] = 1; //白子为1
							iswin(1, row, col);
						}
					}

					function iswin(t, row, col) {
						var orgrow, orgcol, total;
						reset();
						// total是棋子数


						//判断每行是否有五个
						while (col > 0 && maps[row][col - 1] == t) { //当前子左边还有
							total++;
							col--;

						};
						row = orgrow;
						col = orgcol;
						while (col + 1 < 16 && maps[row][col + 1] == t) { //当前子右边还有
							col++;
							total++;
						};
						// alert(total);
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
							if (total >= 5) {
								if (t == 1) {
									document.getElementById('maskWhite').style.display = 'block'





								} else {

									document.getElementById('maskBlack').style.display = 'block'
									// can.height = can.height;
									// draw()
								}
							}
						}

						function reset() {
							orgrow = row;
							orgcol = col;
							total = 1;
						}
					}

				}

				function restart(id) {
					var can = document.getElementById('can');
					var ctx = can.getContext("2d");
					el=document.getElementById(id)
					el.style.display = 'none'
					can.height = can.height;
					draw()
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