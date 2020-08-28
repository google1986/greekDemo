package com.htzw.study.service.impl;

import com.htzw.study.dto.ProjectDto;
import com.htzw.study.entities.Project;
import com.htzw.study.mapper.ProjectMapper;
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
    public List<ProjectDto> listIdAndName() {
        return projectMapper.selectAllProjectIdAndName();
    }

    @Override
    public Project getProjectByPrimaryKey(Integer projectId) {
        return projectMapper.selectByPrimaryKey(projectId);
    }

    @Override
    public boolean modifyProject(Project project) {
        int num = projectMapper.updateByPrimaryKey(project);
        return num > 0;
    }

    @Override
    public boolean addProject(Project project) {
        int num = projectMapper.insert(project);
        return num > 0;
    }

    @Override
    public boolean deleteProject(Project project) {
        int num = projectMapper.deleteByPrimaryKey(project.getProjectId());
        return num > 0;
    }

    @Override
    public Project queryProjectById(Integer projectId) {
        return projectMapper.selectByPrimaryKey(projectId);
    }

    @Override
    public boolean addBatchProject(Integer countNum) {
        projectMapper.insertBatchByProcedure(countNum);
        return true;
    }
}
