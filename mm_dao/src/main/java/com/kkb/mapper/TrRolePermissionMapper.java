package com.kkb.mapper;

import com.kkb.pojo.TrRolePermissionExample;
import com.kkb.pojo.TrRolePermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrRolePermissionMapper {
    long countByExample(TrRolePermissionExample example);

    int deleteByExample(TrRolePermissionExample example);

    int deleteByPrimaryKey(TrRolePermissionKey key);

    int insert(TrRolePermissionKey record);

    int insertSelective(TrRolePermissionKey record);

    List<TrRolePermissionKey> selectByExample(TrRolePermissionExample example);

    int updateByExampleSelective(@Param("record") TrRolePermissionKey record, @Param("example") TrRolePermissionExample example);

    int updateByExample(@Param("record") TrRolePermissionKey record, @Param("example") TrRolePermissionExample example);
}