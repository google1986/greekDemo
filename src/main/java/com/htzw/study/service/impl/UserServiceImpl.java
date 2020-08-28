package com.htzw.study.service.impl;

import com.htzw.study.mapper.UserMapper;
import com.htzw.study.dto.UserDto;
import com.htzw.study.entities.User;
import com.htzw.study.service.UserService;
import com.htzw.study.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        UserDto user = userMapper.selectUserByUserNameAndPwd(userName, password);
        return user != null;
    }

    @Override
    public UserDto queryUserByUserNameAndPassword(String userName, String password) {
        return userMapper.selectUserByUserNameAndPwd(userName, password);
    }

    @Override
    public User queryUserByUserId(Integer userId) {
        if (userId != null){
            return userMapper.selectByPrimaryKey(userId);
        }
        return null;
    }

    @Override
    public boolean modifyUser(User user) {
        int num = userMapper.updateByPrimaryKey(user);
        return num > 0;
    }
    @Override
    public boolean addUser(String userName, String trueName, String password, Integer orgId, String registerDate, String remark) {
        User user = new User(userName,trueName,password,orgId,1, TimeUtils.dateToString(new Date()),remark);
        user.setRoleType("使用人员");
        int num = userMapper.insert(user);
        return num > 0;
    }
}
