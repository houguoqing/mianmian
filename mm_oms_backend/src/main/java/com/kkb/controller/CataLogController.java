package com.kkb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 学科目录控制类
 * */
@Controller
public class CataLogController {
    /**
     * 学科目录列表页面
     * @param courseId
     * @return
     * */
    @GetMapping("catalogList")
    public String catalogList(Integer courseId){
        return "pages/catalogList";
    }
}
