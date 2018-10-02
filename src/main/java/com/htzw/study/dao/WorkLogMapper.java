package com.htzw.study.dao;

import com.htzw.study.entities.WorkLog;
import java.util.List;

public interface WorkLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_log
     *
     * @mbggenerated Fri Sep 28 10:18:38 CST 2018
     */
    int deleteByPrimaryKey(Integer workId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_log
     *
     * @mbggenerated Fri Sep 28 10:18:38 CST 2018
     */
    int insert(WorkLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_log
     *
     * @mbggenerated Fri Sep 28 10:18:38 CST 2018
     */
    WorkLog selectByPrimaryKey(Integer workId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_log
     *
     * @mbggenerated Fri Sep 28 10:18:38 CST 2018
     */
    List<WorkLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_log
     *
     * @mbggenerated Fri Sep 28 10:18:38 CST 2018
     */
    int updateByPrimaryKey(WorkLog record);
}