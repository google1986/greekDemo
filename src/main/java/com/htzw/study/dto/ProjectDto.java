package com.htzw.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:    项目信息前台下拉框模型
 * @Author:         glj
 * @CreateDate:     2018/11/27 12:38
 * @Version:        1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDto implements Serializable{
    /**
     * 编号
     */
    private Integer projectId;
    /**
     * 项目名称
     */
    private String projectName;
}
