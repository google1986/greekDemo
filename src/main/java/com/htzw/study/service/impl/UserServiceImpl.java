package com.htzw.study.service.impl;

import com.htzw.study.dao.UserMapper;
import com.htzw.study.entities.User;
import com.htzw.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:    用户服务实现层
* @Author:         glj
* @CreateDate:     2018/10/4
* @Version:        1.0
*/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String userName, String password) {
        User user = userMapper.selectUserByUserNameAndPwd(userName, password);
        if (user != null){
            return true;
        }else {
            return false;
        }
    }
}
