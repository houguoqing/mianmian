package com.kkb.mapper;

import com.kkb.pojo.TIndustry;
import com.kkb.pojo.TIndustryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TIndustryMapper {
    long countByExample(TIndustryExample example);

    int deleteByExample(TIndustryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TIndustry record);

    int insertSelective(TIndustry record);

    List<TIndustry> selectByExample(TIndustryExample example);

    TIndustry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TIndustry record, @Param("example") TIndustryExample example);

    int updateByExample(@Param("record") TIndustry record, @Param("example") TIndustryExample example);

    int updateByPrimaryKeySelective(TIndustry record);

    int updateByPrimaryKey(TIndustry record);
}