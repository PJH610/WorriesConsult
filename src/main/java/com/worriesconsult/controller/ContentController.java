package com.worriesconsult.controller;

import com.worriesconsult.bean.Content;
import com.worriesconsult.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * Created by SX-503 on 2018/12/10.
 */
@RestController
@RequestMapping("api/content")
public class ContentController extends BaseApiController{
    @Autowired
    private ContentService contentService;

    @PostMapping("/add")
    public Map<String,Object> insert(@RequestParam String message) {
        if (message == null || message.trim().length() == 0)return onBadResp("不能为空");

        Content content = new Content();
        content.setMessage(message.trim());
        content.setDateTime(new Date());
        if (contentService.insert(content) > 0) return onSuccessRep("添加成功!!");
        return onBadResp("添加失败");
    }


}
