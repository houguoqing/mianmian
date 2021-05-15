package com.kkb.mm.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.kkb.constant.QuestionConst;
import com.kkb.mapper.TCatalogMapper;
import com.kkb.mapper.TQuestionForWxMapper;
import com.kkb.mapper.TWxMemberMapper;
import com.kkb.mapper.TrMemberQuestionMapper;
import com.kkb.mm.wx.service.CategoryService;
import com.kkb.pojo.TQuestionForWx;
import com.kkb.pojo.TrMemberQuestion;
import com.kkb.pojo.TrMemberQuestionExample;
import com.kkb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private TCatalogMapper catalogMapper;

    @Autowired
    private TQuestionForWxMapper questionMapper;

    @Autowired
    private TrMemberQuestionMapper memberQuestionMapper;

    @Autowired
    private TWxMemberMapper wxMemberMapper;

    @Override
    public List<Map> findCategory(HashMap<String, Object> data) {
        //data(categoryType=101 , 101-刷题,、201-错题本、202-我的练习、203-收藏题目)
        //判断当前categoryKind （   1-按学科目录  2- 按企业  3-按行业方向）
        Integer categoryKind = (Integer) data.get("categoryKind");
        List<Map> mapList = new ArrayList<>();

        if (categoryKind == QuestionConst.CategoryKind.CATALOG.getId()){
            mapList = catalogMapper.selectCategoryList(data);
        }else if(categoryKind == QuestionConst.CategoryKind.COMPANY.getId()){

        }else  if(categoryKind==QuestionConst.CategoryKind.CATALOG.getId()){

        }

        return mapList;
    }

    @Override
    public Map<String, Object> findCategoryQuestionList(HashMap<String, Object> mapData) {


        //判断当前categoryKind （   1-按学科目录  2- 按企业  3-按行业方向）
        Integer categoryKind = (Integer) mapData.get("categoryKind");
        Map resultMap = null;
        if (categoryKind == QuestionConst.CategoryKind.CATALOG.getId()){
            //按某一学科目录获取基本信息
            //复用分类列表获取，加入基于分类ID获取某一分类信息
            List<Map> mapList = catalogMapper.selectCategoryList(mapData);
            if(StringUtils.isNotNull(mapList)&&StringUtils.isNotEmpty(mapList)){
                resultMap = mapList.get(0);
            }

            //按某一学科目录获取目录下的题目信息列表
            List<TQuestionForWx> questionList = questionMapper.selectQuestionByQueryParam(mapData);
            resultMap.put("items",questionList);


        }else if(categoryKind == QuestionConst.CategoryKind.COMPANY.getId()){
            //按企业获取信息

        }else  if(categoryKind==QuestionConst.CategoryKind.CATALOG.getId()){
            //按行业获取信息
        }


        return resultMap;
    }

    @Override
    public int commitQuestion(HashMap<String, Object> mapData) {
        TrMemberQuestion memberQuestion = new TrMemberQuestion();
        //获取题目类型，确定answerTag值
        Integer type = (Integer) mapData.get("type");
        if(type==QuestionConst.Type.SINGLE.getId()||type ==QuestionConst.Type.MULTIPLE.getId()){
            //单选题或多选题
            Boolean b1 = (Boolean) mapData.get("answerIsRight");
            if(b1){
                memberQuestion.setTag(QuestionConst.AnswerTag.PERFECT.ordinal());
            }else {
                memberQuestion.setTag(QuestionConst.AnswerTag.WRONG.ordinal());
            }
            //把单选和多选的结果转成Json字符转
            String answerResult = JSON.toJSONString(mapData.get(mapData.get("answerResult")));
            memberQuestion.setAnswerresult(answerResult);

        }else if(type == QuestionConst.Type.SIMPLE.getId()){
            //简单题
            Boolean b1 = (Boolean) mapData.get("answerIsRight");
            if(b1){
                memberQuestion.setTag(QuestionConst.AnswerTag.GOOD.ordinal());
            }else{
                memberQuestion.setTag(QuestionConst.AnswerTag.BAD.ordinal());
            }

        }


        //收藏处理
        if(mapData.get("isFavorite") != null){
            Boolean b1 = (Boolean) mapData.get("isFavorite");
            memberQuestion.setIsFavorite(b1 ?1 :0 );
        }else{
            memberQuestion.setIsFavorite(0);
        }
        Integer memberId = (Integer) mapData.get("memberId");
        Integer questionId = (Integer) mapData.get("id");

        TrMemberQuestionExample example = new TrMemberQuestionExample();
        TrMemberQuestionExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        criteria.andQuestionIdEqualTo(questionId);
        int result = memberQuestionMapper.updateByExampleSelective(memberQuestion, example);
        if(result ==0){
            memberQuestion.setMemberId(memberId);
            memberQuestion.setQuestionId(questionId);
            result = memberQuestionMapper.insert(memberQuestion);
        }

        //更新会员信息
        wxMemberMapper.updateMemberLastAnswer(mapData);

        return result;
    }
}
