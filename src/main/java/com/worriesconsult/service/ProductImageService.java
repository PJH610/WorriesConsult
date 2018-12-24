package com.worriesconsult.service;

import com.worriesconsult.bean.ProductImage;

import java.util.List;

public interface ProductImageService {

    int insert(ProductImage productImage);

    int deleteBatch( Long... id);

    int update(ProductImage productImage);

    ProductImage selectById(Long... id);

    ProductImage listByProductId(Long product_id);

    ProductImage listById(Long id);

    List<ProductImage> select();

    List<ProductImage> show(Long[] product_id);

    List<ProductImage> selectByProductId(Long id);
}
