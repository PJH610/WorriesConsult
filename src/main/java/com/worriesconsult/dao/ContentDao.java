package com.worriesconsult.dao;

import com.worriesconsult.bean.Content;
import org.springframework.stereotype.Repository;

/**
 * Created by SX-503 on 2018/12/10.
 */
@Repository
public interface ContentDao {

    int insert(Content content);
}
