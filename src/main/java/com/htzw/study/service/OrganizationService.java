package com.htzw.study.service;

import com.htzw.study.dto.OrganizationDto;
import com.htzw.study.entities.Organization;

import java.util.List;

/**
* @Description:    组织机构服务接口层
* @Author:         glj
* @CreateDate:     2018/11/27 12:22
* @Version:        1.0
*/
public interface OrganizationService {
    /**
     * 获取所有的组织机构信息
     * @return
     */
    List<Organization> list();
    /**
     * 获取所有可用组织机构的编号和名称
     * @return
     */
    List<OrganizationDto> getAllOrganIdAndName();

    /**
     * 根据组织机构编号获取对应的组织机构对象
     * @param orgId 组织机构编号
     * @return
     */
    Organization getOrganizationByPrimaryKey(Integer orgId);
}
