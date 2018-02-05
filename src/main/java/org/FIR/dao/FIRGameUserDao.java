package org.FIR.dao;

import org.FIR.entity.FIRGameUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tianyi
 * @date 2017-12-31 13:26
 */
public interface FIRGameUserDao {

    /**
     *
     * @param userName
     * @param userPassword
     * @return
     */
    boolean addUser(@Param("userName") String userName, @Param("userPassword") String userPassword);

    /**
     * 据id查询用户
     * @param userId
     * @return
     */
    FIRGameUser queryById(@Param("userId") long userId);

    /**
     * 获取指定创建时间范围的所有用户
     * @param offset
     * @param limit
     * @return
     */
    List<FIRGameUser> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 获取ID，并判断用户是否已存在
     * @param userName
     * @return
     */
    long getId(@Param("userName") String userName);

    /**
     * 获取指定用户的密码
     * @param userName
     * @return
     */
    String getPassword(@Param("userName") String userName);
}
