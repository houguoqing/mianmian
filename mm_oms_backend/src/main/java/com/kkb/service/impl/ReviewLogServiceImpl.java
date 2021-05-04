package com.kkb.service.impl;

import com.kkb.constant.QuestionConst;
import com.kkb.mapper.TQuestionMapper;
import com.kkb.mapper.TReviewLogMapper;
import com.kkb.pojo.TQuestion;
import com.kkb.pojo.TReviewLog;
import com.kkb.service.ReviewLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ReviewLogServiceImpl implements ReviewLogService {
    @Autowired
    private TReviewLogMapper reviewLogMapper;

    @Autowired
    private TQuestionMapper questionMapper;

    @Override
    @Transactional
    public int addReview(TReviewLog reviewLog) {
        //调用持久化操作
        //1.保存审核日志记录
        int result = reviewLogMapper.insert(reviewLog);

        //2.更新主表状态和审核状态
        TQuestion question = new TQuestion();
        question.setId(reviewLog.getQuestionId());
        if(reviewLog.getStatus() == QuestionConst.ReviewStatus.REVIEWED.ordinal()){
            question.setStatus(QuestionConst.Status.PUBLISHED.ordinal());
        }else if(reviewLog.getStatus() == QuestionConst.ReviewStatus.REJECT_REVIEW.ordinal()){
            question.setStatus(QuestionConst.Status.PRE_PUBLISH.ordinal());
        }
        question.setReviewStatus(reviewLog.getStatus());
        questionMapper.updateByPrimaryKeySelective(question);
        return  result;
    }
}
