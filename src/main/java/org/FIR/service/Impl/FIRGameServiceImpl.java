package org.FIR.service.Impl;

import org.FIR.dao.FIRGameRecordDao;
import org.FIR.dao.FIRGameUserDao;
import org.FIR.entity.FIRGameRecord;
import org.FIR.entity.FIRGameUser;
import org.FIR.service.FIRGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianyi
 * @date 2018-01-01 16:05
 */
@Service
public class FIRGameServiceImpl implements FIRGameService {
    @Autowired
    private FIRGameRecordDao firGameRecordDao;

    @Autowired
    private FIRGameUserDao firGameUserDao;

    @Override
    public List<FIRGameRecord> recordById(long userId) {
        return firGameRecordDao.queryById(userId);
    }

    @Override
    public boolean addRecord(long userId, int result, String recordString) {
        return firGameRecordDao.addRecord(userId, result, recordString);
    }

    @Override
    public boolean addUser(String userName, String userPassword) {
        return firGameUserDao.addUser(userName, userPassword);
    }

    @Override
    public FIRGameUser userById(long userId) {
        return firGameUserDao.queryById(userId);
    }

    @Override
    public List<FIRGameUser> userLimitQuery(int offset, int limit) {
        return firGameUserDao.queryAll(offset, limit);
    }

    @Override
    public long getId(String userName) {
        return firGameUserDao.getId(userName);
    }

    @Override
    public String getPassword(String userName) {
        return firGameUserDao.getPassword(userName);
    }
}
