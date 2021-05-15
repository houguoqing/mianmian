package com.kkb.pojo;

import java.io.Serializable;
import java.util.List;

public class TQuestionForWx implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer type;


    //小程序扩展字段
    private String title; //题目标题

    private Integer grade;// 难易度

    private String content;//解析内容

    private String video;//视频

    private  String videoPoster;//视频封面

    private String answerResult;//会员答案

    private Integer answerTag;//答案标记

    private boolean answerIsRight ;//回答是否正确

    private  Integer isFinished;//是否完成

    private Integer isFavorite;//是否收藏

    private Integer memberId;// 会员id

    private List<TTag> tags ;//标签（考点）

    private List<TQuestionItemForWx> selection; //选项

    private Integer isFamous;//是否名企


    /**
     * 页面需要返回boolean类型
     * @return
     */
    public boolean getIsFamous() {
        return isFamous != null && isFamous ==1 ;
    }

    public void setIsFamous(Integer isFamous) {
        this.isFamous = isFamous;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoPoster() {
        return videoPoster;
    }

    public void setVideoPoster(String videoPoster) {
        this.videoPoster = videoPoster;
    }

    public String getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(String answerResult) {
        this.answerResult = answerResult;
    }

    public Integer getAnswerTag() {
        return answerTag;
    }

    public void setAnswerTag(Integer answerTag) {
        this.answerTag = answerTag;
    }

    /**
     * 回答正确或理想，，返回true
     * 其他情况返回false
     * @return
     */
    public boolean AnswerIsRight() {
        if(answerTag!= null &&(answerTag == 0 ||answerTag==2)){
            return true;
        }
        return false;
    }

    public void setAnswerIsRight(boolean answerIsRight) {
        answerIsRight = answerIsRight;
    }

    /**
     * 页面返回boolean类型
     * @return
     */
    public boolean getIsFinished() {
        return isFinished !=null && isFinished ==1;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    /**
     * 页面返回boolean
     * @return
     */
    public boolean  getIsFavorite() {
        return isFavorite !=null && isFinished ==1;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public List<TTag> getTags() {
        return tags;
    }

    public void setTags(List<TTag> tags) {
        this.tags = tags;
    }

    /**
     * 为选项按字母编号
     * @return
     */
    public List<TQuestionItemForWx> getSelection() {
        Character code = 'A';
        if(selection ==null) return null;
        for(TQuestionItemForWx questionItem:selection){
            questionItem.setCode(code.toString());
            code++;
        }
        return selection;
    }

    public void setSelection(List<TQuestionItemForWx> selection) {
        this.selection = selection;
    }

    @Override
    public String toString() {
        return "TQuestionForWx{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", grade=" + grade +
                ", content='" + content + '\'' +
                ", video='" + video + '\'' +
                ", videoPoster='" + videoPoster + '\'' +
                ", answerResult='" + answerResult + '\'' +
                ", answerTag=" + answerTag +
                ", answerIsRight=" + answerIsRight +
                ", isFinished=" + isFinished +
                ", isFavorite=" + isFavorite +
                ", memberId=" + memberId +
                ", tags=" + tags +
                ", selection=" + selection +
                '}';
    }
}
