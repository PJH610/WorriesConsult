package com.worriesconsult.service;

import com.worriesconsult.bean.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryService {

    int insert (Category category);

    int deleteBatch (Long... id);

    int updateById(Category category);

    List<Category> list();

    // 模糊查
    List<Category>listByName(@Param("name") String name);
}
