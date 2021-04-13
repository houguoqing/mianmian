package com.kkb.pojo;

import java.io.Serializable;

public class TrCompanyIndustryKey implements Serializable {
    private Integer companyId;

    private Integer industryId;

    private static final long serialVersionUID = 1L;

    public TrCompanyIndustryKey(Integer companyId, Integer industryId) {
        this.companyId = companyId;
        this.industryId = industryId;
    }

    public TrCompanyIndustryKey() {
        super();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", companyId=").append(companyId);
        sb.append(", industryId=").append(industryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}