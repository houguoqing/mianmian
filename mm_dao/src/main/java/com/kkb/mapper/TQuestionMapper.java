package com.kkb.mapper;

import com.kkb.pojo.TQuestion;
import com.kkb.pojo.TQuestionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TQuestionMapper {
    long countByExample(TQuestionExample example);

    int deleteByExample(TQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 添加题目信息
     * @param record
     * @return
     * */
    int insert(TQuestion record);

    int insertSelective(TQuestion record);

    List<TQuestion> selectByExampleWithBLOBs(TQuestionExample example);

    List<TQuestion> selectByExample(TQuestionExample example);

    TQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TQuestion record, @Param("example") TQuestionExample example);

    int updateByExampleWithBLOBs(@Param("record") TQuestion record, @Param("example") TQuestionExample example);

    int updateByExample(@Param("record") TQuestion record, @Param("example") TQuestionExample example);
    /**
     * 更新题目信息
     * @param record
     * @return
     * */
    int updateByPrimaryKeySelective(TQuestion record);

    int updateByPrimaryKeyWithBLOBs(TQuestion record);

    int updateByPrimaryKey(TQuestion record);

    /**
     * 获取题目列表  根据是否精选及条件
     * @param map
     * @return
     * */
    List<TQuestion> selectIsClassicByPage(@Param("params") Map<String,Object> map);

    /**
     * 查询题目信息，级联查询选项信息
     * @param questionId
     * @return
     * */
    TQuestion selectById(int questionId);
}