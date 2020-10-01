package com.clairgustafson.StudentGroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clairgustafson.StudentGroup.entity.Groups;
import com.clairgustafson.StudentGroup.service.GroupsService;

@RestController
@RequestMapping("teacher/{id}/groups")
public class GroupsController {
	
	@Autowired
	private GroupsService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createGroup(@RequestBody Groups groups){
		return new ResponseEntity<Object>(service.createGroup(groups), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{groupId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateGroup(@RequestBody Groups groups, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateGroup(groups, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update group", HttpStatus.BAD_REQUEST);
		}
	}

}
