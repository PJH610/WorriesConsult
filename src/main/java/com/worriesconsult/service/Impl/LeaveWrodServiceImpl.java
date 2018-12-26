package com.worriesconsult.service.Impl;

import com.worriesconsult.bean.LeaveWord;
import com.worriesconsult.dao.LeaveWordDao;
import com.worriesconsult.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveWrodServiceImpl implements LeaveWordService {
    @Autowired
    LeaveWordDao leaveWordDao;

    @Override
    public int insert(LeaveWord leaveWord) {
        return leaveWordDao.insert(leaveWord);
    }

    @Override
    public int deleteBatch(Long... id) {
        return leaveWordDao.deleteBatch(id);
    }

    @Override
    public List<LeaveWord> list() {
        return leaveWordDao.list();
    }

    @Override
    public List<LeaveWord> listById(Long id) {
        return leaveWordDao.listById(id);
    }
}
