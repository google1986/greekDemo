package com.htzw.study.service.impl;

import com.htzw.study.dto.OrganizationDto;
import com.htzw.study.entities.Organization;
import com.htzw.study.mapper.OrganizationMapper;
import com.htzw.study.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:    组织机构服务实现层
* @Author:         glj
* @CreateDate:     2018/11/27 12:24
* @Version:        1.0
*/
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;
    @Override
    public List<Organization> list() {
        return organizationMapper.selectAll();
    }

    @Override
    public List<OrganizationDto> getAllOrganIdAndName() {
        return organizationMapper.selectAllOrgIdAndName();
    }

    @Override
    public Organization getOrganizationByPrimaryKey(Integer orgId) {
        if (orgId == null){
            return null;
        }
        return organizationMapper.selectByPrimaryKey(orgId);
    }
}
