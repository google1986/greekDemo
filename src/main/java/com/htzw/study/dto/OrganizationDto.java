package com.htzw.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
* @Description:    java类作用描述
* @Author:         glj
* @CreateDate:     2018/11/27 12:38
* @Version:        1.0
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrganizationDto implements Serializable{
    /**
     * 机构编号
     */
    private Integer orgId;
    /**
     * 机构名称
     */
    private String orgName;
}
