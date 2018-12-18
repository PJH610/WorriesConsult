package com.worriesconsult.controller;

import com.github.pagehelper.PageHelper;
import com.worriesconsult.bean.Category;
import com.worriesconsult.bean.MyPageInfo;
import com.worriesconsult.bean.Product;
import com.worriesconsult.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("api/product")
public class ProductController extends BaseApiController{
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Map<String, Object> add(@RequestParam String name, @RequestParam String subtitle, @RequestParam BigDecimal original_price,
                                   @RequestParam BigDecimal promote_price, @RequestParam Integer stock, @RequestParam Long category_id) {

        if (name == null || name.trim().length() == 0) return onBadResp("name 不能为空");
        if (subtitle == null || subtitle.trim().length() == 0) return onBadResp("subtitle 不能为空");
        if (original_price == null) return onBadResp("original_price 不能为空");
        if (promote_price == null) return onBadResp("promote_price 不能为空");
        if (stock == null) return onBadResp("stock 不能为空");
        if (category_id == null) return onBadResp("category_id 不能为空");

        Product product = new Product();
        product.setName(name.trim());
        product.setSubtitle(subtitle.trim());
        product.setOriginalPrice(original_price);
        product.setPromotePrice(promote_price);
        product.setStock(stock);
        product.setSaleCount(0);
        product.setReviewCount(0);
        product.setCreateDate(new Date());
        product.setCategoryId(category_id);

        if (productService.insert(product) > 0) return onSuccessRep("添加成功");
        return onBadResp("添加失败");
    }

    @PostMapping("/delete")
    public Map<String,Object> delete( @RequestParam Long[] id) {
        productService.deleteBatch(id);
        return onSuccessRep("删除成功");
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestParam Long id, String name, String subtitle, BigDecimal original_price,
                                      BigDecimal promote_price, Integer stock, Integer sale_Count, Long category_id) {
        if (name != null && name.trim().length() == 0) return onBadResp("name不能为空");
        if (subtitle != null && subtitle.trim().length() == 0) return onBadResp("subtitle不能为空");

        Product product = new Product();
        product.setId(id);
        if (name != null) product.setName(name.trim());
        if (subtitle != null) product.setSubtitle(subtitle.trim());
        if (original_price != null) product.setOriginalPrice(original_price);
        if (promote_price != null) product.setPromotePrice(promote_price);
        if (stock != null) product.setStock(stock);
        if (sale_Count != null) product.setSaleCount(sale_Count);
        if (category_id != null) product.setCategoryId(category_id);
        if (productService.update(product) > 0) {
            return onSuccessRep("修改成功");
        }
        return onBadResp("修改失败");
    }


}
