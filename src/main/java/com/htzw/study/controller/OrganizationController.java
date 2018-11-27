package com.htzw.study.controller;

import com.htzw.study.dto.OrganizationDto;
import com.htzw.study.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    java类作用描述
* @Author:         glj
* @CreateDate:     2018/11/27 12:16
* @Version:        1.0
*/
@RestController
@RequestMapping("/org")
@Api(value = "组织机构信息操作接口",tags = {"Organization Controller"})
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @ApiOperation(value = "获取组织机构信息",notes = "获取所有可用的机构详细信息")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public Map<String,Object> getList(){
        Map<String,Object> map = new HashMap<>(2);
        List<OrganizationDto> res = organizationService.getAllOrganIdAndName();
        if (res != null && !res.isEmpty()){
            map.put("success",true);
            map.put("orgList",res);
        }else {
            map.put("success",false);
        }
        return map;
    }
}
