package com.htzw.study.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 组织机构实体类
 * @author glj
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Organization implements Serializable{
    /**
     * 机构编号
     */
    private Integer orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 父机构编号
     */
    private Integer parentOrgId;
    /**
     * 机构编码
     */
    private String orgCode;
    /**
     * 是否为叶子节点
     */
    private Boolean leaf;
    /**
     * 状态（1：表示正常、可用；0：表示已删除、禁用）
     */
    private Integer status;
    /**
     * 更新时间
     */
    private String updateDate;
}