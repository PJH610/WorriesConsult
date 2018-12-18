package com.worriesconsult.controller;

import com.github.pagehelper.PageHelper;
import com.worriesconsult.bean.Category;
import com.worriesconsult.bean.MyPageInfo;
import com.worriesconsult.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/category")
public class CategoryController extends BaseApiController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public Map<String,Object> add(@RequestParam String name){
        if (name == null || name.trim().length() == 0)return onBadResp( "分类名不能为空" );
        Category category = new Category();
        category.setName(name);
        categoryService.insert(category);
        return onRespWithId("保存成功",category.getId());
    }

    @PostMapping("/delete")
    public Map<String,Object> delete( @RequestParam Long[] id) {
        categoryService.deleteBatch(id);
        return onSuccessRep("删除成功");

    }

    @PostMapping("/update")
    public Map<String,Object> update(@RequestParam Long id,@RequestParam String name){
        Category category = new Category();
        category.setId(id);
        if (name != null)category.setName(name.trim());
        categoryService.updateById(category);
        return onSuccessRep("修改成功");
    }

    @GetMapping("/list")
    public Map<String, Object> list(@RequestParam(defaultValue = "1") Integer page_num, @RequestParam(defaultValue = "10") Integer page_size)
    {
        PageHelper.startPage(page_num, page_size);
        return onDataResp(new MyPageInfo<Category>(categoryService.list()));
    }

    @GetMapping ("/show/{name}")
    public Map<String, Object> show(@RequestParam(defaultValue = "1") Integer page_num, @RequestParam(defaultValue = "10") Integer page_size, @RequestParam String name) {
        PageHelper.startPage(page_num, page_size);
        return onDataResp(new MyPageInfo<Category>(categoryService.listByName(name)));
    }

    @GetMapping ("/listById/{id}")
    public Map<String, Object> selectById(@RequestParam(defaultValue = "1") Integer page_num, @RequestParam(defaultValue = "10") Integer page_size, @PathVariable Long id) {
        PageHelper.startPage(page_num, page_size);
        return onDataResp(new MyPageInfo<Category>(categoryService.listById(id)));
    }
}
