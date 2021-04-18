package com.kkb.mapper;

import com.kkb.pojo.TCompany;
import com.kkb.pojo.TCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCompanyMapper {
    long countByExample(TCompanyExample example);

    int deleteByExample(TCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCompany record);

    int insertSelective(TCompany record);

    List<TCompany> selectByExample(TCompanyExample example);

    TCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCompany record, @Param("example") TCompanyExample example);

    int updateByExample(@Param("record") TCompany record, @Param("example") TCompanyExample example);

    /**
     * 根据主键 更新传入信息
     * @param record
     * @return
     * */
    int updateByPrimaryKeySelective(TCompany record);

    int updateByPrimaryKey(TCompany record);

    /**
     * 查询公司列表 含有行业信息
     * @return
     * */
    List<TCompany> selectListAll();


}