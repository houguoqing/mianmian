package com.kkb.mm.wx.service.impl;

import com.kkb.mapper.TWxMemberMapper;
import com.kkb.mm.wx.service.WxMemberService;
import com.kkb.pojo.TWxMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Map<String, Object> findMemberCenterById(Integer id) {
        Map<String,Object> map = wxMemberMapper.selectMemberCenterById(id);

        //map(categoryTitle) 这个数据如何取值
        //根据categoryKind去查询 1-查询学科目录 2.查询企业 3.查询行业
        String categoryTitle = wxMemberMapper.selectCategoryTitleByCategory((Integer)map.get("categoryKind"),(Integer)map.get("categoryID"));
        map.put("categoryTitle",categoryTitle);
        return wxMemberMapper.selectMemberCenterById(id);
    }
}
