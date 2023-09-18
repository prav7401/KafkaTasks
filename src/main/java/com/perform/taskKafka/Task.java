package com.perform.taskKafka;


import java.util.Date;

																
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Task {
	
	private String taskId;
	private String taskName;
	private Date taskStartDt;
	private Date taskEndDt;
	private String taskStatus;
	

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getTaskStartDt() {
		return taskStartDt;
	}

	public void setTaskStartDt(Date taskStartDt) {
		this.taskStartDt = taskStartDt;
	}

	public Date getTaskEndDt() {
		return taskEndDt;
	}

	public void setTaskEndDt(Date taskEndDt) {
		this.taskEndDt = taskEndDt;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	
	
	@Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskStartDt=" + taskStartDt +
                ", taskEndDt=" + taskEndDt +
                ", taskStatus='" + taskStatus + '\'' +
                '}';
    }
}
