package com.htzw.study.service.impl;

import com.htzw.study.dao.ProjectMapper;
import com.htzw.study.entities.Project;
import com.htzw.study.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:    项目信息Service实现层
* @Author:         glj
* @CreateDate:     2018/9/28 16:50
* @Version:        1.0
*/
@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public List<Project> list() {
        return projectMapper.selectAll();
    }

    @Override
    public Project getProjectByPrimaryKey(Integer projectId) {
        return projectMapper.selectByPrimaryKey(projectId);
    }

    @Override
    public boolean modifyProject(Project project) {
        int num = projectMapper.updateByPrimaryKey(project);
        if (num > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addProject(Project project) {
        int num = projectMapper.insert(project);
        if (num > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Project queryProjectById(Integer projectId) {
        return projectMapper.selectByPrimaryKey(projectId);
    }
}
