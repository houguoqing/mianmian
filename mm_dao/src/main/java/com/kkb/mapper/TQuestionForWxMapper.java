package com.kkb.mapper;

import com.kkb.pojo.TQuestionForWx;

import java.util.HashMap;
import java.util.List;

/**
 * 题目实体类（小程序）
 * */
public interface TQuestionForWxMapper {
    List<TQuestionForWx> selectQuestionByQueryParam(HashMap<String,Object> mapData);
}