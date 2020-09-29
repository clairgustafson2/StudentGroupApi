package clairgustafson.StudentGroup.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import clairgustafson.StudentGroup.util.AcademicLevel;

@Entity
public class Student {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String period;
	private AcademicLevel level;
	
	
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
	
	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}
	
	public AcademicLevel getLevel() {
		return level;
	}
	
	public void setLevel(AcademicLevel level) {
		this.level = level;
	}

}
