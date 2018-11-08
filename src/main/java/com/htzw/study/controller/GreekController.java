package com.htzw.study.controller;

import com.htzw.study.entities.Project;
import com.htzw.study.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/27.
 * @author glj
 */

@RestController
public class GreekController {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello Greek!";
    }
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public Map<String,Object> getList(){
        Map<String,Object> map = new HashMap<>(2);
        List<Project> res = projectService.list();
        map.put("projectList",res);
        return map;
    }
}
