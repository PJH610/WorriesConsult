package com.worriesconsult.controller;

import com.github.pagehelper.PageHelper;
import com.worriesconsult.bean.MyPageInfo;
import com.worriesconsult.bean.ProductImage;
import com.worriesconsult.service.ProductImageService;
import com.worriesconsult.util.FileUploadUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@RestController
@RequestMapping("api/image")
public class ProductImageController extends BaseApiController{

    @Autowired
    ProductImageService productImageService;

    @Autowired
    FileUploadUtils fileUploadUtils;

    @PostMapping("/add")
    public Map<String, Object> add(@RequestParam(required = false) CommonsMultipartFile file,@RequestParam Long product_id){

        if (file == null){ return onBadResp("图片不能为空");}
        String filePath ="";

        ProductImage productImage = new ProductImage();
        productImage.setProductId(product_id);
        if (file == null && !file.isEmpty()){
            filePath =fileUploadUtils.getImagePath(file);
            if (filePath == null) return onBadResp("该文件不符合格式");
            productImage.setPicture(filePath);
        }
        if (productImageService.insert(productImage) > 0){
            if (StringUtils.isNotEmpty(filePath))fileUploadUtils.saveFile(file,filePath);
            return onSuccessRep("添加成功");
        }
        return onBadResp("添加失败");

    }

    @PostMapping("/delete")
    public Map<String, Object> deleteBatch(@RequestParam Long[] id, HttpSession session){

        String picture =productImageService.selectById(id).getPicture();
        File file = new File(fileUploadUtils.getBasePath() + picture);
        if (file.delete() && productImageService.deleteBatch(id) > 0){
            return onSuccessRep("删除成功");
        }
        return onBadResp("删除失败");
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestParam Long id,@RequestParam(required = false) CommonsMultipartFile file, Long product_id){
        if (file == null) return onBadResp("图片不能为空");
        String picture =productImageService.selectById(id).getPicture();
        File file1 = new File(fileUploadUtils.getBasePath() + picture);
        ProductImage productImage = new ProductImage();
        productImage.setId(id);
        if (product_id != null)productImage.setProductId(product_id);
        String filePath = "";

        if (file != null && !file.isEmpty()) {
            filePath = fileUploadUtils.getImagePath(file);
            if (filePath == null) return onBadResp("该文件不符合格式");
            productImage.setPicture(filePath);
        }
        if (productImageService.update(productImage) > 0 && file1.delete()) {
            if (StringUtils.isNotEmpty(filePath)) fileUploadUtils.saveFile(file, filePath);
            return onSuccessRep("修改成功");
        }
        return onSuccessRep("修改失败");
    }

    @GetMapping("/list")
    public Map<String, Object> select(@RequestParam(required = true,defaultValue = "1") Integer page_num, @RequestParam(required = false, defaultValue = "10") Integer page_size)
    {
        PageHelper.startPage(page_num, page_size);
        return onDataResp(new MyPageInfo<ProductImage>(productImageService.select()));
    }

    @GetMapping("/selectByProductId/{product_id}")
    public void list(@PathVariable Long product_id, HttpServletResponse response) throws IOException {
        String path = productImageService.selectByProductId(product_id).getPicture();
        File file = new File(fileUploadUtils.getBasePath() + path);
        if (file.exists()){
            FileInputStream in = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            while (in.read(b) != -1) {
                os.write(b);
            }
            in.close();
            os.flush();
            os.close();
        }
    }

    @GetMapping("/selectById/{id}")
    public void listById(@PathVariable Long id, HttpServletResponse response) throws IOException {

        String path = productImageService.selectById(id).getPicture();
        File file = new File(fileUploadUtils.getBasePath() + path);
        if (file.exists()){
            FileInputStream in = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            while (in.read(b) != -1) {
                os.write(b);
            }
            in.close();
            os.flush();
            os.close();
        }
    }

    @GetMapping("/show/{product_id}")
    public Map<String, Object> show(@RequestParam(required = true,defaultValue = "1") Integer page_num, @RequestParam(required = false, defaultValue = "10") Integer page_size, @PathVariable Long[] product_id)
    {
        PageHelper.startPage(page_num,page_size);
        return onDataResp(new MyPageInfo<ProductImage>(productImageService.show(product_id)));
    }

    @GetMapping("/listByProductId/{id}")
    public Map<String, Object> selectByProductId(@PathVariable Long id) {
        return onDataResp(productImageService.listByProductId(id));
    }

}