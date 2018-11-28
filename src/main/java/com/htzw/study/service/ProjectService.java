package com.htzw.study.service;

import com.htzw.study.dto.ProjectDto;
import com.htzw.study.entities.Project;

import java.util.List;

/**
* @Description:    项目服务接口层
* @Author:         glj
* @CreateDate:     2018/10/4
* @Version:        1.0
*/
public interface ProjectService {
    /**
     * 获取所有的项目信息
     * @return
     */
    List<Project> list();

    /**
     * 获取所有的项目编号和名称信息
     * @return
     */
    List<ProjectDto> listIdAndName();

    /**
     * 根据项目编号获取对应的项目对象
     * @param projectId 项目编号
     * @return
     */
    Project getProjectByPrimaryKey(Integer projectId);

    /**
     * 更新项目信息
     * @param project 项目对象
     * @return
     */
    boolean modifyProject(Project project);
    /**
     * 添加项目信息
     * @param project 项目对象
     * @return
     */
    boolean addProject(Project project);

    /**
     * 删除项目信息
     * @param project 项目对象
     * @return
     */
    boolean deleteProject(Project project);
    /**
     * 根据项目编号获取项目信息
     * @param projectId 项目编号
     * @return
     */
    Project queryProjectById(Integer projectId);

    /**
     * 批量插入项目信息
     * @param countNum 项目总条数
     * @return
     */
    boolean addBatchProject(Integer countNum);
}
