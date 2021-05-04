package com.kkb.service;

import com.kkb.page.QueryPageBean;
import com.kkb.pojo.TQuestion;

import java.util.List;

/**
 * 题库业务类
 *
 * */
public interface QuestionService {
    /**
     * 分页获取题目列表
     * @param queryPageBean
     * @return
     * */
    List<TQuestion> findListByPage(QueryPageBean queryPageBean);

    /**
     * 更新保存题目信息
     * @param question
     * @return
     */
    int addOrUpdate(TQuestion question);

    /**
     *分页获取精选题库列表
     * @param queryPageBean
     * @return
     * */
    List<TQuestion> findClassicByPage(QueryPageBean queryPageBean);

    /**
     * 根据id查询题目信息
     * @param questionId
     * @return
     * */
    TQuestion findById(int questionId);
}
