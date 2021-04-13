package com.kkb.pojo;

import java.io.Serializable;

public class TDict implements Serializable {
    private Integer id;

    private Integer pid;

    private Integer dataType;

    private String dataCode;

    private String dataValue;

    private Integer dataTag;

    private String dataDesc;

    private Integer orderNo;

    private static final long serialVersionUID = 1L;

    public TDict(Integer id, Integer pid, Integer dataType, String dataCode, String dataValue, Integer dataTag, String dataDesc, Integer orderNo) {
        this.id = id;
        this.pid = pid;
        this.dataType = dataType;
        this.dataCode = dataCode;
        this.dataValue = dataValue;
        this.dataTag = dataTag;
        this.dataDesc = dataDesc;
        this.orderNo = orderNo;
    }

    public TDict() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode == null ? null : dataCode.trim();
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue == null ? null : dataValue.trim();
    }

    public Integer getDataTag() {
        return dataTag;
    }

    public void setDataTag(Integer dataTag) {
        this.dataTag = dataTag;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc == null ? null : dataDesc.trim();
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
        sb.append(", pid=").append(pid);
        sb.append(", dataType=").append(dataType);
        sb.append(", dataCode=").append(dataCode);
        sb.append(", dataValue=").append(dataValue);
        sb.append(", dataTag=").append(dataTag);
        sb.append(", dataDesc=").append(dataDesc);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}