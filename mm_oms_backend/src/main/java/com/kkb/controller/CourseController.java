package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.page.QueryPageBean;
import com.kkb.page.TableDataInfo;
import com.kkb.pojo.TCourse;
import com.kkb.pojo.TUser;
import com.kkb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static com.kkb.constant.GlobalConst.SESSION_KEY_USER;

@Controller
public class CourseController extends BaseController{
    @Autowired
    private CourseService courseService;
    /**
     * 新增学科
     * @param course
     * @return
     * */
    @PostMapping("course/add")
    @ResponseBody
    public AjaxResult addCourse(@Validated @RequestBody TCourse course){
        try{
            //设置创建日期
            course.setCreateDate(new Date());

            //获取当前用户信息
            TUser user = getSessionUser(SESSION_KEY_USER);


            //判断是否是登录用户
            if(user!=null){
                logger.info("当前用户:"+user.toString());
                course.setUserId(user.getId());
            }else {
                //return AjaxResult.error("无效用户");
                //调试时，默认是管理员
                course.setUserId(1);
            }

            //调用service
            int result=courseService.addCourse(course);
            return toAjax(result);


        }catch (Exception e){
            logger.error(e.getMessage());
            return AjaxResult.error("操作失败："+e.getMessage());
        }
    }


    /**
     * 分页获取学科列表
     * 调用响应请求分页数据的方法
     * @param queryPageBean
     * @return
     * */
    @PostMapping("course/findListByPage")
    @ResponseBody
    public TableDataInfo findListByPage(@RequestBody QueryPageBean queryPageBean){
        List<TCourse> courseList = courseService.findCourseList(queryPageBean);
        return getDataTable(courseList);
    }

    @PostMapping("course/update")
    @ResponseBody
    public AjaxResult updateCourse(@RequestBody TCourse course){
        try{
            int rows = courseService.updateCourse(course);
            return toAjax(rows);
        }catch (Exception e){
            logger.error(e.getMessage());
            return AjaxResult.error("服务异常:"+e.getMessage());
        }
    }

    @GetMapping("course/findListAll")
    @ResponseBody
    public AjaxResult findListForQuestion(){
        try{
            List<TCourse> courseList = courseService.findListAll();
            return AjaxResult.success(courseList);
        }catch (Exception e){
            logger.error(e.getMessage());
            return  AjaxResult.error("查询失败 "+e.getMessage());
        }
    }
}
