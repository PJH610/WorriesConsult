package com.worriesconsult.service;

import com.worriesconsult.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    int insert(Product product);

    int deleteBatch(Long... id);

    int update(Product product);

    Product selectById(Long id);

    Product selectByProductId(Long id);

    List<Product> list();

    List<Product> selectByName(@Param("name") String name);

    List<Product> selectFindProductImg(Long id);

    List<Product> findImgByCategoryId(Long category_id);

    List<Product> selectByCategoryId(Long category_id);
}
