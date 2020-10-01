package com.clairgustafson.StudentGroup.repository;

import org.springframework.data.repository.CrudRepository;

import com.clairgustafson.StudentGroup.entity.Student;

public interface StudentRepo extends CrudRepository <Student, Long> {

}
