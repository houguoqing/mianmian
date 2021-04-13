package com.kkb.pojo;

import java.io.Serializable;

public class TrQuestionTagKey implements Serializable {
    private Integer questionId;

    private Integer tagId;

    private static final long serialVersionUID = 1L;

    public TrQuestionTagKey(Integer questionId, Integer tagId) {
        this.questionId = questionId;
        this.tagId = tagId;
    }

    public TrQuestionTagKey() {
        super();
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionId=").append(questionId);
        sb.append(", tagId=").append(tagId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}