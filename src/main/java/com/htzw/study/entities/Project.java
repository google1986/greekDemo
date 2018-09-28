package com.htzw.study.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* @Description:    java类作用描述
* @Author:         glj
* @CreateDate:     2018/9/28 10:26
* @Version:        1.0
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project implements Serializable{

    /**
     * 编号
     */
    private Integer projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     *项目描述
     */
    private String projectSummary;
    /**
     *项目类型
     */
    private String projectType;
    /**
     *汇报人
     */
    private String reporter;
    /**
     *状态（1表示正常，0表示删除）
     */
    private Integer status;
    /**
     *更新时间
     */
    private String updateDate;
    /**
     *备注
     */
    private String remark;
}