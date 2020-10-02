package com.clairgustafson.StudentGroup.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clairgustafson.StudentGroup.service.GroupsService;

@RestController
@RequestMapping("teacher/{id}/groups")
public class GroupsController {
	
	@Autowired
	private GroupsService service;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createGroup(@RequestBody Set<Long> studentIds, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.createGroup(studentIds, id), HttpStatus.CREATED);
		} catch (Exception e){	
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value="/{groupsId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteGroups(@PathVariable Long id) {
		try {
			service.removeGroups(id);
			return new ResponseEntity<Object>("Successfully deleted groups with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to groups period.", HttpStatus.BAD_REQUEST);
		}
	}

}
