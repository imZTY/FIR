package org.FIR.dao;

import org.FIR.entity.FIRGameRecord;
import org.FIR.entity.FIRGameUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author tianyi
 * @date 2017-12-31 14:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class FIRGameRecordDaoTest {
    //注入Dao实现类依赖
    @Resource
    private FIRGameRecordDao firGameRecordDao;

    public static final int max=16;

    @Test
    public void addRecord() throws Exception {

        int[][] recordMatrix=new int[max][max];
        String recordString;
        for (int i=0;i<max;i++){   //创建测试矩阵
            for (int j=0;j<max;j++){
                if(i==j)
                {recordMatrix[i][j]=1;}
                else if (i>j)
                {recordMatrix[i][j]=0;}
                else
                {recordMatrix[i][j]=2;}
            }
        }
        outMatrix(recordMatrix);
        recordString=changeMatrix(recordMatrix);
        /*int[][] anotherMatrix=changeString(recordString);*/

        firGameRecordDao.addRecord(1,1,recordString);
    }

    private void outMatrix(int[][] recordMatrix){
        for (int i=0;i<max;i++){   //创建测试矩阵
            for (int j=0;j<max;j++){
                System.out.print(recordMatrix[i][j]);
            }
            System.out.println();
        }
    }

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

    private int[][] changeString(String string){
        int[][] anotherMatrix=new int[max][max];
        for (int i=0;i<max;i++){
            for (int j=0;j<max;j++){

                anotherMatrix[i][j]=(int)string.charAt(16*i+j)-48;
                System.out.print(anotherMatrix[i][j]);
            }
            System.out.println();
        }
        return anotherMatrix;
    }

    @Test
    public void queryById() throws Exception {
        List<FIRGameRecord> recordList=firGameRecordDao.queryById(1);
        for (FIRGameRecord record:recordList) {
            record.setRecordMatrix(changeString(record.getRecordString()));
            outMatrix(record.getRecordMatrix());
        }
    }

}