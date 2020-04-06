package com.jacksubho.vacademy.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Instructor extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String subject;
	private String phone;
	private String email;
	private String password;
	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Assignments> assignments;
	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Videos> videos;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Assignments> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignments> assignments) {
		this.assignments = assignments;
	}

	public Set<Videos> getVideos() {
		return videos;
	}

	public void setVideos(Set<Videos> videos) {
		this.videos = videos;
	}

}
