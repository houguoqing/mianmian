package com.kkb.mapper;

import com.kkb.pojo.TQuestionItem;
import com.kkb.pojo.TQuestionItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TQuestionItemMapper {
    long countByExample(TQuestionItemExample example);

    int deleteByExample(TQuestionItemExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 添加选项
     * @param record
     * @return
     * */
    int insert(TQuestionItem record);

    int insertSelective(TQuestionItem record);

    List<TQuestionItem> selectByExample(TQuestionItemExample example);

    TQuestionItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TQuestionItem record, @Param("example") TQuestionItemExample example);

    int updateByExample(@Param("record") TQuestionItem record, @Param("example") TQuestionItemExample example);

    /**
     * 更新选项
     * @param record
     * @return
     * */
    int updateByPrimaryKeySelective(TQuestionItem record);

    int updateByPrimaryKey(TQuestionItem record);

    List<TQuestionItem> selectListByQuestionId(Integer id);
}