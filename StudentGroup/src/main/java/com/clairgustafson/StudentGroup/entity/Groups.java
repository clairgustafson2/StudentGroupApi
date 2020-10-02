package com.clairgustafson.StudentGroup.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Groups {
	
	private Long id;
	private String name;
	private LocalDate startDate;
	private List<Student> students;
	private Standard standard;
	private Period period;
	
	@JsonIgnore
	private Teacher teacher;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn (name = "standardId")
	public Standard getStandard() {
		return standard;
	}
	
	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable (name = "groups_student",
			joinColumns = @JoinColumn(name = "groupsId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "studentId", referencedColumnName = "id"))
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	@ManyToOne
	@JoinColumn(name = "periodId")
	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
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
