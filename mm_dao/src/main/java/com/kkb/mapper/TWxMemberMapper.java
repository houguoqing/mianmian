package com.kkb.mapper;

import com.kkb.pojo.TWxMember;
import com.kkb.pojo.TWxMemberExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWxMemberMapper {
    long countByExample(TWxMemberExample example);

    int deleteByExample(TWxMemberExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 新增会员
     * @param record
     * @return
     * */
    int insert(TWxMember record);

    int insertSelective(TWxMember record);

    List<TWxMember> selectByExampleWithBLOBs(TWxMemberExample example);

    List<TWxMember> selectByExample(TWxMemberExample example);

    TWxMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TWxMember record, @Param("example") TWxMemberExample example);

    int updateByExampleWithBLOBs(@Param("record") TWxMember record, @Param("example") TWxMemberExample example);

    int updateByExample(@Param("record") TWxMember record, @Param("example") TWxMemberExample example);

    int updateByPrimaryKeySelective(TWxMember record);

    int updateByPrimaryKeyWithBLOBs(TWxMember record);

    int updateByPrimaryKey(TWxMember record);

    /**
     * 根据openId 获取会员信息
     * @param openId
     * @return
     * */
    TWxMember selectByOpenId(String openId);

    /**
     * 更新城市学科id
     * @param data
     * @return
     * */
    int updateCityCourse(HashMap<String, String> data);
}