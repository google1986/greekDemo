package com.htzw.study.controller;

import com.htzw.study.entities.Project;
import com.htzw.study.service.ProjectService;
import com.htzw.study.utils.TimeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "项目信息操作接口",tags = {"项目信息操作接口"})
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    /**
     * 获取所有的项目信息
     * @return
     */
    @ApiOperation(value = "获取所有项目详细信息",notes = "获取所有可用的项目详细信息")
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
    @ApiOperation(value = "删除项目信息",notes = "根据项目编号删除对应的信息")
    @ApiImplicitParam(name = "projectId", value = "项目编号",required = true, paramType = "header", dataType = "Integer")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Map<String,Object> deleteProject(@RequestHeader Integer projectId){
        Map<String,Object> map = new HashMap<>(2);
        Project project = projectService.getProjectByPrimaryKey(projectId);
        if (project == null){
            map.put("success",false);
        }
//        project.setStatus(0);
//        project.setUpdateDate(TimeUtils.dateToString(new Date()));
        map.put("success",projectService.deleteProject(project));
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
    @ApiOperation(value = "更新项目", notes = "更新项目信息")
    @ApiImplicitParam(name = "project", value = "项目数据", required = true, paramType = "body", dataType = "Project")
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
    @ApiOperation(value = "获取项目信息",notes = "根据项目编号获取项目对象信息")
    @ApiImplicitParam(name = "projectId", value = "项目编号",required = true, paramType = "query",dataType = "Integer")
    @RequestMapping(value = "getProjectById",method = RequestMethod.GET)
    public Map<String,Object> getProjectById(@RequestParam Integer projectId){
        Map<String,Object> map = new HashMap<>(2);
        map.put("project",projectService.queryProjectById(projectId));
        return map;
    }
}
