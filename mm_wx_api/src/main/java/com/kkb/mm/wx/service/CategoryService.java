package com.kkb.mm.wx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目分类业务接口
 * */

public interface CategoryService {

    /**
     * 获取题目分类列表
     * @param data
     * @return
     * */
    List<Map> findCategory(HashMap<String, Object> data);

    /**
     * 获取某一分类基本信息及题目列表
     * @param mapDate
     * @return
     * */
    Map<String, Object> findCategoryQuestionList(HashMap<String, Object> mapDate);

    /**
     * 提交问题答案
     * @param mapData
     * @return
     * */
    int commitQuestion(HashMap<String, Object> mapData);
}
