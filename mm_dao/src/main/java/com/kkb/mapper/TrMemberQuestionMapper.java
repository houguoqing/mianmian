package com.kkb.mapper;

import com.kkb.pojo.TrMemberQuestion;
import com.kkb.pojo.TrMemberQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrMemberQuestionMapper {
    long countByExample(TrMemberQuestionExample example);

    int deleteByExample(TrMemberQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 新增用户答题记录
     * @param record
     * @return
     * */
    int insert(TrMemberQuestion record);

    int insertSelective(TrMemberQuestion record);

    List<TrMemberQuestion> selectByExample(TrMemberQuestionExample example);

    TrMemberQuestion selectByPrimaryKey(Integer id);

    /**
     * 根据条件修改记录
     * @param record
     * @param example
     * @return
     * */
    int updateByExampleSelective(@Param("record") TrMemberQuestion record, @Param("example") TrMemberQuestionExample example);

    int updateByExample(@Param("record") TrMemberQuestion record, @Param("example") TrMemberQuestionExample example);

    int updateByPrimaryKeySelective(TrMemberQuestion record);

    int updateByPrimaryKey(TrMemberQuestion record);
}