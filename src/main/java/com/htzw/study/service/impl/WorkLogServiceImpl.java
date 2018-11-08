package com.htzw.study.service.impl;

import com.htzw.study.mapper.WorkLogMapper;
import com.htzw.study.entities.WorkLog;
import com.htzw.study.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
* @Description:    工作日报服务实现层
* @Author:         glj
* @CreateDate:     2018/10/20
* @Version:        1.0
*/
@Service
public class WorkLogServiceImpl implements WorkLogService{
    @Autowired
    private WorkLogMapper workLogMapper;

    @Override
    public List<WorkLog> list() {
        return workLogMapper.selectAll();
    }

    @Override
    public boolean modifyWorkLog(WorkLog workLog) {
        int num = workLogMapper.updateByPrimaryKey(workLog);
        return (num > 0) ? true : false;
    }

    @Override
    public boolean addWorkLog(WorkLog workLog) {
        int num = workLogMapper.insert(workLog);
        return (num > 0) ? true : false;
    }

    @Override
    public WorkLog queryWorkLogById(Integer workLogId) {
        return workLogMapper.selectByPrimaryKey(workLogId);
    }

    @Override
    public List<WorkLog> queryWorkLogByWeek(String week, Integer userId) {
        return workLogMapper.selectWorkLogByWeek(week, userId);
    }

    @Override
    public List<WorkLog> queryWorkLogByTimes(String startDate, String endDate, Integer userId) {
        return workLogMapper.selectWorkLogByTimes(startDate, endDate, userId);
    }
}
