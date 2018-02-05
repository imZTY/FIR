package org.FIR.entity;

import java.util.Date;

/**
 * @author tianyi
 * @date 2017-12-31 12:47
 */
public class FIRGameRecord {
    private long recordId;
    private Date finishTime;
    private long userId;
    private int result;  //win or falure
    private String recordString;
    private int[][] recordMatrix;

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getRecordString() {
        return recordString;
    }

    public void setRecordString(String recordString) {
        this.recordString = recordString;
    }

    public int[][] getRecordMatrix() {
        return recordMatrix;
    }

    public void setRecordMatrix(int[][] recordMatrix) {
        this.recordMatrix = recordMatrix;
    }


}
