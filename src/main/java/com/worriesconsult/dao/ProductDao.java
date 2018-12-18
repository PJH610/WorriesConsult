package com.worriesconsult.dao;

import com.worriesconsult.bean.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    int insert(Product product);

    int deleteBatch(Long... id);

    int update(Product product);

    Product selectById(Long id);

    Product selectByProductId(Long id);

    List<Product> list();

    // 模糊查询
    List<Product> selectByName(@Param("name") String name);

    // id 查商品图片
    List<Product> selectFindProductImg(Long id);

    // category_id 查图片
    List<Product> findImgByCategoryId(Long category_id);

    //category_id 查商品
    List<Product> selectByCategoryId(Long category_id);

}
