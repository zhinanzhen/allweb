package com.app.quartz.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.app.quartz.bean.ScheduleJob;
import com.app.quartz.core.ScheduleJobFactory;
import com.app.quartz.dao.ScheduleMapper;
import com.app.quartz.vo.ResultVo;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleJobFactory scheduleJobFactory;
	@Autowired
	private ScheduleMapper scheduleMapper;

	/**
	 * 查询所有定时列表
	 * @return
	 */
	public List<ScheduleJob> queryAllScheduleJob() {
		return scheduleMapper.queryAllScheduleJob();
	}

	/**
	 * 添加新的定时任务（只有禁用的任务才可以重新添加）
	 * @param jobId
	 * @return
	 */
	public String addScheduleJob(String jobId) {
		ScheduleJob scheduleJob = scheduleMapper.queryScheduleJobById(Double.valueOf(jobId));
		JSONObject json = new JSONObject();
		if(scheduleJob == null){
			json.put("flag", "参数错误，任务不存在");
			return json.toJSONString();
		}
		if(0 != scheduleJob.getJobStatus()){
			json.put("flag", "任务为状态错误，不能添加任务");
			return json.toJSONString();
		}
		scheduleJob.setJobStatus(1);
		// 更新状态为启用
		int updateScheduleJob = scheduleMapper.updateScheduleJob(scheduleJob);
		if(updateScheduleJob != 1){
			json.put("flag", "数据更新失败");
			return json.toJSONString();
		}
		ResultVo resultVo = scheduleJobFactory.addNewScheduleJob(scheduleJob);
		if(!resultVo.isResult()){
			json.put("flag", resultVo.getFailReason());
			return json.toJSONString();
		}
		json.put("flag", "1");
		return json.toJSONString();
	}

	/**
	 * 停止定时任务
	 * @param jobId
	 * @return
	 */
	public String pauseScheduleJob(String jobId) {
		ScheduleJob scheduleJob = scheduleMapper.queryScheduleJobById(Double.valueOf(jobId));
		JSONObject json = new JSONObject();
		if(scheduleJob == null){
			json.put("flag", "参数错误，任务不存在");
			return json.toJSONString();
		}
		if(1 != scheduleJob.getJobStatus()){
			json.put("flag", "当前任务没有启动，不停止任务");
			return json.toJSONString();
		}
		scheduleJob.setJobStatus(2);
		// 停止任务
		int updateScheduleJob = scheduleMapper.updateScheduleJob(scheduleJob);
		if(updateScheduleJob != 1){
			json.put("flag", "数据更新失败");
			return json.toJSONString();
		}
		ResultVo resultVo = scheduleJobFactory.pauseScheduleJob(scheduleJob);
		if(!resultVo.isResult()){
			json.put("flag", resultVo.getFailReason());
			return json.toJSONString();
		}
		json.put("flag", "1");
		return json.toJSONString();
	}

	/**
	 * 更新定时任务执行时间
	 * @param jobId
	 * @param cronExpression
	 * @return
	 */
	public String updateScheduleJob(String jobId, String cronExpression) {
		ScheduleJob scheduleJob = scheduleMapper.queryScheduleJobById(Double.valueOf(jobId));
		JSONObject json = new JSONObject();
		if(scheduleJob == null){
			json.put("flag", "参数错误，任务不存在");
			return json.toJSONString();
		}
		if(0 == scheduleJob.getJobStatus()){
			json.put("flag", "任务为禁用状态，不能更新任务时间");
			return json.toJSONString();
		}
		if(cronExpression.equalsIgnoreCase(scheduleJob.getCronExpression())){
			json.put("flag", "时间表达式没变，无需更新");
			return json.toJSONString();
		}
		scheduleJob.setCronExpression(cronExpression);
		// 更新时间
		int a = scheduleMapper.updateScheduleJob(scheduleJob);
		if( a != 1 ){
			json.put("flag", "任务为更新失败，数据保存失败");
			return json.toJSONString();
		}
		// 更新时间
		ResultVo resultVo = scheduleJobFactory.updateScheduleJobCron(scheduleJob);
		if(!resultVo.isResult()){
			json.put("flag", resultVo.getFailReason());
			return json.toJSONString();
		}
		json.put("flag", "1");
		return json.toJSONString();
	}

	/**
	 * 恢复一个定时
	 * @param jobId
	 * @return
	 */
	public String resumeScheduleJob(String jobId) {
		ScheduleJob scheduleJob = scheduleMapper.queryScheduleJobById(Double.valueOf(jobId));
		JSONObject json = new JSONObject();
		if(scheduleJob == null){
			json.put("flag", "参数错误，任务不存在");
			return json.toJSONString();
		}
		if(2 != scheduleJob.getJobStatus()){
			json.put("flag", "任务为状态错误，不能恢复任务");
			return json.toJSONString();
		}
		scheduleJob.setJobStatus(1);
		int updateScheduleJob = scheduleMapper.updateScheduleJob(scheduleJob);
		if(updateScheduleJob != 1){
			json.put("flag", "数据更新失败");
			return json.toJSONString();
		}
		ResultVo resultVo = scheduleJobFactory.resumeScheduleJob(scheduleJob);
		if(!resultVo.isResult()){
			json.put("flag", resultVo.getFailReason());
			return json.toJSONString();
		}
		json.put("flag", "1");
		return json.toJSONString();
	}

	/**
	 * 删除一个定时
	 * @param jobId
	 * @return
	 */
	public String deleteScheduleJob(String jobId) {
		ScheduleJob scheduleJob = scheduleMapper.queryScheduleJobById(Double.valueOf(jobId));
		JSONObject json = new JSONObject();
		if(scheduleJob == null){
			json.put("flag", "参数错误，任务不存在");
			return json.toJSONString();
		}
		if(0 == scheduleJob.getJobStatus()){
			json.put("flag", "任务为删除状态，不能删除");
			return json.toJSONString();
		}
		scheduleJob.setJobStatus(0);
		int updateScheduleJob = scheduleMapper.updateScheduleJob(scheduleJob);
		if(updateScheduleJob != 1){
			json.put("flag", "数据更新失败");
			return json.toJSONString();
		}
		ResultVo resultVo = scheduleJobFactory.deleteScheduleJob(scheduleJob);
		if(!resultVo.isResult()){
			json.put("flag", resultVo.getFailReason());
			return json.toJSONString();
		}
		json.put("flag", "1");
		return json.toJSONString();
	}

	/**
	 * 立即运行当前定时任务
	 * @param jobId
	 * @return
	 */
	public String runScheduleJobNow(String jobId) {
		ScheduleJob scheduleJob = scheduleMapper.queryScheduleJobById(Double.valueOf(jobId));
		JSONObject json = new JSONObject();
		if(scheduleJob == null){
			json.put("flag", "参数错误，任务不存在");
			return json.toJSONString();
		}
		if(0 == scheduleJob.getJobStatus()){
			json.put("flag", "任务为禁用状态，不能删除");
			return json.toJSONString();
		}
		ResultVo resultVo = scheduleJobFactory.runScheduleJobNow(scheduleJob);
		if(!resultVo.isResult()){
			json.put("flag", resultVo.getFailReason());
			return json.toJSONString();
		}
		json.put("flag", "1");
		return json.toJSONString();
	}

	/**
	 * 添加新的定时任务
	 * @param job
	 * @return
	 */
	public String addNewScheduleJob(ScheduleJob job) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdate = sdf.format(date);
		job.setCreateTime(sdate);
		int num = scheduleMapper.addScheduleJob(job);
		if(num == 0){
			return "数据保存失败";
		}
		ResultVo resultVo = scheduleJobFactory.addNewScheduleJob(job);
		if(!resultVo.isResult()){
			return resultVo.getFailReason();
		}
		return "1";
	}

}
