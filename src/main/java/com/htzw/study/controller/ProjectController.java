package com.htzw.study.controller;

import com.htzw.study.entities.Project;
import com.htzw.study.service.ProjectService;
import com.htzw.study.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    项目控制层
* @Author:         glj
* @CreateDate:     2018/9/28 10:54
* @Version:        1.0
*/
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    /**
     * 获取所有的项目信息
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public Map<String,Object> getList(){
        Map<String,Object> map = new HashMap<>(2);
        List<Project> res = projectService.list();
        map.put("projectList",res);
        return map;
    }

    /**
     * 根据编号删除相应的项目信息
     * @param projectId 项目编号
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Map<String,Object> deleteProject(Integer projectId){
        Map<String,Object> map = new HashMap<>(2);
        Project project = projectService.getProjectByPrimaryKey(projectId);
        if (project == null){
            map.put("success",false);
        }
        project.setStatus(0);
        project.setUpdateDate(TimeUtils.dateToString(new Date()));
        map.put("success",projectService.modifyProject(project));
        return map;
    }

    /**
     * 添加项目对象信息
     * @param project 项目对象
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Map<String,Object> addProject(@RequestBody Project project){
        Map<String,Object> map = new HashMap<>(2);
        project.setStatus(1);
        project.setReporter("谷连军");
        project.setUpdateDate(TimeUtils.dateToString(new Date()));
        map.put("success",projectService.addProject(project));
        return map;
    }
    /**
     * 更新项目对象信息
     * @param project 项目对象
     * @return
     */
    @RequestMapping(value = "modify",method = RequestMethod.POST)
    public Map<String,Object> modifyProject(@RequestBody Project project){
        Map<String,Object> map = new HashMap<>(2);
        Project currentProject = projectService.getProjectByPrimaryKey(project.getProjectId());
        if (currentProject == null){
            map.put("success",false);
            return map;
        }
        currentProject.setProjectName(project.getProjectName());
        currentProject.setProjectSummary(project.getProjectSummary());
        currentProject.setProjectType(project.getProjectType());
        map.put("success",projectService.modifyProject(currentProject));
        return map;
    }

    /**
     * 根据项目编号获取项目对象信息
     * @param projectId 项目编号
     * @return
     */
    @RequestMapping(value = "getProjectById",method = RequestMethod.GET)
    public Map<String,Object> getProjectById(Integer projectId){
        Map<String,Object> map = new HashMap<>(2);
        map.put("project",projectService.queryProjectById(projectId));
        return map;
    }
}
