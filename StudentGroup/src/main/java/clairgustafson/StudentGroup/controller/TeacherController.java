package clairgustafson.StudentGroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import clairgustafson.StudentGroup.entity.Teacher;
import clairgustafson.StudentGroup.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody Teacher teacher) {
		return new ResponseEntity<Object>(service.createTeacher(teacher), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody Teacher teacher) {
		try {
			return new ResponseEntity<Object>(service.login(teacher), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object> (e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
