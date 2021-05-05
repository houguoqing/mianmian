package com.kkb.mm.wx.service.impl;

import com.kkb.mapper.TWxMemberMapper;
import com.kkb.mm.wx.service.WxMemberService;
import com.kkb.pojo.TWxMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class WxMemberServiceImpl implements WxMemberService {
    @Autowired
    private TWxMemberMapper wxMemberMapper;

    @Override
    public TWxMember findByOpenId(String openId) {
        return wxMemberMapper.selectByOpenId(openId);
    }

    @Override
    public int regWxMember(TWxMember member) {
        return wxMemberMapper.insert(member);
    }

    @Override
    public int updateCityCourse(HashMap<String, String> data) {
        return wxMemberMapper.updateCityCourse(data);
    }
}
