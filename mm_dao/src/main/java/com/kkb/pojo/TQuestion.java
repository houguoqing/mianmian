package com.kkb.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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


    //扩展字段
    private String courseName; //学科名称
    private String usedQty;    //使用次数
    private String creator;    //录入人员

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUsedQty() {
        return usedQty;
    }

    public void setUsedQty(String usedQty) {
        this.usedQty = usedQty;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }



    //保存题目扩展字段
    private TCompany company;//所属公司信息

    private List<TQuestionItem> questionItemList;//题目选项集合

    private List<TTag> tagList;//所属标签列表

    public TCompany getCompany() {
        return company;
    }

    public void setCompany(TCompany company) {
        this.company = company;
    }

    public List<TQuestionItem> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<TQuestionItem> questionItemList) {
        this.questionItemList = questionItemList;
    }

    public List<TTag> getTagList() {
        return tagList;
    }

    public void setTagList(List<TTag> tagList) {
        this.tagList = tagList;
    }


    @Override
    public String toString() {
        return "TQuestion{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", subject='" + subject + '\'' +
                ", type=" + type +
                ", difficulty=" + difficulty +
                ", analysisVideo='" + analysisVideo + '\'' +
                ", remark='" + remark + '\'' +
                ", isClassic=" + isClassic +
                ", status=" + status +
                ", reviewStatus=" + reviewStatus +
                ", createDate=" + createDate +
                ", userId=" + userId +
                ", companyId=" + companyId +
                ", catalogId=" + catalogId +
                ", courseId=" + courseId +
                ", analysis='" + analysis + '\'' +
                ", courseName='" + courseName + '\'' +
                ", usedQty='" + usedQty + '\'' +
                ", creator='" + creator + '\'' +
                ", company=" + company +
                ", questionItemList=" + questionItemList +
                ", tagList=" + tagList +
                '}';
    }

    //精选题库扩展字段
    private TReviewLog reviewLog;//审核日志

    public TReviewLog getReviewLog() {
        return reviewLog;
    }

    public void setReviewLog(TReviewLog reviewLog) {
        this.reviewLog = reviewLog;
    }

    //预览扩展字段
    private List<String> tagNameList; //标签名称列表

    public List<String> getTagNameList() {
        return tagNameList;
    }

    public void setTagNameList(List<String> tagNameList) {
        this.tagNameList = tagNameList;
    }

    public TCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(TCatalog catalog) {
        this.catalog = catalog;
    }

    private TCatalog catalog; //学科目录
}