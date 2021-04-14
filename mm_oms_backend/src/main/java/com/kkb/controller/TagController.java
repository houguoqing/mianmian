package com.kkb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 学科标签控制类
 * */
@Controller
public class TagController {
    @GetMapping("tagList")
    public String tagList(Integer courseId){
        return "pages/tagList";
    }
}
