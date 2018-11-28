package com.htzw.study.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* @Description:    工作日志/日报实体类
* @Author:         glj
* @CreateDate:     2018/10/15 16:11
* @Version:        1.0
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkLog implements Serializable{
    /**
     * 编号
     */
    private Integer workId;
    /**
     * 工作内容
     */
    private String workContent;
    /**
     * 开始时间
     */
    private String startDate;
    /**
     * 结束时间
     */
    private String endDate;
    /**
     * 关联的项目
     */
    private Integer projectId;
    /**
     * 关联的用户
     */
    private Integer userId;
    /**
     * 状态（1：表示可用、正常；0表示已删除）
     */
    private Integer status;
    /**
     * 工作总结、经验教训
     */
    private String workSummary;
    /**
     * 年份
     */
    private String year;
    /**
     * 月份
     */
    private String month;
    /**
     * 周
     */
    private String week;
    /**
     * 更新时间
     */
    private String updateDate;

    public WorkLog(String workContent, String startDate, String endDate, Integer projectId, Integer userId, String workSummary) {
        this.workContent = workContent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectId = projectId;
        this.userId = userId;
        this.workSummary = workSummary;
    }
}