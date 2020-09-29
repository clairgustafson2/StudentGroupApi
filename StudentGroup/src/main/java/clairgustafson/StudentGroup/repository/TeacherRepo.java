package clairgustafson.StudentGroup.repository;

import org.springframework.data.repository.CrudRepository;

import clairgustafson.StudentGroup.entity.Teacher;

public interface TeacherRepo extends CrudRepository <Teacher, Long> {
	
	public Teacher findByEmail(String email);

}
