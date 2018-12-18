package com.worriesconsult.dao;

import com.worriesconsult.bean.ProductImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageDao {

    int insert(ProductImage productImage);

    int deleteBatch( Long... id);

    int update(ProductImage productImage);

    ProductImage selectById(Long... id);

    ProductImage selectByProductId(Long product_id);

    ProductImage listById(Long id);

    List<ProductImage> select();

    List<ProductImage> show(Long[] product_id);

    List<ProductImage> listByProductId(Long id);

}
