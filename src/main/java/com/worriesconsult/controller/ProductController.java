package com.worriesconsult.controller;

import com.github.pagehelper.PageHelper;
import com.worriesconsult.bean.MyPageInfo;
import com.worriesconsult.bean.Product;
import com.worriesconsult.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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

    @GetMapping("/selectById")
    public Map<String, Object> selectById(@RequestParam Long id) {
        return onDataResp(productService.selectById(id));
    }

    @GetMapping("/selectByProductId")
    public Map<String, Object> selectByProductId (@RequestParam(defaultValue = "1") Integer page_num, @RequestParam(defaultValue = "5") Integer page_size,@RequestParam Long id){
        PageHelper.startPage(page_num,page_size);
        return onDataResp(new MyPageInfo<Product>((List<Product>) productService.selectByProductId(id)));
    }

    @GetMapping("/list")
    public Map<String, Object> list(@RequestParam(defaultValue = "1") Integer page_num, @RequestParam(defaultValue = "10") Integer page_size) {
        PageHelper.startPage(page_num, page_size);
        return onDataResp(new MyPageInfo<Product>(productService.list()));
    }

    @GetMapping("/selectByName")
    public Map<String, Object> list(@RequestParam(defaultValue = "1") Integer page_num, @RequestParam(defaultValue = "10") Integer page_size, @RequestParam String name) {
        PageHelper.startPage(page_num, page_size);
        return onDataResp(new MyPageInfo<Product>(productService.selectByName(name)));
    }

    @GetMapping("/selectFindProductImg/{id}")
    public Map<String, Object> selectFindProductImg(@RequestParam(defaultValue = "1") Integer page_num, @RequestParam(defaultValue = "10") Integer page_size, @PathVariable Long id) {
        PageHelper.startPage(page_num, page_size);
        return onDataResp(new MyPageInfo<Product>(productService.selectFindProductImg(id)));
    }

    // 通过分类id查询产品信息和图片
    @GetMapping("/findImgByCategoryId/{category_id}")
    public Map<String, Object> findImgByCategoryId(@RequestParam(required = true, defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @PathVariable Long category_id) {
        PageHelper.startPage(pageNo, pageSize);
        return onDataResp(new MyPageInfo<Product>(productService.findImgByCategoryId(category_id)));
    }

    // 查
    @GetMapping("/selectByCategoryId/{category_id}")
    public Map<String, Object> selectByCategoryId(@RequestParam(defaultValue = "1") Integer page_num, @RequestParam(defaultValue = "5") Integer page_size, @PathVariable Long category_id)
    {
        PageHelper.startPage(page_num,page_size);
        return onDataResp(new MyPageInfo<Product>(productService.selectByCategoryId(category_id)));
    }

}
