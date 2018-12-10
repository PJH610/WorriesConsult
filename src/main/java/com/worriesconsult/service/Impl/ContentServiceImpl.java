package com.worriesconsult.service.Impl;

import com.worriesconsult.bean.Content;
import com.worriesconsult.dao.ContentDao;
import com.worriesconsult.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SX-503 on 2018/12/10.
 */
@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    ContentDao contentDao;


    @Override
    public int insert(Content content) {
        return contentDao.insert(content);
    }
}
