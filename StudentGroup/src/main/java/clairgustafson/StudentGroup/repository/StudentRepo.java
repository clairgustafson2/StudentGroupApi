package clairgustafson.StudentGroup.repository;

import org.springframework.data.repository.CrudRepository;

import clairgustafson.StudentGroup.entity.Student;

public interface StudentRepo extends CrudRepository <Student, Long> {

}
