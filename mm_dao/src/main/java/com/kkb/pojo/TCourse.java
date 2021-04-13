package com.kkb.pojo;

import java.io.Serializable;
import java.util.Date;

public class TCourse implements Serializable {
    private Integer id;

    private String name;

    private String icon;

    private Date createDate;

    private Integer isShow;

    private Integer userId;

    private Integer orderNo;

    private static final long serialVersionUID = 1L;

    public TCourse(Integer id, String name, String icon, Date createDate, Integer isShow, Integer userId, Integer orderNo) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.createDate = createDate;
        this.isShow = isShow;
        this.userId = userId;
        this.orderNo = orderNo;
    }

    public TCourse() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
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
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", createDate=").append(createDate);
        sb.append(", isShow=").append(isShow);
        sb.append(", userId=").append(userId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}