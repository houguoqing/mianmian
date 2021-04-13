package com.kkb.pojo;

import java.io.Serializable;

public class TQuestionItem implements Serializable {
    private Integer id;

    private String content;

    private String imgUrl;

    private Integer isRight;

    private Integer questionId;

    private static final long serialVersionUID = 1L;

    public TQuestionItem(Integer id, String content, String imgUrl, Integer isRight, Integer questionId) {
        this.id = id;
        this.content = content;
        this.imgUrl = imgUrl;
        this.isRight = isRight;
        this.questionId = questionId;
    }

    public TQuestionItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Integer getIsRight() {
        return isRight;
    }

    public void setIsRight(Integer isRight) {
        this.isRight = isRight;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", isRight=").append(isRight);
        sb.append(", questionId=").append(questionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}