package com.kkb.pojo;

import java.io.Serializable;
import java.util.Date;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shortName=").append(shortName);
        sb.append(", fullName=").append(fullName);
        sb.append(", isFamous=").append(isFamous);
        sb.append(", state=").append(state);
        sb.append(", remark=").append(remark);
        sb.append(", createDate=").append(createDate);
        sb.append(", cityId=").append(cityId);
        sb.append(", userId=").append(userId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}