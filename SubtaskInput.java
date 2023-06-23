package com.nkxgen.spring.orm.model;

import java.sql.Date;

public class SubtaskInput {

	private Integer taskId;
	private Integer subtaskId;
	private String subtaskDescription;
	private Double numberOfHours;
	private Date creationDate;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getSubtaskId() {
		return subtaskId;
	}

	public void setSubtaskId(Integer subtaskId) {
		this.subtaskId = subtaskId;
	}

	public String getSubtaskDescription() {
		return subtaskDescription;
	}

	public void setSubtaskDescription(String subtaskDescription) {
		this.subtaskDescription = subtaskDescription;
	}

	public Double getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(Double numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Subtask toEntity() {
		Subtask subtask = new Subtask();

		SubtaskPrimaryKey primaryKey = new SubtaskPrimaryKey();
		primaryKey.setTaskId(this.taskId);
		primaryKey.setSubtaskId(this.subtaskId);
		subtask.setPrimaryKey(primaryKey);

		subtask.setSubtaskDescription(this.subtaskDescription);
		subtask.setNumberOfHours(this.numberOfHours);
		subtask.setCreationDate(this.creationDate);

		return subtask;
	}

}
