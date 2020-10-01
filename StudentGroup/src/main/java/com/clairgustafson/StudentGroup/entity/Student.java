package com.clairgustafson.StudentGroup.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.clairgustafson.StudentGroup.util.AcademicLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	
	private Long id;
	private String firstName;
	private String lastName;
	private Period period;
	private AcademicLevel level;
	
	@JsonIgnore
	private Teacher teacher;
	
	@JsonIgnore
	private Set<Groups> group;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	public Period getPeriod() {
		return period;
	}
	
	public void setPeriod(Period period) {
		this.period = period;
	}
	
	public AcademicLevel getLevel() {
		return level;
	}
	
	public void setLevel(AcademicLevel level) {
		this.level = level;
	}

	@ManyToMany(mappedBy = "student")
	public Set<Groups> getGroup() {
		return group;
	}

	public void setGroup(Set<Groups> group) {
		this.group = group;
	}

	@ManyToOne
	@JoinColumn(name = "teacherId")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
