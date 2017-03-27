package com.app.quartz.bean;


/**
 * 定时任务
 * @author xxn
 * @date 2017年1月4日  下午2:49:52
 */
public class ScheduleJob{
	private long jobId;// 任务id
	private String jobName;// 任务名
	private String jobGroup;// 任务组
	private int jobStatus;// 任务状态   0禁用 1启用 2：暂停
	private String cronExpression;// 任务运行时间表达式
    private String targetMethod;//任务方法 
    private int isSpringBean;//是否是Spring中定义的Bean 1:是，0：否
    private String clazz;//如果isSpringBean = 0需要设置全类名,测试CLAZZ字段需要配置 
    private boolean concurrent;//是否并发 false禁用 true启用
    private String childJobs;//一系列的子任务,逗号分开,表示该任务执行完，之后需要执行的任务
    private String description; // 描述
    private String createTime;//创建时间
    
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public int getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(int jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTargetMethod() {
		return targetMethod;
	}
	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
	public int getIsSpringBean() {
		return isSpringBean;
	}
	public void setIsSpringBean(int isSpringBean) {
		this.isSpringBean = isSpringBean;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	public boolean isConcurrent() {
		return concurrent;
	}
	public void setConcurrent(boolean concurrent) {
		this.concurrent = concurrent;
	}
	public String getChildJobs() {
		return childJobs;
	}
	public void setChildJobs(String childJobs) {
		this.childJobs = childJobs;
	}
	
}
