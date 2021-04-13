package com.kkb.mapper;

import com.kkb.pojo.TWxMember;
import com.kkb.pojo.TWxMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWxMemberMapper {
    long countByExample(TWxMemberExample example);

    int deleteByExample(TWxMemberExample example);

    int deleteByPrimaryKey(Integer id);

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
}