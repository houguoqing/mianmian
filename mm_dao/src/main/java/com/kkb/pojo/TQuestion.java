package com.kkb.pojo;

import java.io.Serializable;
import java.util.Date;

public class TQuestion implements Serializable {
    private Integer id;

    private String number;

    private String subject;

    private Integer type;

    private Integer difficulty;

    private String analysisVideo;

    private String remark;

    private Integer isClassic;

    private Integer status;

    private Integer reviewStatus;

    private Date createDate;

    private Integer userId;

    private Integer companyId;

    private Integer catalogId;

    private Integer courseId;

    private String analysis;

    private static final long serialVersionUID = 1L;

    public TQuestion(Integer id, String number, String subject, Integer type, Integer difficulty, String analysisVideo, String remark, Integer isClassic, Integer status, Integer reviewStatus, Date createDate, Integer userId, Integer companyId, Integer catalogId, Integer courseId) {
        this.id = id;
        this.number = number;
        this.subject = subject;
        this.type = type;
        this.difficulty = difficulty;
        this.analysisVideo = analysisVideo;
        this.remark = remark;
        this.isClassic = isClassic;
        this.status = status;
        this.reviewStatus = reviewStatus;
        this.createDate = createDate;
        this.userId = userId;
        this.companyId = companyId;
        this.catalogId = catalogId;
        this.courseId = courseId;
    }

    public TQuestion(Integer id, String number, String subject, Integer type, Integer difficulty, String analysisVideo, String remark, Integer isClassic, Integer status, Integer reviewStatus, Date createDate, Integer userId, Integer companyId, Integer catalogId, Integer courseId, String analysis) {
        this.id = id;
        this.number = number;
        this.subject = subject;
        this.type = type;
        this.difficulty = difficulty;
        this.analysisVideo = analysisVideo;
        this.remark = remark;
        this.isClassic = isClassic;
        this.status = status;
        this.reviewStatus = reviewStatus;
        this.createDate = createDate;
        this.userId = userId;
        this.companyId = companyId;
        this.catalogId = catalogId;
        this.courseId = courseId;
        this.analysis = analysis;
    }

    public TQuestion() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getAnalysisVideo() {
        return analysisVideo;
    }

    public void setAnalysisVideo(String analysisVideo) {
        this.analysisVideo = analysisVideo == null ? null : analysisVideo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsClassic() {
        return isClassic;
    }

    public void setIsClassic(Integer isClassic) {
        this.isClassic = isClassic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", subject=").append(subject);
        sb.append(", type=").append(type);
        sb.append(", difficulty=").append(difficulty);
        sb.append(", analysisVideo=").append(analysisVideo);
        sb.append(", remark=").append(remark);
        sb.append(", isClassic=").append(isClassic);
        sb.append(", status=").append(status);
        sb.append(", reviewStatus=").append(reviewStatus);
        sb.append(", createDate=").append(createDate);
        sb.append(", userId=").append(userId);
        sb.append(", companyId=").append(companyId);
        sb.append(", catalogId=").append(catalogId);
        sb.append(", courseId=").append(courseId);
        sb.append(", analysis=").append(analysis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}