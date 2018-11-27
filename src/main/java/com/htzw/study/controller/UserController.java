package com.htzw.study.controller;

import com.htzw.study.dto.UserDto;
import com.htzw.study.entities.User;
import com.htzw.study.service.UserService;
import com.htzw.study.utils.TimeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@Api(value = "用户信息操作接口",tags = {"User Controller"})
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "验证用户登录",notes = "验证用户登录信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "登录用户名",required = true, paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",required = true, paramType = "query",dataType = "String")
    })
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Map<String,Object> login(HttpServletRequest request, String userName, String password){
        Map<String,Object> map = new HashMap<>(2);
        UserDto user = userService.queryUserByUserNameAndPassword(userName,password);
        if (user == null){
            map.put("success",false);
            return map;
        }
        HttpSession session = request.getSession();
        session.setAttribute("userInfo",user);
        map.put("success",true);
        map.put("userInfo",user);
        return map;
    }

    @ApiOperation(value = "退出",notes = "用户注销")
    @RequestMapping(value = "loginOut",method = RequestMethod.GET)
    public Map<String,Object> loginOut(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>(2);
        HttpSession session = request.getSession();
        if (session != null){
            session.setAttribute(session.getId(),null);
        }
        map.put("success",true);
        return map;
    }

    @ApiOperation(value = "修改密码",notes = "修改用户密码信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号",required = true, paramType = "header", dataType = "int"),
            @ApiImplicitParam(name = "password", value = "密码",required = true, paramType = "header",dataType = "String")
    })
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map<String,Object> modifyUser(@RequestHeader Integer userId, @RequestHeader String password){
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
    @ApiOperation(value = "注册用户",notes = "注册用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "登录用户名",required = true, paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "trueName", value = "真实名称",required = true, paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",required = true, paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "orgId", value = "机构编号",required = true, paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "registerDate", value = "注册日期",required = true, paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "备注",required = true, paramType = "query",dataType = "String")
    })
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public Map<String,Object> register(String userName, String trueName, String password,Integer orgId,String registerDate,String remark){
        Map<String,Object> map = new HashMap<>(2);
        map.put("success",userService.addUser(userName,trueName,password,orgId,registerDate,remark));
        return map;
    }
}
