package com.htzw.study.service;

import com.htzw.study.dto.UserDto;
import com.htzw.study.entities.User;

/**
* @Description:    用户接口层
* @Author:         glj
* @CreateDate:     2018/10/4
* @Version:        1.0
*/
public interface UserService {
    /**
     * 根据用户名称和密码验证用户信息
     * @param userName 用户名称
     * @param password 密码
     * @return 是否登陆成功
     */
    boolean login(String userName, String password);
    /**
     * 根据用户名称和密码获取用户信息
     * @param userName 用户名称
     * @param password 密码
     * @return 用户对象
     */
    UserDto queryUserByUserNameAndPassword(String userName, String password);

    /**
     * 根据用户编号获取用户信息
     * @param userId 用户编号
     * @return
     */
    User queryUserByUserId(Integer userId);

    /**
     * 更新用户信息
     * @param user 用户对象
     * @return
     */
    boolean modifyUser(User user);

    /**
     * 添加用户信息
     * @param userName 登录名称
     * @param trueName 真实名称
     * @param password 密码
     * @param orgId 机构编号
     * @param registerDate 注册日期
     * @param remark 备注
     * @return
     */
    boolean addUser(String userName, String trueName, String password,Integer orgId,String registerDate,String remark);
}
