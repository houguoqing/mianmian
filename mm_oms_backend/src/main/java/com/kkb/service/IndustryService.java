package com.kkb.service;

import com.kkb.pojo.TIndustry;

import java.util.List;

/**
 * 行业方形业务类
 * */
public interface IndustryService {
    /**
    * 查询所有行业列表
    * @return
    */
    List<TIndustry> findListAll();

}
