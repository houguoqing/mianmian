package com.kkb.mm.wx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.kkb.controller.BaseController;
import com.kkb.domain.AjaxResult;
import com.kkb.mm.wx.service.CommonService;
import com.kkb.mm.wx.utils.LocationUtil;
import com.kkb.pojo.TCourse;
import com.kkb.pojo.TDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kkb.constant.GlobalConst.REDIS_KEY_WX_COURSE_LIST;

/**
 * 公共接口控制类
 * */
@Controller
public class CommonController extends BaseController {
    @Autowired
    private CommonService commonService;

    @PostMapping("common/citys")
    @ResponseBody
    public AjaxResult getCitys(@RequestBody HashMap data){
        try{
            logger.debug("data :"+data);
            //通过地址，解析出城市名称
            String cityName = LocationUtil.parseLocation((String) data.get("location"));
            //调用service,根据城市名称，获取城市id(id,title)
            TDict dict = commonService.findDictByCityName(cityName);

            //调用Service 根据fs的值,获取城市列表
            List<TDict> cityList = commonService.findDictListByFs((Integer)data.get("fs"));

            //返回数据 location:{} citys[]

            //模拟实现
            Map result = new HashMap<>();
            TDict city = new TDict();
            city.setId(10);
            city.setTitle("上海");

            result.put("location",dict);
            result.put("citys",cityList);
            return AjaxResult.success(result);
        }catch (Exception e){
            logger.error(e.getMessage());
            return AjaxResult.error("请求失败："+e.getMessage());
        }
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获取学科列表
     * */
    @GetMapping("common/courseList")
    @ResponseBody
    public AjaxResult getCourseList(){
        try{
            String jsonString = redisTemplate.opsForValue().get(REDIS_KEY_WX_COURSE_LIST);
            if(jsonString != null &&"".equals(jsonString) ){
                logger.debug("调用Redis获取学科列表");
                JSONArray jsonArray = JSON.parseArray(jsonString);
                return AjaxResult.success(jsonArray);
            }

            List<TCourse> courseList = commonService.getCourseList();
            redisTemplate.opsForValue().set(REDIS_KEY_WX_COURSE_LIST,JSON.toJSON(courseList).toString());
            return AjaxResult.success(courseList);
        }catch (Exception e){
            logger.error(e.getMessage());
            return AjaxResult.error("请求失败"+e.getMessage());
        }
    }
}
