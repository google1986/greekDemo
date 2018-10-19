package com.htzw.study.controller;

import com.htzw.study.entities.WorkLog;
import com.htzw.study.service.WorkLogService;
import com.htzw.study.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    工作日报控制层
* @Author:         glj
* @CreateDate:     2018/10/20
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/work")
public class WorkLogController {
    @Autowired
    private WorkLogService workLogService;
    /**
     * 获取所有的工作日报信息
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public Map<String,Object> getList(){
        Map<String,Object> map = new HashMap<>(2);
        List<WorkLog> res = workLogService.list();
        map.put("workLogList",res);
        return map;
    }

    /**
     * 根据用户编号和周数来获取相应的工作日报信息
     * @param week 周数
     * @param userId 用户编号
     * @return
     */
    @RequestMapping(value = "getWorkByWeek",method = RequestMethod.GET)
    public Map<String,Object> getWorkByWeek(String week, Integer userId){
        Map<String,Object> map = new HashMap<>(2);
        List<WorkLog> res = workLogService.queryWorkLogByWeek(week, userId);
        map.put("workLogList",res);
        return map;
    }
    /**
     * 根据用户编号和周数来获取相应的工作日报信息
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param userId 用户编号
     * @return1
     */
    @RequestMapping(value = "getWorkByTimes",method = RequestMethod.GET)
    public Map<String,Object> getWorkByTimes(String startDate, String endDate, Integer userId){
        Map<String,Object> map = new HashMap<>(2);
        List<WorkLog> res = workLogService.queryWorkLogByTimes(startDate, endDate, userId);
        map.put("workLogList",res);
        return map;
    }
    /**
     * 根据编号删除相应的工作日报信息
     * @param workLogId 工作日报编号
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Map<String,Object> deleteWorkLog (Integer workLogId){
        Map<String,Object> map = new HashMap<>(2);
        WorkLog  workLog = workLogService.queryWorkLogById(workLogId);
        if (workLog == null){
            map.put("success",false);
        }
        workLog.setStatus(0);
        workLog.setUpdateDate(TimeUtils.dateToString(new Date()));
        map.put("success",workLogService.modifyWorkLog (workLog));
        return map;
    }

    /**
     * 添加工作日报对象信息
     * @param workLog 工作日报对象
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Map<String,Object> addWorkLog (@RequestBody WorkLog  workLog){
        Map<String,Object> map = new HashMap<>(2);
        workLog.setStatus(1);
        workLog.setUpdateDate(TimeUtils.dateToString(new Date()));
        map.put("success",workLogService.addWorkLog (workLog));
        return map;
    }
    /**
     * 更新工作日报对象信息
     * @param workLog 工作日报对象
     * @return
     */
    @RequestMapping(value = "modify",method = RequestMethod.POST)
    public Map<String,Object> modifyWorkLog (@RequestBody WorkLog  workLog){
        Map<String,Object> map = new HashMap<>(2);
        WorkLog  currentWorkLog  = workLogService.queryWorkLogById(workLog.getWorkId());
        if (currentWorkLog  == null){
            map.put("success",false);
            return map;
        }
        //TODO 待确定界面后完善
        map.put("success",workLogService.modifyWorkLog (currentWorkLog ));
        return map;
    }

    /**
     * 根据工作日报编号获取工作日报对象信息
     * @param workLogId 工作日报编号
     * @return
     */
    @RequestMapping(value = "getWorkLogById",method = RequestMethod.GET)
    public Map<String,Object> getWorkLogById(Integer workLogId){
        Map<String,Object> map = new HashMap<>(2);
        map.put("workLog",workLogService.queryWorkLogById(workLogId));
        return map;
    }
}
