package com.kkb.service.impl;

import com.github.pagehelper.PageHelper;
import com.kkb.constant.QuestionConst;
import com.kkb.mapper.*;
import com.kkb.page.QueryPageBean;
import com.kkb.pojo.*;
import com.kkb.service.QuestionService;
import com.kkb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private TQuestionMapper questionMapper;

    @Autowired
    private TQuestionItemMapper questionItemMapper;

    @Override
    public List<TQuestion> findListByPage(QueryPageBean queryPageBean) {
        Map map = queryPageBean.getQueryParams();
        if(null == map){
            map = new HashMap();
        }
        map.put("isClassic",0);
        PageHelper.startPage(queryPageBean.getPageNum(),queryPageBean.getPageSize());
        List<TQuestion> questionList = questionMapper.selectIsClassicByPage(map);
        return questionList;
    }

    @Override
    @Transactional
    public int addOrUpdate(TQuestion question) {
        System.out.println("Service addOrUpdata:  "+question);
        //1、保存题目信息
        int result = updateQuestion(question);
        //2、保存题目选型信息
        int updateQuestionItem = updateQuestionItem(question);

        //3、保存标签信息(题目与标签关系)
        int updateQuestionTag = updateQuestionTag(question);

        System.out.println("题目现有标签数量：" +updateQuestionTag);
        //4、更新企业信息(包含与行业关系)
        int updateCompany = updateCompany(question);

        return result;
    }

    private int updateQuestion(TQuestion question){
        //题目初始化  isClassic=null, status=null, reviewStatus=null, createDate=null
        question.setIsClassic(QuestionConst.ClassicStatus.CLASSIC_STATUS_NO.ordinal());
        question.setStatus(QuestionConst.Status.PRE_PUBLISH.ordinal());
        question.setReviewStatus(QuestionConst.ReviewStatus.PRE_REVIEW.ordinal());
        question.setCreateDate(new Date());
        if(question.getId()==0){
            int id = questionMapper.insert(question);
            System.out.println("新增成功id===="+question.getId());
            return id;
        }else {
            return questionMapper.updateByPrimaryKeySelective(question);
        }
    }

    /**
     * 保存题目选项
     * @param question
     * @return
     * */
    private int updateQuestionItem(TQuestion question){
        int i = 0;
        //遍历选项列表，逐一保存
        for(TQuestionItem questionItem:question.getQuestionItemList()){
            //其中某一题目选项
            //设置选项questionId
            questionItem.setQuestionId(question.getId());
            //如果选项内容为空，不插入数据库
            if(StringUtils.isNull(questionItem.getContent()) || StringUtils.isEmpty(questionItem.getContent())){
                if(StringUtils.isNull(questionItem.getImgUrl())||StringUtils.isEmpty(questionItem.getImgUrl())){
                    continue;
                }
            }
            //判断是添加还是更新
            if(questionItem.getId() == 0){
                //新增
                questionItemMapper.insert(questionItem);
                i++;
            }else {
                //更新
                questionItemMapper.updateByPrimaryKeySelective(questionItem);
                i++;
            }
        }
        return i;
    }
    @Autowired
    private TrQuestionTagMapper questionTagMapper;

    private  int updateQuestionTag(TQuestion question){
        int i=0;
        //先删除旧关系,根据questionId 删除
        TrQuestionTagExample example = new TrQuestionTagExample();
        TrQuestionTagExample.Criteria criteria = example.createCriteria();
        criteria.andQuestionIdEqualTo(question.getId());
        questionTagMapper.deleteByExample(example);

        //新增标签关系
        for(TTag tag:question.getTagList()){
            //构建关系
            TrQuestionTagKey trQuestionTagKey = new TrQuestionTagKey();
            trQuestionTagKey.setQuestionId(question.getId());
            trQuestionTagKey.setTagId(tag.getId());
            questionTagMapper.insert(trQuestionTagKey);
            i++;
        }

        return i;
    }

    @Autowired
    private TCompanyMapper companyMapper;

    @Autowired
    private TrCompanyIndustryMapper companyIndustryMapper;
    /**
     * 更新公司信息 包含与行业信息
     * @param question
     * @return
     * */
    private  int updateCompany(TQuestion question){
        int i = 0;
        //先更新企业信息
        TCompany company = question.getCompany();
        company.setUserId(question.getUserId());
        companyMapper.updateByPrimaryKeySelective(company);

        //更新公司与行业关系
        //删除旧关系,更具companyId删除
        TrCompanyIndustryExample example = new TrCompanyIndustryExample();
        TrCompanyIndustryExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyIdEqualTo(company.getId());
        companyIndustryMapper.deleteByExample(example);

        //新增公司行业关系
        //遍历公司杨业列表
        for(TIndustry industry:company.getIndustryList()){
            TrCompanyIndustryKey companyIndustryKey = new TrCompanyIndustryKey();
            companyIndustryKey.setCompanyId(company.getId());
            companyIndustryKey.setIndustryId(industry.getId());
            companyIndustryMapper.insert(companyIndustryKey);
            i++;
        }
        return i;
    }
}
