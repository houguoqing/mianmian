package com.kkb.mm.wx.controller;

import com.kkb.controller.BaseController;
import com.kkb.domain.AjaxResult;
import com.kkb.mm.wx.service.CategoryService;
import com.kkb.mm.wx.service.WxMemberService;
import com.kkb.pojo.TWxMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目分类控制器
 * */
@Controller
public class CategoryController extends BaseController {
    @Autowired
    private WxMemberService wxMemberService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("catagory/list")
    @ResponseBody
    public AjaxResult getGategoryList(@RequestBody HashMap<String,Object> data){
        try{
            //从header 中获取openIdD
            String openId = getHeaderAuthorization();
            //根据openId,获取会员信息,主要获取memberId,cityId,courseId
            TWxMember wxMember = wxMemberService.findByOpenId(openId);
            data.put("memberId",wxMember.getId());
            data.put("cityId",wxMember.getCityId());
            data.put("courseId",wxMember.getCourseId());

            //调用Service 获取分类列表
            logger.debug("获取题目分类列表，调用Service 参数："+data);
            List<Map> mapList = categoryService.findCategory(data);
            return AjaxResult.success(mapList);
        }catch (Exception e){
            logger.error("获取题目失败："+e.getMessage());
            return AjaxResult.error("操作失败"+e.getMessage());
        }
    }


    @PostMapping("category/questions/list")
    @ResponseBody
    public AjaxResult getCategoryQuestionList(@RequestBody HashMap<String,Object> mapDate){
        try{
            //从header中获取openId
            String opendId = getHeaderAuthorization();
            //根据openId,获取会员信息,主要获取memberId,cityId,courseId
            TWxMember wxMember = wxMemberService.findByOpenId(opendId);
            mapDate.put("memberId",wxMember.getId());
            mapDate.put("cityId",wxMember.getCityId());
            mapDate.put("courseId",wxMember.getCourseId());
            logger.debug("调用service分类获取基本信息及分类下的题目列表。参数mapDate:"+mapDate);

            Map<String,Object> resultMap = categoryService.findCategoryQuestionList(mapDate);
            return  AjaxResult.success(resultMap);
        }catch (Exception e){
            logger.error("获取题目失败"+e.getMessage());
            return AjaxResult.error("操作失败"+e.getMessage());
        }
    }

    /**
     * 提交问题答案
     * @param mapData
     * @return
     */
    @PostMapping("category/questions/commit")
    @ResponseBody
    public  AjaxResult commitQuestion(@RequestBody HashMap<String,Object> mapData){
        try{
            //根据openId 获取会员信息
            String openId = getHeaderAuthorization();
            TWxMember wxMember = wxMemberService.findByOpenId(openId);
            mapData.put("memberId",wxMember.getId());
            logger.debug("调用service 参数mapData:"+mapData);
            int result = categoryService.commitQuestion(mapData);
            return  toAjax(result);

        }catch (Exception e){
            logger.error("提交问题答案失败："+e.getMessage());
            return AjaxResult.error("操作失败"+e.getMessage());
        }

    }
}
