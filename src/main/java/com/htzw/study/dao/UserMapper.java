package com.htzw.study.dao;

import com.htzw.study.dto.UserPageModel;
import com.htzw.study.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
* @Description:    用户信息Mapper层
* @Author:         glj
* @CreateDate:     2018/10/4
* @Version:        1.0
*/
@Mapper
public interface UserMapper {
    /**
     * 根据用户编号删除相应的用户信息
     * @param userId 用户编号
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 插入用户信息
     * @param record 用户对象
     * @return
     */
    int insert(User record);

    /**
     * 根据主键获取相应的用户信息
     * @param userId 用户编号
     * @return
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * 获取所有的用户信息
     * @return
     */
    List<User> selectAll();

    /**
     * 更新用户信息
     * @param record 用户对象
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 注意：使用命名参数方式明确指定封装参数时map的key：@Param("userName")
     * 根据用户名称和密码获取相应的用户对象细腻些
     * @param userName 用户名称
     * @param password 密码
     * @return
     */
    UserPageModel selectUserByUserNameAndPwd(@Param("userName") String userName, @Param("password") String password);
}