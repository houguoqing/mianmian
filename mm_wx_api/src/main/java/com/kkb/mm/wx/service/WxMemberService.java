package com.kkb.mm.wx.service;

import com.kkb.pojo.TWxMember;

import java.util.HashMap;

/**
 * 会员业务接口类
 * */
public interface WxMemberService {
    /**
     * 根据openId 获取会员信息
     * @param openId
     * @return
     * */
    TWxMember findByOpenId(String openId);

    /**
     * 注册会员
     * @param member
     * @return
     * */
    int regWxMember(TWxMember member);

    /**
     * 更新会员城市和学科
     * @param data
     * @return
     * */
    int updateCityCourse(HashMap<String, String> data);
}
