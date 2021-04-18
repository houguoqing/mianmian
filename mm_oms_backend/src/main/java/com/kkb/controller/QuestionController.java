package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.page.QueryPageBean;
import com.kkb.page.TableDataInfo;
import com.kkb.pojo.TQuestion;
import com.kkb.pojo.TUser;
import com.kkb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.kkb.constant.GlobalConst.SESSION_KEY_USER;

@Controller
public class QuestionController extends BaseController{
    @Autowired
    private QuestionService questionService;
    /**
     * 分页获取基础题目列表
     * @param queryPageBean
     * @return
     * */
    @PostMapping("question/findListByPage")
    @ResponseBody
    public TableDataInfo findListByPage(@RequestBody QueryPageBean queryPageBean){
        try{
            //调用service获取基础题目列表
            List<TQuestion> questionList = questionService.findListByPage(queryPageBean);
            return getDataTable(questionList);
        }catch (Exception e){
            logger.error(e.getMessage());
            List list = new ArrayList();
            TableDataInfo tableDataInfo = getDataTable(list);
            tableDataInfo.setCode(500);
            tableDataInfo.setMsg("操作失败："+e.getMessage());
            return tableDataInfo;
        }
    }

    @GetMapping("questionEditor")
    public String questionEditor(int questionId,int is_classic){
        return "pages/questionEditor";
    }

    @PostMapping("question/addOrUpdate")
    @ResponseBody
    public AjaxResult addOrUpdate(@RequestBody TQuestion question){
        try{
            //1、设置用户id
            TUser user = getSessionUser(SESSION_KEY_USER);
            //2、为了调试方便
            question.setUserId(user!=null?user.getId():1);
            logger.debug("调用Service question[]"+question);
            //3、调用Service
            int result = questionService.addOrUpdate(question);
            //4、响应 返回结果
            return toAjax(result);
        }catch (Exception e){
            logger.error(e.getMessage());
            return AjaxResult.error("操作失败："+e.getMessage());
        }
    }
}
