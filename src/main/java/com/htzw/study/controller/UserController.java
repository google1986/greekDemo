package com.htzw.study.controller;

import com.htzw.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:    用户信息控制层
* @Author:         glj
* @CreateDate:     2018/10/4
* @Version:        1.0
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 验证用户登录信息
     * @param userName 用户名称
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Map<String,Object> login(String userName, String password){
        Map<String,Object> map = new HashMap<>(2);
        map.put("success",userService.login(userName,password));
        return map;
    }
}
