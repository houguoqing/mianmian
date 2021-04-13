package com.kkb.controller;

import com.kkb.domain.AjaxResult;
import com.kkb.pojo.TUser;
import com.kkb.service.UserService;
import com.kkb.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Enumeration;

import static com.kkb.constant.GlobalConst.SESSION_KEY_USER;

/**
* 用户业务控制器
* */
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping("user/login")
    @ResponseBody
    public AjaxResult login(@Validated @RequestBody TUser loginForm){

        try{
            //根据用户名获取用户对象
            TUser user = userService.findByUserName(loginForm.getUsername());
            //判断用户对象是否为空
            if(null==user){
                return AjaxResult.error("用户名不正确");
            }
            //判断用户名密码是否一致
            if(user.getPassword().equals(loginForm.getPassword())){

                //把对象放入session中
                ServletUtils.getSession().setAttribute(SESSION_KEY_USER,user);
                return AjaxResult.success("登录成功");
            }else {
                return  AjaxResult.error("用户名密码不一致");
            }


        }catch (Exception e){
            logger.error(e.getMessage());
            return AjaxResult.error("调用业务失败："+e.getMessage());

        }

    }
    /**
     * 退出功能
     * 清除所有会话信息
    * */
    @GetMapping("user/logout")
    @ResponseBody
    public AjaxResult logout(){
        try{
            Enumeration<String> em = ServletUtils.getSession().getAttributeNames();
            while (em.hasMoreElements()){
                //清除所有会话信息
             ServletUtils.getSession().removeAttribute(em.nextElement().toString());
            }
            return AjaxResult.success("退出成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            return AjaxResult.error("退出失败"+e.getMessage());
        }
    }
}
