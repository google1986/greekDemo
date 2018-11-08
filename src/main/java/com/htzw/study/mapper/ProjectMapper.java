package com.htzw.study.mapper;

import com.htzw.study.entities.Project;

import java.util.List;
/**
* @Description:    java类作用描述
* @Author:         glj
* @CreateDate:     2018/9/28 10:28
* @Version:        1.0
*/
public interface ProjectMapper {
    /**
     * 根据项目编号删除对应的项目对象信息
     * @param projectId 项目编号
     * @return
     */
    int deleteByPrimaryKey(Integer projectId);

    /**
     * 插入项目对象信息
     * @param record 项目对象实例
     * @return
     */
    int insert(Project record);

    /**
     * 根据项目编号获取对象的项目信息
     * @param projectId 项目编号
     * @return
     */
    Project selectByPrimaryKey(Integer projectId);

    /**
     * 获取所有的项目信息
     * @return
     */
    List<Project> selectAll();

    /**
     * 更新项目信息
     * @param record 项目对象
     * @return
     */
    int updateByPrimaryKey(Project record);
}