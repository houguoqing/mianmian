package com.kkb.mapper;

import com.kkb.pojo.TCatalog;
import com.kkb.pojo.TCatalogExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TCatalogMapper {
    long countByExample(TCatalogExample example);

    int deleteByExample(TCatalogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCatalog record);

    int insertSelective(TCatalog record);

    List<TCatalog> selectByExample(TCatalogExample example);

    /**
     * 根据主键获取学科目录信息，包含学科名称
     * @param id
     * @return
     * */
    TCatalog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCatalog record, @Param("example") TCatalogExample example);

    int updateByExample(@Param("record") TCatalog record, @Param("example") TCatalogExample example);

    int updateByPrimaryKeySelective(TCatalog record);

    int updateByPrimaryKey(TCatalog record);

    /**
     * 根据条件获取学科列表
     * @param data
     * @return
     * */
    List<Map> selectCategoryList(HashMap<String, Object> data);
}