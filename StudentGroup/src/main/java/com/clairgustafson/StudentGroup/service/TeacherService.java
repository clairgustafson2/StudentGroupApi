package com.clairgustafson.StudentGroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairgustafson.StudentGroup.entity.Teacher;
import com.clairgustafson.StudentGroup.repository.TeacherRepo;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepo repo;
	
	public Teacher createTeacher(Teacher teacher) {
		return repo.save(teacher);
	}
	
	public Teacher login(Teacher teacher) throws Exception{
		Teacher foundTeacher = repo.findByEmail(teacher.getEmail());
		if (foundTeacher != null && foundTeacher.getPassword().equals(teacher.getPassword())) {
			return foundTeacher;
		} else {
			throw new Exception("Invalid email or password");
		}
	}
	
}
