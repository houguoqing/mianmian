package com.kkb.service.impl;

import com.github.pagehelper.PageHelper;
import com.kkb.mapper.TCourseMapper;
import com.kkb.page.QueryPageBean;
import com.kkb.pojo.TCourse;
import com.kkb.pojo.TCourseExample;
import com.kkb.service.CourseService;
import com.kkb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 学科业务实现类
 * */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private TCourseMapper courseMapper;


    @Override
    public int addCourse(TCourse course) {
        return courseMapper.insert(course);
    }

    @Override
    public List<TCourse> findCourseList(QueryPageBean queryPageBean) {
        TCourseExample example = new TCourseExample();
        TCourseExample.Criteria criteria = example.createCriteria();
        Map queryParams = queryPageBean.getQueryParams();
        if(null!=queryParams && !queryParams.isEmpty()){
            if(StringUtils.isNotNull(queryParams.get("name"))){
                criteria.andNameLike('%' + (String)queryParams.get("name")+ '%');//学科名字 模糊查询
            }
            if(StringUtils.isNotNull(queryParams.get("status"))){
                criteria.andIsShowEqualTo((Integer) queryParams.get("status"));//是否显示
            }
        }
        PageHelper.startPage(queryPageBean.getPageNum(),queryPageBean.getPageSize());

        return courseMapper.selectByExample(example);
    }

    @Override
    public int updateCourse(TCourse course) {
        int result = courseMapper.updateByPrimaryKeySelective(course);
        return result;
    }
}
