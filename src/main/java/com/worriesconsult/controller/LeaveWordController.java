package com.worriesconsult.controller;

import com.github.pagehelper.PageHelper;
import com.worriesconsult.bean.LeaveWord;
import com.worriesconsult.bean.MyPageInfo;
import com.worriesconsult.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/leaveWord")
public class LeaveWordController extends BaseApiController {

    @Autowired
    private LeaveWordService leaveWordService;

    @PostMapping("/add")
    public Map<String,Object> insert(@RequestParam String message,@RequestParam Integer user_id){
        if (message ==null || message.trim().length() ==0) return onBadResp("留言不能为空");
        LeaveWord leaveWord = new LeaveWord();
        leaveWord.setMessage(message);
        leaveWord.setUserId(user_id);

        if (leaveWordService.insert(leaveWord) > 0) return onSuccessRep("添加成功");
        return onBadResp("留言失败");
    }

    @PostMapping("/delete")
    public Map<String,Object> deleteBatch(@RequestParam Long[] id){
        leaveWordService.deleteBatch(id);
        return onSuccessRep("删除成功");
    }

    @GetMapping("/list")
    public Map<String,Object> list(@RequestParam(defaultValue = "1") Integer page_num,@RequestParam(defaultValue = "10")Integer page_size){
        PageHelper.startPage(page_num,page_size);
        return onDataResp(new MyPageInfo<LeaveWord>(leaveWordService.list()));
    }

    @GetMapping("/show/{id}")
    public Map<String,Object> listById(@RequestParam(defaultValue = "1")Integer page_num ,@RequestParam(defaultValue = "10")Integer page_size ,@RequestParam Long id){
        PageHelper.startPage(page_num,page_size);
        return onDataResp(new MyPageInfo<LeaveWord>(leaveWordService.listById(id)));
    }

}
