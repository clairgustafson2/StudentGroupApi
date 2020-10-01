package com.clairgustafson.StudentGroup.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairgustafson.StudentGroup.entity.Period;
import com.clairgustafson.StudentGroup.entity.Teacher;
import com.clairgustafson.StudentGroup.repository.PeriodRepo;
import com.clairgustafson.StudentGroup.repository.TeacherRepo;

@Service
public class PeriodService {
	
	private static final Logger logger = LogManager.getLogger(PeriodService.class);
	
	@Autowired
	private PeriodRepo repo;
	
	@Autowired
	private TeacherRepo teacherRepo;

	//GET by id
	public Period getPeriod(Long id) {
		return repo.findById(id).orElseThrow();
	}

	//GET all
	public Iterable<Period> getAllPeriods(){
		return repo.findAll();
	}

	//POST
	public Period createPeriod(Period period, Long teacherId) throws Exception {
		Teacher teacher = teacherRepo.findById(teacherId).orElseThrow();
		if (teacher == null) {
			throw new Exception("Teacher not found.");
		}
		period.setTeacher(teacher);
		return repo.save(period);
	}

	//UPDATE
	public Period updatePeriod(Period period, Long periodId) throws Exception{
		try {
			Period oldPeriod = repo.findById(periodId).orElseThrow();
			oldPeriod.setNumber(period.getNumber());
			oldPeriod.setName(period.getName());
			oldPeriod.setTeacher(period.getTeacher());
			return repo.save(oldPeriod);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update period" + periodId, e);
			throw new Exception("Unable to update period");
		}
	}

	
	//DELETE
	public void removePeriod(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete period:" + id, e);
			throw new Exception("Unable to delete period.");
		}
	}
}
