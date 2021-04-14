package com.kkb.mapper;

import com.kkb.pojo.TCourse;
import com.kkb.pojo.TCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCourseMapper {
    long countByExample(TCourseExample example);

    int deleteByExample(TCourseExample example);

    /**
     * 删除学科
     * @param id
     * @return
     * */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增学科
     * @param record
     * @return
     * */
    int insert(TCourse record);

    int insertSelective(TCourse record);
    /**
     * 查询学科列表
     * @param example
     * @return
     * */
    List<TCourse> selectByExample(TCourseExample example);

    TCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCourse record, @Param("example") TCourseExample example);

    int updateByExample(@Param("record") TCourse record, @Param("example") TCourseExample example);

    /**
     * 更新学科信息
     * 只更新传入字段
     * @param record
     * @return
     * */
    int updateByPrimaryKeySelective(TCourse record);

    int updateByPrimaryKey(TCourse record);
}