package com.kkb.mapper;

import com.kkb.pojo.TrQuestionTagExample;
import com.kkb.pojo.TrQuestionTagKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrQuestionTagMapper {
    long countByExample(TrQuestionTagExample example);

    /**
     * 根据条件删除
     * @param example
     * @return
     * */
    int deleteByExample(TrQuestionTagExample example);

    int deleteByPrimaryKey(TrQuestionTagKey key);

    /**
     * 添加 TQuestion 与TTag 关系
     * @param record
     * @return
     * */
    int insert(TrQuestionTagKey record);

    int insertSelective(TrQuestionTagKey record);

    List<TrQuestionTagKey> selectByExample(TrQuestionTagExample example);

    int updateByExampleSelective(@Param("record") TrQuestionTagKey record, @Param("example") TrQuestionTagExample example);

    int updateByExample(@Param("record") TrQuestionTagKey record, @Param("example") TrQuestionTagExample example);
}