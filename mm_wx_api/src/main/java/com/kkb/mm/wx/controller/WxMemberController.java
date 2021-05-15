package com.kkb.mm.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.kkb.controller.BaseController;
import com.kkb.domain.AjaxResult;
import com.kkb.mm.wx.service.WxMemberService;
import com.kkb.mm.wx.utils.WxUtil;
import com.kkb.pojo.TWxMember;
import com.kkb.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.kkb.constant.GlobalConst.HEADER_AUTHORIZATION;

/**
 * 会员业务控制器
 * */
@Controller
public class WxMemberController extends BaseController {
    @Autowired
    private WxMemberService wxMemberService;

    @PostMapping("member/login")
    @ResponseBody
    public AjaxResult login(@RequestBody HashMap<String,String> data){
        try{
            logger.debug("data :"+data);
            String code = data.get("code");
            String encryptedCode = data.get("encryptedCode");
            String iv = data.get("iv");
            //根据微信工具类获取 openId 和 sessionKey
            JSONObject jsonObject = WxUtil.get(code);
            String openId =jsonObject.getString("openid"); //openId 在后续作为类似 webjessionId来使用
            String sessionKey = jsonObject.getString("session_key");

            //调用service 完成登录与注册
            TWxMember member = wxMemberService.findByOpenId(openId);
            //数据库没有会员信息完成注册
            if(null == member){
                member = new TWxMember();
                //解密微信会员信息
               JSONObject userJson = WxUtil.getUserInfo(encryptedCode,sessionKey,iv);
               logger.debug("userJson="+userJson);
               member.setNickName(userJson.getString("nickName"));
               member.setAvatarUrl(userJson.getString("avatarUrl"));
               member.setGender(userJson.getString("gender"));
               member.setCity(userJson.getString("city"));
               member.setProvince(userJson.getString("province"));
               member.setCountry(userJson.getString("country"));
               member.setLanguage(userJson.getString("language"));
               member.setOpenId(userJson.getString("openId"));
               member.setCreateTime(new Date());

               //调用微信用户注册服务，执行新增操作
                logger.debug("调用Service 注册新会员，会员数据是："+member);
                wxMemberService.regWxMember(member);
            }

            Map map = new HashMap<>();
            map.put("token",openId);
            map.put("userInfo",member);

            return AjaxResult.success(map);



        }catch (Exception e){
            logger.error(e.getMessage());
            return AjaxResult.error("请求失败："+e.getMessage());
        }
    }

    @PostMapping("member/setCityCourse")
    @ResponseBody
    public AjaxResult setCityCourse(@RequestBody HashMap<String,String> data){
        try{
            logger.debug("data:"+data);
            //从请求头部获取Token
            HttpServletRequest request = ServletUtils.getRequest();
            String openId = request.getHeader(HEADER_AUTHORIZATION);
            data.put("openId",openId);
            //调用service 传递Map data.put("openId",openId,subjectID)，完成城市及学科更新;
            int result = wxMemberService.updateCityCourse(data);
            return toAjax(result);


        }catch (Exception e){
            logger.error("设置会员城市学科失败："+e.getMessage());
            return AjaxResult.error("更新失败"+e.getMessage());
        }
    }

    /**
     *会员中心
     * @return
     */
    @PostMapping("member/center")
    @ResponseBody
    public AjaxResult getMemberCenter(){
        try {
            //根据openId 获取用户id
            String openId = getHeaderAuthorization();
            TWxMember wxMember = wxMemberService.findByOpenId(openId);
            //根据用户id 去数据库获取会员中心需要的数据
            Map<String,Object> resultMap= wxMemberService.findMemberCenterById(wxMember.getId());
            return AjaxResult.success(resultMap);
        }catch (Exception e){
            logger.error("获取用户数据失败"+e.getMessage());
            return AjaxResult.error("查询失败："+e.getMessage());
        }
    }
}
