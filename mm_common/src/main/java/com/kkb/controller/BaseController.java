package com.kkb.controller;

import com.alibaba.fastjson.JSON;
import com.kkb.constant.HttpStatus;
import com.kkb.domain.AjaxResult;
import com.kkb.page.PageDomain;
import com.kkb.page.TableDataInfo;
import com.kkb.page.TableSupport;
import com.kkb.pojo.TUser;
import com.kkb.utils.DateUtils;
import com.kkb.utils.ServletUtils;
import com.kkb.utils.SqlUtil;
import com.kkb.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.kkb.constant.GlobalConst.HEADER_AUTHORIZATION;


public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);


    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }


    public TUser getSessionUser(String userKey){
        if(ServletUtils.getSession() != null){
            return (TUser)ServletUtils.getSession().getAttribute(userKey);
        }
        return null;
    }


    public String getHeaderAuthorization(){
        HttpServletRequest request = ServletUtils.getRequest();
        return request.getHeader(HEADER_AUTHORIZATION);
    }
}