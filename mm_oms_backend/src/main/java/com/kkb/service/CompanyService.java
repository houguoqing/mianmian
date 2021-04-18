package com.kkb.service;

import com.kkb.pojo.TCompany;

import java.util.List;

/**
* 公司业务接口
* */
public interface CompanyService {
    /**
     * 获取公司列表,包含行业信息
     * */
    List<TCompany> findAllList();

}
