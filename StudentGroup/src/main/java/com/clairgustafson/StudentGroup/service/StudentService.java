package com.clairgustafson.StudentGroup.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairgustafson.StudentGroup.entity.Student;
import com.clairgustafson.StudentGroup.repository.StudentRepo;

@Service
public class StudentService {
	
private static final Logger logger = LogManager.getLogger(StudentService.class);
	
	@Autowired
	private StudentRepo repo;
	
	//GET
	public Iterable<Student> getStudents(){
		return repo.findAll();
	}
	
	//POST
	public Student createStudent(Student student) {
		return repo.save(student);
	}
	

	//UPDATE
	public Student updateStudent(Student student, Long id) throws Exception{
		try {
			Student oldStudent = repo.findById(id).orElseThrow();
			oldStudent.setFirstName(student.getFirstName());
			oldStudent.setLastName(student.getLastName());
			oldStudent.setPeriod(student.getPeriod());
			oldStudent.setLevel(student.getLevel());
			return repo.save(oldStudent);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update student" + id, e);
			throw new Exception("Unable to update student");
		}
	}

	//DELETE
	public void removeStudent(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete student:" + id, e);
			throw new Exception("Unable to delete student.");
		}
	}
}
