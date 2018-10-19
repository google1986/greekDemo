package com.htzw.study.service;

import com.htzw.study.entities.WorkLog;

import java.util.List;

/**
* @Description:    工作日报接口层
* @Author:         glj
* @CreateDate:     2018/10/19
* @Version:        1.0
*/
public interface WorkLogService {
    /**
     * 获取所有的工作日报信息
     * @return
     */
    List<WorkLog> list();

    /**
     * 更新工作日报信息
     * @param workLog 工作日报对象
     * @return
     */
    boolean modifyWorkLog(WorkLog workLog);
    /**
     * 添加工作日报信息
     * @param workLog 工作日报对象
     * @return
     */
    boolean addWorkLog(WorkLog workLog);

    /**
     * 根据工作日报编号获取工作日报信息
     * @param workLogId 工作日报编号
     * @return
     */
    WorkLog queryWorkLogById(Integer workLogId);

    /**
     * 根据周数和用户编号来获取相应的工作日报信息
     * @param week 周数
     * @param userId 用户编号
     * @return
     */
    List<WorkLog> queryWorkLogByWeek(String week, Integer userId);

    /**
     * 根据起始时间和用户编号来获取符合条件的工作日报信息
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param userId 用户编号
     * @return
     */
    List<WorkLog> queryWorkLogByTimes(String startDate, String endDate, Integer userId);
}
