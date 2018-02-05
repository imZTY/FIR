package org.FIR.service;

import org.FIR.entity.FIRGameRecord;
import org.FIR.entity.FIRGameUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tianyi
 * @date 2018-01-01 16:00
 */
public interface FIRGameService {

    List<FIRGameRecord> recordById(long userId);

    boolean addRecord( long userId,  int result, String recordString);

    boolean addUser(String userName,String userPassword);

    FIRGameUser userById( long userId);

    List<FIRGameUser> userLimitQuery(int offset, int limit);

    long getId(String userName);

    String getPassword( String userName);
}
