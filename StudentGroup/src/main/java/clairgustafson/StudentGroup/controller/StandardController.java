package clairgustafson.StudentGroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import clairgustafson.StudentGroup.entity.Standard;
import clairgustafson.StudentGroup.service.StandardService;


@RestController
@RequestMapping("/standards")
public class StandardController {

	@Autowired
	private StandardService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getStandards(){
		return new ResponseEntity<Object>(service.getStandards(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createStandard(@RequestBody Standard standard){
		return new ResponseEntity<Object>(service.createStandard(standard), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateStandard(@RequestBody Standard standard, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateStandard(standard, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update standard", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStandard(@PathVariable Long id) {
		try {
			service.removeStandard(id);
			return new ResponseEntity<Object>("Successfully deleted standard with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete standard.", HttpStatus.BAD_REQUEST);
		}
	}
}
