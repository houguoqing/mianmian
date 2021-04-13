package com.kkb.service.impl;

import com.kkb.mapper.TUserMapper;
import com.kkb.pojo.TUser;
import com.kkb.pojo.TUserExample;
import com.kkb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser findByUserName(String userName) {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<TUser> userList = userMapper.selectByExample(example);
        //用户不为空的时候,第一个用户就是要查询的用户
        if(!userList.isEmpty()){
            return userList.get(0);
        }
        return null;
    }
}
