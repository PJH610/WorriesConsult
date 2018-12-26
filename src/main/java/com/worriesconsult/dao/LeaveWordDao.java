package com.worriesconsult.dao;

import com.worriesconsult.bean.LeaveWord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveWordDao {

    int insert(LeaveWord leaveWord);

    int deleteBatch(Long... id);

    List<LeaveWord> list();

    List<LeaveWord> listById(Long id);
}
