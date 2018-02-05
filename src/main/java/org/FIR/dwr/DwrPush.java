package org.FIR.dwr;

import org.FIR.dao.FIRGameRecordDao;
import org.FIR.dao.FIRGameUserDao;
import org.FIR.jdbc.dao.DataDao;
import org.FIR.service.FIRGameService;
import org.FIR.service.Impl.FIRGameServiceImpl;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.proxy.dwr.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author tianyi
 * @date 2018-01-01 14:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
/*@Controller
//需要标识为RemoteProxy才能被dwr调用
@RemoteProxy*/
public class DwrPush {
    private static int validPeople=0;
    private static long[][] player={{0,0},{0,0},{0,0},{0,0},{0,0},
                                     {0,0},{0,0},{0,0},{0,0},{0,0},
                                     {0,0},{0,0},{0,0},{0,0},{0,0}};

    public void setPlayerA(long id,int room){
        player[room-1][0]=id;
        System.out.println("A     "+player[room-1][0]);
    }
    public void setPlayerB(long id,int room){
        player[room-1][1]=id;
        System.out.println("B     "+player[room-1][1]);
    }

    @SuppressWarnings("deprecation")
    public void getPlayerA(int room){
        String msg="$('.playerA').attr('id','"+player[room-1][0]+"');";
        WebContext webContext = WebContextFactory.get();
        @SuppressWarnings("deprecation")
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数
        scriptBuffer.appendScript(msg);
        // 为所有的用户服务
        @SuppressWarnings("deprecation")
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
    }

    @SuppressWarnings("deprecation")
    public void getPlayerB(int room){
        String msg="$('.playerB').attr('id','"+player[room-1][1]+"');";
        WebContext webContext = WebContextFactory.get();
        @SuppressWarnings("deprecation")
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数
        scriptBuffer.appendScript(msg);
        // 为所有的用户服务
        @SuppressWarnings("deprecation")
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
    }
    private static int gamingPeople=0;
    @SuppressWarnings("deprecation")
    public void setGamingPeople(int number){
        gamingPeople+=number;
        String msg="$('.gamingPeople').attr('id','"+gamingPeople+"');";
        WebContext webContext = WebContextFactory.get();
        @SuppressWarnings("deprecation")
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数
        scriptBuffer.appendScript(msg);
        // 为所有的用户服务
        @SuppressWarnings("deprecation")
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
    }

    @RemoteMethod
    public void refresh(){
        validPeople+=1;
    }

    private DataDao dataDao = new DataDao();

    @RemoteMethod
    public void check(String user)throws Exception{
        System.out.println("Into sendKey(String user)");//打印Debug
        WebContext webContext = WebContextFactory.get();
        @SuppressWarnings("deprecation")
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        System.out.println(user);//打印Debug
        /*DwrPush dwrPush=new DwrPush();*/
        StringBuffer sb=new StringBuffer();
        sb.append("<div class=\"checkusername\" id=\"");
        sb.append(user);
        sb.append("\"></div>");
        sb.append("<div class=\"checkpassword\" id=\"");
        sb.append(dataDao.getPassword(user));
        sb.append("\"></div>");
        sb.append("<div class=\"checkuserid\" id=\"");
        sb.append(dataDao.getId(user));
        sb.append("\"></div>");

        System.out.println(sb.toString());
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数

        scriptBuffer.appendScript("dwrchat.LAR.doLogin( ");
        scriptBuffer.appendData(sb.toString());
        scriptBuffer.appendScript(" )");
        scriptBuffer.appendScript(";dwrchat.LAR.getCheckData()");

        // 为所有的用户服务
        @SuppressWarnings("deprecation")
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
    }

    @RemoteMethod
    public void checkDwrRegister(String user)throws Exception{
        System.out.println("Into sendKey(String user)");//打印Debug
        WebContext webContext = WebContextFactory.get();
        @SuppressWarnings("deprecation")
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        System.out.println(user);//打印Debug
        /*DwrPush dwrPush=new DwrPush();*/
        StringBuffer sb=new StringBuffer();
        sb.append("<div class=\"checkusername\" id=\"");
        sb.append(user);
        sb.append("\"></div>");
        sb.append("<div class=\"checkpassword\" id=\"");
        sb.append(dataDao.getPassword(user));
        sb.append("\"></div>");
        sb.append("<div class=\"checkuserid\" id=\"");
        sb.append(dataDao.getId(user));
        sb.append("\"></div>");

        System.out.println(sb.toString());
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数

        scriptBuffer.appendScript("dwrchat.LAR.doRegister( ");
        scriptBuffer.appendData(sb.toString());
        scriptBuffer.appendScript(" )");
        scriptBuffer.appendScript(";dwrchat.LAR.getCheckData()");

        // 为所有的用户服务
        @SuppressWarnings("deprecation")
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
    }

    @SuppressWarnings("deprecation")
    public void refreshCentrePeople(){
        System.out.println("refreshCentrePeople");
        WebContext webContext = WebContextFactory.get();
        @SuppressWarnings("deprecation")
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数
        validPeople=0;//重置validPeople
        scriptBuffer.appendScript("centre.update.feedBack()");
        scriptBuffer.appendScript(";setTimeout(\"DwrPush.updatePeople()\",200)");
        // 为所有的用户服务
        @SuppressWarnings("deprecation")
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
    }


    @SuppressWarnings("deprecation")
    public void updatePeople(String msg){
        System.out.println("updatePeople");
        int people=0;//至少显示一个用户
        WebContext webContext = WebContextFactory.get();
        @SuppressWarnings("deprecation")
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        people = validPeople;//取得上次反馈刷新的validPeople

        System.out.println(people);//打印Debug

        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数

        scriptBuffer.appendScript("centre.update.setPeople("+people+")");
        scriptBuffer.appendScript(";centre.update.updatePeople()");
        // 为所有的用户服务
        @SuppressWarnings("deprecation")
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
    }

    @SuppressWarnings("deprecation")
    public void changeROOT(long id,int roomId){

        WebContext webContext = WebContextFactory.get();
        @SuppressWarnings("deprecation")
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数
        scriptBuffer.appendScript("changeRootId"+roomId+"("+id+");");
        // 为所有的用户服务
        @SuppressWarnings("deprecation")
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
    }

    @SuppressWarnings("deprecation")
    public void fallChess(int row,int col,int roomId){

        WebContext webContext = WebContextFactory.get();
        @SuppressWarnings("deprecation")
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数
        scriptBuffer.appendScript("pageFallChess"+roomId+"("+row+","+col+");");
        // 为所有的用户服务
        @SuppressWarnings("deprecation")
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
    }


    @RemoteMethod
    public boolean addUser(String a,String b){
        try {
            dataDao.addUser(a,b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public void addRecord(long userId,int result,int[][] recordMatrix){
        try {
            dataDao.addRecord(userId, result, changeMatrix(recordMatrix));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateUser(long userId,int result){
        //TODO
        try {
            dataDao.updateUserRecord(userId,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int max=16;
    private String changeMatrix(int[][] recordMatrix){
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<max;i++){
            for (int j=0;j<max;j++){
                sb.append(recordMatrix[i][j]);
                System.out.print(recordMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n"+sb);
        return sb.toString();
    }
}
