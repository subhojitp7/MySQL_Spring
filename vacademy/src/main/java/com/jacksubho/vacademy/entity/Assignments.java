package com.jacksubho.vacademy.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Assignments extends AbstractEntity {

	private String name;
	@Lob
	private byte[] assignment;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Instructor instructor;
	private String details;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getAssignment() {
		return assignment;
	}

	public void setAssignment(byte[] assignment) {
		this.assignment = assignment;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
