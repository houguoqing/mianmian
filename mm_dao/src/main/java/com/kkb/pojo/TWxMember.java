package com.kkb.pojo;

import java.io.Serializable;
import java.util.Date;

public class TWxMember implements Serializable {
    private Integer id;

    private String nickName;

    private String gender;

    private String city;

    private String province;

    private String country;

    private String language;

    private String openId;

    private String unionId;

    private Date createTime;

    private Integer cityId;

    private Integer courseId;

    private Integer lastCategoryKind;

    private Integer lastCategoryType;

    private Integer lastCategoryId;

    private Integer lastQuestionId;

    private String avatarUrl;

    private static final long serialVersionUID = 1L;

    public TWxMember(Integer id, String nickName, String gender, String city, String province, String country, String language, String openId, String unionId, Date createTime, Integer cityId, Integer courseId, Integer lastCategoryKind, Integer lastCategoryType, Integer lastCategoryId, Integer lastQuestionId) {
        this.id = id;
        this.nickName = nickName;
        this.gender = gender;
        this.city = city;
        this.province = province;
        this.country = country;
        this.language = language;
        this.openId = openId;
        this.unionId = unionId;
        this.createTime = createTime;
        this.cityId = cityId;
        this.courseId = courseId;
        this.lastCategoryKind = lastCategoryKind;
        this.lastCategoryType = lastCategoryType;
        this.lastCategoryId = lastCategoryId;
        this.lastQuestionId = lastQuestionId;
    }

    public TWxMember(Integer id, String nickName, String gender, String city, String province, String country, String language, String openId, String unionId, Date createTime, Integer cityId, Integer courseId, Integer lastCategoryKind, Integer lastCategoryType, Integer lastCategoryId, Integer lastQuestionId, String avatarUrl) {
        this.id = id;
        this.nickName = nickName;
        this.gender = gender;
        this.city = city;
        this.province = province;
        this.country = country;
        this.language = language;
        this.openId = openId;
        this.unionId = unionId;
        this.createTime = createTime;
        this.cityId = cityId;
        this.courseId = courseId;
        this.lastCategoryKind = lastCategoryKind;
        this.lastCategoryType = lastCategoryType;
        this.lastCategoryId = lastCategoryId;
        this.lastQuestionId = lastQuestionId;
        this.avatarUrl = avatarUrl;
    }

    public TWxMember() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getLastCategoryKind() {
        return lastCategoryKind;
    }

    public void setLastCategoryKind(Integer lastCategoryKind) {
        this.lastCategoryKind = lastCategoryKind;
    }

    public Integer getLastCategoryType() {
        return lastCategoryType;
    }

    public void setLastCategoryType(Integer lastCategoryType) {
        this.lastCategoryType = lastCategoryType;
    }

    public Integer getLastCategoryId() {
        return lastCategoryId;
    }

    public void setLastCategoryId(Integer lastCategoryId) {
        this.lastCategoryId = lastCategoryId;
    }

    public Integer getLastQuestionId() {
        return lastQuestionId;
    }

    public void setLastQuestionId(Integer lastQuestionId) {
        this.lastQuestionId = lastQuestionId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickName=").append(nickName);
        sb.append(", gender=").append(gender);
        sb.append(", city=").append(city);
        sb.append(", province=").append(province);
        sb.append(", country=").append(country);
        sb.append(", language=").append(language);
        sb.append(", openId=").append(openId);
        sb.append(", unionId=").append(unionId);
        sb.append(", createTime=").append(createTime);
        sb.append(", cityId=").append(cityId);
        sb.append(", courseId=").append(courseId);
        sb.append(", lastCategoryKind=").append(lastCategoryKind);
        sb.append(", lastCategoryType=").append(lastCategoryType);
        sb.append(", lastCategoryId=").append(lastCategoryId);
        sb.append(", lastQuestionId=").append(lastQuestionId);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}