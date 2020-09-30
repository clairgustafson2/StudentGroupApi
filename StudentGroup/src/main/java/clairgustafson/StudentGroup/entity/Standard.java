package clairgustafson.StudentGroup.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Standard {
	
	private Long id;
	private String subject;
	private String state;
	private String code;
	private String description;
	
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
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "group_standard",
			joinColumns = @JoinColumn(name = "standardId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "groupId", referencedColumnName = "id"))
	public Set<Groups> getGroup() {
		return group;
	}

	public void setGroup(Set<Groups> group) {
		this.group = group;
	}

}
