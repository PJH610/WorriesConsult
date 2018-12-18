package com.worriesconsult.dao;

import com.worriesconsult.bean.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {

    int insert (Category category);

    int deleteBatch (Long... id);

    int updateById(Category category);

    List<Category> list();

    // 模糊查
    List<Category>listByName(@Param("name") String name);

    List<Category> listById(Long id);

}
