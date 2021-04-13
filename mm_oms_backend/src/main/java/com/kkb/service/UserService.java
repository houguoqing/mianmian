package com.kkb.service;

import com.kkb.pojo.TUser;

/**
 * 用户业务接口
*/
public interface UserService {
    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     * */
    TUser findByUserName(String userName);
}
