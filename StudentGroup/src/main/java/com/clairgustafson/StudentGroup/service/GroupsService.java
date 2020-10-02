package com.clairgustafson.StudentGroup.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairgustafson.StudentGroup.entity.Groups;
import com.clairgustafson.StudentGroup.entity.Student;
import com.clairgustafson.StudentGroup.repository.GroupsRepo;
import com.clairgustafson.StudentGroup.repository.StudentRepo;

@Service
public class GroupsService {
	
	private static final Logger logger = LogManager.getLogger(GroupsService.class);
	
	@Autowired
	private GroupsRepo repo;
	
	@Autowired
	private StudentRepo studentRepo;
	

	//POST
	//Need to add collections.shuffle(students)
	public Groups createGroup(Set<Long> studentIds, Long id) throws Exception {
		try {
			Groups group = initializeNewGroup(studentIds);
			return repo.save(group);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to create new group.", e);
			throw e;
		}
	}
	

	private Groups initializeNewGroup(Set<Long> studentIds) {
		Groups group = new Groups();
		group.setStudents(convertToStudentList(studentRepo.findAllById(studentIds)));
		group.setStartDate(LocalDate.now());
		addGroupToStudents(group);
		return group;
	}


	private void addGroupToStudents(Groups group) {
		List<Student> students = group.getStudents();
		for (Student student : students) {
			student.getGroups().add(group);
		}
	}

	private List<Student> convertToStudentList(Iterable<Student> iterable) {
		List<Student> list = new ArrayList<Student>();
		for (Student student : iterable) {
			list.add(student);
		}
		return list;
	}


	//DELETE
	public void removeGroups(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete groups:" + id, e);
			throw new Exception("Unable to delete groups.");
		}
	}


}
