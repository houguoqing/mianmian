package com.kkb.mm.wx.service;

import com.kkb.pojo.TCourse;
import com.kkb.pojo.TDict;

import java.util.List;

/**
 * 公共业务接口
 * */
public interface CommonService {

    /**
     * 根据城市名称获取城市信息
     * @param cityName
     * @return
     * */
    TDict findDictByCityName(String cityName);

    /**
     * 根据fs值获取城市列表
     * @param fs
     * @return
     * */
    List<TDict> findDictListByFs(Integer fs);

    /**
     * 获取学科列表
     * @return
     * */
    List<TCourse> getCourseList();
}
