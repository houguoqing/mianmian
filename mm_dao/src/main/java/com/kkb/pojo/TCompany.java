package com.kkb.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TCompany implements Serializable {
    private Integer id;

    private String shortName;

    private String fullName;

    private Integer isFamous;

    private Integer state;

    private String remark;

    private Date createDate;

    private Integer cityId;

    private Integer userId;

    private Integer orderNo;

    private static final long serialVersionUID = 1L;

    public TCompany(Integer id, String shortName, String fullName, Integer isFamous, Integer state, String remark, Date createDate, Integer cityId, Integer userId, Integer orderNo) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
        this.isFamous = isFamous;
        this.state = state;
        this.remark = remark;
        this.createDate = createDate;
        this.cityId = cityId;
        this.userId = userId;
        this.orderNo = orderNo;
    }

    public TCompany() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public Integer getIsFamous() {
        return isFamous;
    }

    public void setIsFamous(Integer isFamous) {
        this.isFamous = isFamous;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    //扩展字段
    private List<TIndustry> industryList; //行业列表

    public List<TIndustry> getIndustryList() {
        return industryList;
    }

    public void setIndustryList(List<TIndustry> industryList) {
        this.industryList = industryList;
    }

    @Override
    public String toString() {
        return "TCompany{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", cityId=" + cityId +
                ", userId=" + userId +
                ", industryList=" + industryList +
                '}';
    }

    public List<String> getIndustryNameList() {
        return industryNameList;
    }

    public void setIndustryNameList(List<String> industryNameList) {
        this.industryNameList = industryNameList;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //扩展字段,题目预览信息
    private List<String> industryNameList;//行业名称列表

    private String city; //城市名称
}