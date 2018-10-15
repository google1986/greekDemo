package com.htzw.study.controller;

import com.htzw.study.entities.User;
import com.htzw.study.service.UserService;
import com.htzw.study.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test() throws InterruptedException {
        User user = userService.queryUserByUserId(1);
        System.out.println(user.getTrueName());
        System.out.println("=======================================================");
        System.out.println(user.getOrg().getOrgName());
        return "test";
    }
    /**
     * 验证用户登录信息
     * @param userName 用户名称
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public Map<String,Object> login(String userName, String password){
        Map<String,Object> map = new HashMap<>(2);
        User user = userService.queryUserByUserNameAndPassword(userName,password);
        if (user == null){
            map.put("success",false);
            return map;
        }
        map.put("success",true);
        map.put("userInfo",user);
        return map;
    }
    /**
     * 修改用户密码信息
     * @param userId 用户编号
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map<String,Object> modifyUser(Integer userId, String password){
        Map<String,Object> map = new HashMap<>(2);
        if (userId == null || password == null){
            map.put("success",false);
            return map;
        }
        User currentUser = new User(userId,password);
        currentUser.setUpdateDate(TimeUtils.dateToString(new Date()));
        map.put("success",userService.modifyUser(currentUser));
        return map;
    }
}
