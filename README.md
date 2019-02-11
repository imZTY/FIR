
# 双人对战五子棋（含匹配）
*基于DWR的一个网页版含有匹配模式的即时通信双人对战五子棋项目：FIR (Five In Row)*
___

## 项目背景
时年大二，学了半年JavaWeb开发的我新掌握SpringMVC，也正好在师兄的推荐下了解了DWR，于是乎就和一个前端的同学一起做了这个项目，作为Java课程的大作业。

## 项目结构
```
├─src
│  ├─main
│  │  ├─java
│  │  │  └─org
│  │  │      └─FIR
│  │  │          ├─dao 基于Spring+Mybatis实现DAO功能的代码
│  │  │          ├─dwr DWR的逻辑类
│  │  │          ├─entity 各表数据实体类
│  │  │          ├─jdbc JDBC相关
│  │  │          │  ├─base 基本的与mysql连接
│  │  │          │  └─dao 基于JDBC实现DAO功能
│  │  │          ├─service 服务层及其实现
│  │  │          │  └─Impl
│  │  │          └─web 视图控制层Controller
│  │  ├─resources
│  │  │  ├─mapper Mybatis的逻辑配置文件
│  │  │  └─spring Spring的配置文件
│  │  └─webapp
│  │      ├─resource 各静态资源
│  │      │  ├─css
│  │      │  ├─js
│  │      │  ├─picture
│  │      │  └─script
│  │      └─WEB-INF 
│  │          └─jsps 各jsp页面文件
│  │              ├─common
│  │              └─rooms
│  └─test
└─target
```

## 涉及技术：
1. DWR消息推送框架（实现**即时通信**的核心技术）
2. SSM后台框架（**Spring+SpringMVC+Mybatis**）
3. **jQuery**选择器，配合DWR实现前端逻辑
4. 参与人员：后端开发我ZTY + 前端开发同学3C + 功能设计&测试同学ZM

## 亮点
1. 用朴素的奇偶匹配思路实现了对战用户的匹配功能

## 不足
1. 当时七牛云未改版，七牛云不提供免费测试域名后没有将此项目的网络图片(七牛云CDN图片)调整过来

## 截图展示
![登录与注册](http://qiniu.zengtianyi.top/fir/login_register.png)
![游戏大厅](http://qiniu.zengtianyi.top/fir/lobby.png)
![胜局历史（本可看到棋盘矩阵）](http://qiniu.zengtianyi.top/fir/history.png)
![匹配效果](http://qiniu.zengtianyi.top/fir/gm-find.png)
![匹配逻辑](http://qiniu.zengtianyi.top/fir/gm-match.png)
![游戏对战](http://qiniu.zengtianyi.top/firgame/.png)
![游戏胜利1](http://qiniu.zengtianyi.top/fir/game-win.png)
![游戏胜利2](http://qiniu.zengtianyi.top/fir/game-win2.png)
