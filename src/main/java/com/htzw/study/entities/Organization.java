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

    private Integer orgId;
    private String orgName;
    private Integer parentOrgId;
    private String orgCode;
    private Boolean leaf;
    private Integer status;
    private String updateDate;
}