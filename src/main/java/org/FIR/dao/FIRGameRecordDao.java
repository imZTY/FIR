package org.FIR.dao;

import org.FIR.entity.FIRGameRecord;
import org.FIR.entity.FIRGameUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tianyi
 * @date 2017-12-31 13:25
 */
public interface FIRGameRecordDao {
    /**
     * 存入记录
     * @param userId
     * @param result
     * @param recordString
     * @return
     */
    boolean addRecord(@Param("userId") long userId, @Param("result") int result, @Param("recordString") String recordString);

    /**
     * 获取当前id的所有用户记录
     * @param userId
     * @return
     */
    List<FIRGameRecord> queryById(@Param("userId") long userId);

    /**
     * 多表查询JOIN测试
     * @param userId
     * @return
     */
    List<FIRGameRecord> JOINWINqueryById(@Param("userId") long userId);
}
