package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.pojo.TCompany;
import com.kkb.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CompanyController extends BaseController{
    @Autowired
    private CompanyService companyService;

    @GetMapping("company/findListAll")
    @ResponseBody
    public AjaxResult findListAll(){
        try{
            List<TCompany> companyList = companyService.findAllList();
            return AjaxResult.success(companyList);
        }catch (Exception e){
            logger.error(e.getMessage());
            return AjaxResult.error("查询失败:"+e.getMessage());
        }
    }
}
