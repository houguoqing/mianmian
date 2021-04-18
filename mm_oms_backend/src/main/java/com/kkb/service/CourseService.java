package com.kkb.service;

import com.kkb.page.QueryPageBean;
import com.kkb.pojo.TCourse;

import java.util.List;

/**
 * 学科业务接口
 *
 * */
public interface CourseService {
    /**
     * 添加学科
     * @param course
     * @return
     * */
    int addCourse(TCourse course);

    /**
     * 分页查询学科列表
     * @param queryPageBean
     * @return
     * */
    List<TCourse> findCourseList(QueryPageBean queryPageBean);


    /**
     * 更新学科
     * @param course
     * @return
     * */
    int updateCourse(TCourse course);

    /**
     * 查询所有学科列表(带有学科目录和学科标签)
     * @return
     * */
    List<TCourse> findListAll();
}
