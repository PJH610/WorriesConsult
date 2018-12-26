package com.worriesconsult.service;

import com.worriesconsult.bean.LeaveWord;

import java.util.List;

public interface LeaveWordService {

    int insert(LeaveWord leaveWord);

    int deleteBatch(Long... id);

    List<LeaveWord> list();

    List<LeaveWord> listById(Long id);
}
