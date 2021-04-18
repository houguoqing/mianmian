package com.kkb.mapper;

import com.kkb.pojo.TrCompanyIndustryExample;
import com.kkb.pojo.TrCompanyIndustryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrCompanyIndustryMapper {
    long countByExample(TrCompanyIndustryExample example);

    /**
     * 根据条件删除
     * @param example
     * @return
     * */
    int deleteByExample(TrCompanyIndustryExample example);

    int deleteByPrimaryKey(TrCompanyIndustryKey key);

    /**
     * 添加公司行业信息
     * @param record
     * @return
     * */
    int insert(TrCompanyIndustryKey record);

    int insertSelective(TrCompanyIndustryKey record);

    List<TrCompanyIndustryKey> selectByExample(TrCompanyIndustryExample example);

    int updateByExampleSelective(@Param("record") TrCompanyIndustryKey record, @Param("example") TrCompanyIndustryExample example);

    int updateByExample(@Param("record") TrCompanyIndustryKey record, @Param("example") TrCompanyIndustryExample example);
}