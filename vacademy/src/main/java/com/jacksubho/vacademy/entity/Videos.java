package com.jacksubho.vacademy.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Videos extends AbstractEntity {

	private String name;
	@Lob
	private byte[] video;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Instructor instructor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
