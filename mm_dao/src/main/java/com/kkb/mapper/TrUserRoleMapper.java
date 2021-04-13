package com.kkb.mapper;

import com.kkb.pojo.TrUserRoleExample;
import com.kkb.pojo.TrUserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrUserRoleMapper {
    long countByExample(TrUserRoleExample example);

    int deleteByExample(TrUserRoleExample example);

    int deleteByPrimaryKey(TrUserRoleKey key);

    int insert(TrUserRoleKey record);

    int insertSelective(TrUserRoleKey record);

    List<TrUserRoleKey> selectByExample(TrUserRoleExample example);

    int updateByExampleSelective(@Param("record") TrUserRoleKey record, @Param("example") TrUserRoleExample example);

    int updateByExample(@Param("record") TrUserRoleKey record, @Param("example") TrUserRoleExample example);
}