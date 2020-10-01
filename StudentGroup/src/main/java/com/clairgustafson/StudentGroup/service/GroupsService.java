package com.clairgustafson.StudentGroup.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairgustafson.StudentGroup.entity.Groups;
import com.clairgustafson.StudentGroup.repository.GroupsRepo;

@Service
public class GroupsService {
	
	private static final Logger logger = LogManager.getLogger(GroupsService.class);
	
	@Autowired
	private GroupsRepo repo;

	
	
	//POST
	public Groups createGroup(Groups groups) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//UPDATE
		public Groups updateGroup(Groups groups, Long id) {
			// TODO Auto-generated method stub
			return null;
		}


}
