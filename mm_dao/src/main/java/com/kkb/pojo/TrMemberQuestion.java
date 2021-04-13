package com.kkb.pojo;

import java.io.Serializable;

public class TrMemberQuestion implements Serializable {
    private Integer id;

    private Integer memberId;

    private Integer questionId;

    private Integer isFavorite;

    private Integer tag;

    private String answerresult;

    private static final long serialVersionUID = 1L;

    public TrMemberQuestion(Integer id, Integer memberId, Integer questionId, Integer isFavorite, Integer tag, String answerresult) {
        this.id = id;
        this.memberId = memberId;
        this.questionId = questionId;
        this.isFavorite = isFavorite;
        this.tag = tag;
        this.answerresult = answerresult;
    }

    public TrMemberQuestion() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getAnswerresult() {
        return answerresult;
    }

    public void setAnswerresult(String answerresult) {
        this.answerresult = answerresult == null ? null : answerresult.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", questionId=").append(questionId);
        sb.append(", isFavorite=").append(isFavorite);
        sb.append(", tag=").append(tag);
        sb.append(", answerresult=").append(answerresult);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}