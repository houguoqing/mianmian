package com.kkb.mapper;

import com.kkb.pojo.TDict;
import com.kkb.pojo.TDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDictMapper {
    long countByExample(TDictExample example);

    int deleteByExample(TDictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDict record);

    int insertSelective(TDict record);

    List<TDict> selectByExample(TDictExample example);

    TDict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDict record, @Param("example") TDictExample example);

    int updateByExample(@Param("record") TDict record, @Param("example") TDictExample example);

    int updateByPrimaryKeySelective(TDict record);

    int updateByPrimaryKey(TDict record);

    /**
     * 根据城市名称获取城市信息
     * @param cityName
     * @return
     * */
    TDict selectByCityName(String cityName);

    /**
     * 根据fs值获取城市列表
     * @param fs
     * @return
     * */
    List<TDict> selectCityListByTag(Integer fs);
}