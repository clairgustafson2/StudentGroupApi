package com.clairgustafson.StudentGroup.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairgustafson.StudentGroup.entity.Standard;
import com.clairgustafson.StudentGroup.repository.StandardRepo;

@Service
public class StandardService {
	
	private static final Logger logger = LogManager.getLogger(StandardService.class);
	
	@Autowired
	private StandardRepo repo;

	//POST
	public Standard createStandard(Standard standard) {
		return repo.save(standard);
	}

	//GET
	public Iterable<Standard> getStandards(){
		return repo.findAll();
	}
	
	//UPDATE
	public Standard updateStandard(Standard standard, Long id) throws Exception{
		try {
			Standard oldStandard = repo.findById(id).orElseThrow();
			oldStandard.setSubject(standard.getSubject());
			oldStandard.setState(standard.getState());
			oldStandard.setCode(standard.getCode());
			oldStandard.setDescription(standard.getDescription());
			return repo.save(oldStandard);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update product" + id, e);
			throw new Exception("Unable to update product");
		}
	}
	
	//DELETE
	public void removeStandard(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete standard:" + id, e);
			throw new Exception("Unable to delete standard.");
		}
	}

}
