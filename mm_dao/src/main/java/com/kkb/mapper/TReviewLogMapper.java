package com.kkb.mapper;

import com.kkb.pojo.TReviewLog;
import com.kkb.pojo.TReviewLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TReviewLogMapper {
    long countByExample(TReviewLogExample example);

    int deleteByExample(TReviewLogExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 添加审核日志
     * @param record
     * @return
     * */
    int insert(TReviewLog record);

    int insertSelective(TReviewLog record);

    List<TReviewLog> selectByExample(TReviewLogExample example);

    TReviewLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TReviewLog record, @Param("example") TReviewLogExample example);

    int updateByExample(@Param("record") TReviewLog record, @Param("example") TReviewLogExample example);

    int updateByPrimaryKeySelective(TReviewLog record);

    int updateByPrimaryKey(TReviewLog record);

    /**
     *获取最后一条审核记录
     * */
    TReviewLog selectLastByQuestionId(Integer questionId);
}