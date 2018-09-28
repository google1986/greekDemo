package com.htzw.study.service;

import com.htzw.study.entities.Project;

import java.util.List;

/**
 * Created by Administrator on 2018/9/28.
 */
public interface ProjectService {
    /**
     * 获取所有的项目信息
     * @return
     */
    List<Project> list();

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
}
