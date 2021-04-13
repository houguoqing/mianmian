package com.kkb.mapper;

import com.kkb.pojo.TrQuestionTagExample;
import com.kkb.pojo.TrQuestionTagKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrQuestionTagMapper {
    long countByExample(TrQuestionTagExample example);

    int deleteByExample(TrQuestionTagExample example);

    int deleteByPrimaryKey(TrQuestionTagKey key);

    int insert(TrQuestionTagKey record);

    int insertSelective(TrQuestionTagKey record);

    List<TrQuestionTagKey> selectByExample(TrQuestionTagExample example);

    int updateByExampleSelective(@Param("record") TrQuestionTagKey record, @Param("example") TrQuestionTagExample example);

    int updateByExample(@Param("record") TrQuestionTagKey record, @Param("example") TrQuestionTagExample example);
}