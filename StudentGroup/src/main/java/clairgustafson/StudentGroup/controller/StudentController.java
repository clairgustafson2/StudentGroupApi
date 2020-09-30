package clairgustafson.StudentGroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import clairgustafson.StudentGroup.entity.Student;
import clairgustafson.StudentGroup.service.StudentService;

@RestController
@RequestMapping("teachers/{id}/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student){
		return new ResponseEntity<Object>(service.createStudent(student), HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getStudents(){
		return new ResponseEntity<Object>(service.getStudents(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateStudent(student, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update student", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable Long id) {
		try {
			service.removeStudent(id);
			return new ResponseEntity<Object>("Successfully deleted student with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete student.", HttpStatus.BAD_REQUEST);
		}
	}
}
