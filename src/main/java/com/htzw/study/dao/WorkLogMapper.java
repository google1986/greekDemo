package com.htzw.study.dao;

import com.htzw.study.entities.WorkLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
* @Description:    工作日报接口层
* @Author:         glj
* @CreateDate:     2018/10/19
* @Version:        1.0
*/
@Mapper
public interface WorkLogMapper {
    /**
     * 根据日报编号删除对应的信息
     * @param workId 日报编号
     * @return
     */
    int deleteByPrimaryKey(Integer workId);

    /**
     * 插入日报信息
     * @param record 工作日报对象
     * @return
     */
    int insert(WorkLog record);

    /**
     * 根据日报编号获取对应的日报信息
     * @param workId 日报编号
     * @return
     */
    WorkLog selectByPrimaryKey(Integer workId);

    /**
     * 获取所有的日报信息
     * @return
     */
    List<WorkLog> selectAll();

    /**
     * 更新日报信息
     * @param record 日报对象
     * @return
     */
    int updateByPrimaryKey(WorkLog record);

    /**
     * 根据周数和用户编号来获取相应的工作日报信息
     * @param week 周数
     * @param userId 用户编号
     * @return
     */
    List<WorkLog> selectWorkLogByWeek(@Param("week") String week,@Param("userId") Integer userId);
    /**
     * 根据起始时间和用户编号来获取符合条件的工作日报信息
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param userId 用户编号
     * @return
     */
    List<WorkLog> selectWorkLogByTimes(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("userId") Integer userId);
}