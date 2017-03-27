package com.app.quartz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.quartz.bean.ScheduleJob;

/**
 * @author xxn
 * @date 2017年1月9日  下午5:18:43
 */
@Repository
public interface ScheduleMapper {

	/**
	 * 查询所有的定时任务列表
	 * @return
	 */
	List<ScheduleJob> queryAllScheduleJob();
	
	/**
	 * 根据id查找定时任务
	 * @param jobId
	 * @return
	 */
	ScheduleJob queryScheduleJobById(Double jobId);

	/**
	 * 更新定时任务
	 * @param scheduleJob
	 * @return
	 */
	int updateScheduleJob(ScheduleJob scheduleJob);

	/**
	 * 添加新的定时任务
	 * @param job
	 * @return
	 */
	int addScheduleJob(ScheduleJob job);

}
