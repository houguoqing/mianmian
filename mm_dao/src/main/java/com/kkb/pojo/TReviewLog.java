package com.kkb.pojo;

import java.io.Serializable;
import java.util.Date;

public class TReviewLog implements Serializable {
    private Integer id;

    private String comments;

    private Integer status;

    private Integer questionId;

    private Integer userId;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public TReviewLog(Integer id, String comments, Integer status, Integer questionId, Integer userId, Date createDate) {
        this.id = id;
        this.comments = comments;
        this.status = status;
        this.questionId = questionId;
        this.userId = userId;
        this.createDate = createDate;
    }

    public TReviewLog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", comments=").append(comments);
        sb.append(", status=").append(status);
        sb.append(", questionId=").append(questionId);
        sb.append(", userId=").append(userId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}