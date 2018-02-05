package org.FIR.entity;

import java.sql.Date;

/**
 * @author tianyi
 * @date 2017-12-31 12:37
 */
public class FIRGameUser {

    private long userId;
    private String userName;
    private String userPassword;
    private long userPhone;
    private long winTimes;
    private long falureTimes;
    private Date createTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public long getWinTimes() {
        return winTimes;
    }

    public void setWinTimes(long winTimes) {
        this.winTimes = winTimes;
    }

    public long getFalureTimes() {
        return falureTimes;
    }

    public void setFalureTimes(long falureTimes) {
        this.falureTimes = falureTimes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
