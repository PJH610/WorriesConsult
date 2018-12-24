package com.worriesconsult.service.Impl;

import com.worriesconsult.bean.ProductImage;
import com.worriesconsult.dao.ProductImageDao;
import com.worriesconsult.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    ProductImageDao productImageDao;


    @Override
    public int insert(ProductImage productImage) {
        return productImageDao.insert(productImage);
    }

    @Override
    public int deleteBatch(Long... id) {
        return productImageDao.deleteBatch(id);
    }

    @Override
    public int update(ProductImage productImage) {
        if (productImage == null) return 0;
        return productImageDao.update(productImage);
    }

    @Override
    public ProductImage selectById(Long... id) {
        return productImageDao.selectById(id);
    }

    @Override
    public ProductImage listByProductId(Long product_id) {
        return productImageDao.listByProductId(product_id);
    }

    @Override
    public ProductImage listById(Long id) {
        return productImageDao.listById(id);
    }

    @Override
    public List<ProductImage> select() {
        return productImageDao.select();
    }

    @Override
    public List<ProductImage> show(Long[] product_id) {
        return productImageDao.show(product_id);
    }

    @Override
    public List<ProductImage> selectByProductId(Long id) {
        return productImageDao.selectByProductId(id);
    }
}
