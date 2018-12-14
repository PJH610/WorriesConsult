package com.worriesconsult.service.Impl;

import com.worriesconsult.bean.Category;
import com.worriesconsult.dao.CategoryDao;
import com.worriesconsult.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;


    @Override
    public int insert(Category category) {
        return categoryDao.insert(category);
    }

    @Override
    public int deleteBatch(Long... id) {
        return categoryDao.deleteBatch(id);
    }

    @Override
    public int updateById(Category category) {
        return categoryDao.updateById(category);
    }

    @Override
    public List<Category> list() {
        return categoryDao.list();
    }

    @Override
    public List<Category> listByName(String name) {
        return categoryDao.listByName(name);
    }
}
