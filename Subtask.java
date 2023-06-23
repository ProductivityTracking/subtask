package com.nkxgen.spring.orm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t4_subtask")
public class Subtask {

	@EmbeddedId
	private SubtaskPrimaryKey primaryKey;

	@Column(name = "subtask_description")
	private String subtaskDescription;

	@Column(name = "number_of_hours")
	private Double numberOfHours;

	@Column(name = "creation_date")
	private Date creationDate;

	// Constructors, getters, and setters

	public SubtaskPrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(SubtaskPrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
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

}
