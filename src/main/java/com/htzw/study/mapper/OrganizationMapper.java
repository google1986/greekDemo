package com.htzw.study.mapper;

import com.htzw.study.dto.OrganizationDto;
import com.htzw.study.entities.Organization;

import java.util.List;

/**
* @Description:    机构mapper接口
* @Author:         glj
* @CreateDate:     2018/10/19
* @Version:        1.0
*/
public interface OrganizationMapper {
    /**
     * 根据机构编号删除对应的机构信息
     * @param orgId 机构编号
     * @return
     */
    int deleteByPrimaryKey(Integer orgId);

    /**
     * 插入机构信息
     * @param record 机构对象
     * @return
     */
    int insert(Organization record);

    /**
     * 根据机构编号获取对应的机构信息
     * @param orgId 机构编号
     * @return
     */
    Organization selectByPrimaryKey(Integer orgId);

    /**
     * 获取所有的机构信息
     * @return
     */
    List<Organization> selectAll();
    /**
     * 获取所有可用的机构编号和名称
     * @return
     */
    List<OrganizationDto> selectAllOrgIdAndName();

    /**
     * 更新机构信息
     * @param record 机构对象
     * @return
     */
    int updateByPrimaryKey(Organization record);
}