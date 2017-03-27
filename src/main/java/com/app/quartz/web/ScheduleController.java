package com.app.quartz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.utils.AjaxTool;
import com.app.quartz.bean.ScheduleJob;
import com.app.quartz.service.ScheduleService;

@Controller
@RequestMapping("schedule/")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;
	
	/**
	 * 查询所有的定时列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("showAllScheduleJob.html")
	public ModelAndView showAllScheduleJob(HttpServletRequest request, HttpServletResponse response){
		List<ScheduleJob> scheduleJobs = scheduleService.queryAllScheduleJob();
		request.setAttribute("scheduleJobs", scheduleJobs);
		return new ModelAndView("schedule/showAllScheduleJob");
	}
	/**
	 * 添加定时任务
	 * @param request
	 * @param response
	 */
	@RequestMapping("addScheduleJob.html")
	public void addScheduleJob(HttpServletRequest request, HttpServletResponse response){
		String jobId = request.getParameter("jobId");
		String result = scheduleService.addScheduleJob(jobId);
		AjaxTool.returnAjaxResponse(response, result);
	}
	/**
	 * 停止定时任务
	 * @param request
	 * @param response
	 */
	@RequestMapping("pauseScheduleJob.html")
	public void pauseScheduleJob(HttpServletRequest request, HttpServletResponse response){
		String jobId = request.getParameter("jobId");
		String result = scheduleService.pauseScheduleJob(jobId);
		AjaxTool.returnAjaxResponse(response, result);
	}
	/**
	 * 更新定时任务执行时间
	 * @param request
	 * @param response
	 */
	@RequestMapping("updateScheduleJob.html")
	public void updateScheduleJob(HttpServletRequest request, HttpServletResponse response){
		String jobId = request.getParameter("jobId");
		String cronExpression = request.getParameter("cronExpression");
		String result = scheduleService.updateScheduleJob(jobId,cronExpression);
		AjaxTool.returnAjaxResponse(response, result);
	}
	
	/**
	 * 恢复一个定时
	 * @param request
	 * @param response
	 */
	@RequestMapping("resumeScheduleJob.html")
	public void resumeScheduleJob(HttpServletRequest request, HttpServletResponse response){
		String jobId = request.getParameter("jobId");
		String result = scheduleService.resumeScheduleJob(jobId);
		AjaxTool.returnAjaxResponse(response, result);
	}
	
	/**
	 * 删除一个定时
	 * @param request
	 * @param response
	 */
	@RequestMapping("deleteScheduleJob.html")
	public void deleteScheduleJob(HttpServletRequest request, HttpServletResponse response){
		String jobId = request.getParameter("jobId");
		String result = scheduleService.deleteScheduleJob(jobId);
		AjaxTool.returnAjaxResponse(response, result);
	}
	/**
	 * 立即运行当前定时
	 * @param request
	 * @param response
	 */
	@RequestMapping("runScheduleJobNow.html")
	public void runScheduleJobNow(HttpServletRequest request, HttpServletResponse response){
		String jobId = request.getParameter("jobId");
		String result = scheduleService.runScheduleJobNow(jobId);
		AjaxTool.returnAjaxResponse(response, result);
	}
	
	/**
	 * 添加定时页面
	 * @param request
	 * @param response
	 */
	@RequestMapping("addNewScheduleJobPage.html")
	public ModelAndView addNewScheduleJobPage(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("schedule/addNewScheduleJobPage");
	}
	
	/**
	 * 添加定时
	 * @param request
	 * @param response
	 */
	@RequestMapping("addNewScheduleJob.html")
	public ModelAndView addNewScheduleJob(HttpServletRequest request, HttpServletResponse response,ScheduleJob job){
		String result = scheduleService.addNewScheduleJob(job);
		request.setAttribute("result", result);
		request.setAttribute("returnUrl", "schedule/showAllScheduleJob.html");
		return new ModelAndView("common/result");
	}
}
