package com.kkb.service;

import com.kkb.pojo.TReviewLog;

/**
 * 审核日志业务接口
 * */
public interface ReviewLogService {
    /**
     * 添加审核日志
     * @param reviewLog
     * @return
     * */
    int addReview(TReviewLog reviewLog);
}
