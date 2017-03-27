package com.app.quartz.core;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.app.common.utils.SpringContextUtil;
import com.app.common.utils.ValidateUtils;
import com.app.quartz.bean.ScheduleJob;
import com.app.quartz.service.ScheduleService;
import com.app.quartz.vo.ResultVo;

@Service
public class ScheduleJobFactory {
	private static final Logger logger = Logger.getLogger(ScheduleJobFactory.class);
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	@Autowired
	private ScheduleService scheduleService;

	public void initTask() throws Exception {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		List<ScheduleJob> allJob = scheduleService.queryAllScheduleJob();
		if (ValidateUtils.isEmpty(allJob)) {
			logger.info("----------------定时列表为空------------------");
			return;
		}
		for (ScheduleJob job : allJob) {
			TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(),job.getJobGroup());
			// 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (trigger == null) {
				createJobDetail(scheduler, job);
			} else {
				updateScheduler(scheduler, job, triggerKey, trigger);
			}
		}
	}

	private void updateScheduler(Scheduler scheduler, ScheduleJob job,TriggerKey triggerKey, CronTrigger trigger)throws SchedulerException {
		if (job.getJobStatus() == 1 ) {
			if (!trigger.getCronExpression().equalsIgnoreCase(job.getCronExpression())) {
				// 表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
				// 按新的cronExpression表达式重新构建trigger
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				// 按新的trigger重新设置job执行
				scheduler.rescheduleJob(triggerKey, trigger);
				logger.info(job.getJobGroup() + "." + job.getJobName()
						+ " 更新完毕,目前cron表达式为:" + job.getCronExpression()
						+ " isSpringBean：" + job.getIsSpringBean()
						+ " concurrent: " + job.isConcurrent());
			}
		}else if (job.getJobStatus() == 2) {
			scheduler.pauseJob(trigger.getJobKey());// 暂停任务
			logger.info(job.getJobGroup() + "." + job.getJobName() + "暂停任务");
		}
	}

	private void createJobDetail(Scheduler scheduler, ScheduleJob job) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, NoSuchMethodException, SchedulerException {
		if (0 != job.getJobStatus()) {
			MethodInvokingJobDetailFactoryBean mJfb = new MethodInvokingJobDetailFactoryBean();
			mJfb.setGroup(job.getJobGroup());
			mJfb.setName(job.getJobName());
			if (1 == job.getIsSpringBean()) {
				mJfb.setTargetObject(SpringContextUtil.getApplicationContext().getBean(job.getClazz()));
			} else {
				mJfb.setTargetObject(Class.forName(job.getClazz()).newInstance());
			}
			mJfb.setTargetMethod(job.getTargetMethod());
			// 将管理Job类提交到计划管理类
			mJfb.afterPropertiesSet();
			mJfb.setConcurrent(job.isConcurrent());
			JobDetail jobDetail = mJfb.getObject();
			jobDetail.getJobDataMap().put("scheduleJob", job);
			// 表达式调度构建器
			CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
			// 按新的cronExpression表达式构建一个新的trigger
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(cronScheduleBuilder).build();
			if(1 == job.getJobStatus()){
				scheduler.scheduleJob(jobDetail, trigger);
			}else{
				scheduler.scheduleJob(jobDetail, trigger);
				scheduler.pauseJob(jobDetail.getKey());
			}
		}
	}

	/**
	 * 添加新的定时
	 * 
	 * @param job
	 * @return
	 */
	public ResultVo addNewScheduleJob(ScheduleJob job) {
		ResultVo vo = new ResultVo(false);
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		try {
			createJobDetail(scheduler, job);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | NoSuchMethodException
				| SchedulerException e) {
			logger.info("创建新定时失败，" + e.getMessage());
			vo.setFailReason("创建新定时失败，原因：" + e.getMessage());
			return vo;
		}
		vo.setResult(true);
		return vo;
	}

	/**
	 * 暂停一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
  	public ResultVo pauseScheduleJob(ScheduleJob scheduleJob) {
		ResultVo vo = new ResultVo(false);
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroup());
			scheduler.pauseJob(jobKey);
		} catch (Exception e) {
			logger.info("暂停定时失败，原因：" + e.getMessage());
			vo.setFailReason("暂停定时失败，原因：" + e.getMessage());
			return vo;
		}
		vo.setResult(true);
		return vo;
	}

	/**
	 * 恢复一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public ResultVo resumeScheduleJob(ScheduleJob scheduleJob) {
		ResultVo vo = new ResultVo(false);
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroup());
			scheduler.resumeJob(jobKey);
		} catch (Exception e) {
			logger.info("恢复定时失败，原因：" + e.getMessage());
			vo.setFailReason("恢复定时失败，原因：" + e.getMessage());
			return vo;
		}
		vo.setResult(true);
		return vo;
	}

	/**
	 * 删除一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public ResultVo deleteScheduleJob(ScheduleJob scheduleJob){
		ResultVo vo = new ResultVo(false);
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroup());
			scheduler.deleteJob(jobKey);
		} catch (Exception e) {
			logger.info("删除定时失败，原因：" + e.getMessage());
			vo.setFailReason("删除定时失败，原因：" + e.getMessage());
			return vo;
		}
		vo.setResult(true);
		return vo;
	}

	/**
	 * 立即执行job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public ResultVo runScheduleJobNow(ScheduleJob scheduleJob) {
		ResultVo vo = new ResultVo(false);
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroup());
			scheduler.triggerJob(jobKey);
		} catch (Exception e) {
			logger.info("立即执行定时失败，原因：" + e.getMessage());
			vo.setFailReason("立即执行定时失败，原因：" + e.getMessage());
			return vo;
		}
		vo.setResult(true);
		return vo;
	}
	
	/**
	 * 更新job时间表达式
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public ResultVo updateScheduleJobCron(ScheduleJob scheduleJob) {
		ResultVo vo = new ResultVo(false);
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(),scheduleJob.getJobGroup());
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			updateScheduler(scheduler, scheduleJob, triggerKey, trigger);
		} catch (Exception e) {
			vo.setFailReason("更新时间失败，原因：" + e.getMessage());
			logger.info("更新时间失败，原因：" + e.getMessage());
			return vo;
		}
		vo.setResult(true);
		return vo;
	}

}
