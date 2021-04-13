package com.kkb.pojo;

import java.io.Serializable;
import java.util.Date;

public class TTag implements Serializable {
    private Integer id;

    private String name;

    private Date createDate;

    private Integer status;

    private Integer userId;

    private Integer courseId;

    private Integer orderNo;

    private static final long serialVersionUID = 1L;

    public TTag(Integer id, String name, Date createDate, Integer status, Integer userId, Integer courseId, Integer orderNo) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.status = status;
        this.userId = userId;
        this.courseId = courseId;
        this.orderNo = orderNo;
    }

    public TTag() {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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
        sb.append(", createDate=").append(createDate);
        sb.append(", status=").append(status);
        sb.append(", userId=").append(userId);
        sb.append(", courseId=").append(courseId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}