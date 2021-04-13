package com.kkb.page;


import java.io.Serializable;
import java.util.Map;

/**
 * 封裝查询条件
 */
public class QueryPageBean implements Serializable{

    private Integer pageNum; // 页码
    private Integer pageSize;   //每页记录数
    private Map queryParams;    //查询条件
    private Integer offset; // 分页查询，开始记录下标

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map queryParams) {
        this.queryParams = queryParams;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 获取分页起始记录位置
     * 根据分页页数，计算limit其实记录
     * @return
     */
    public Integer getOffset(){
        return (pageNum-1)*pageSize;
    }

    @Override
    public String toString() {
        return "QueryPageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", queryParams=" + queryParams +
                ", offset=" + offset +
                '}';
    }
}