package clairgustafson.StudentGroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import clairgustafson.StudentGroup.entity.Period;
import clairgustafson.StudentGroup.service.PeriodService;

@RestController
@RequestMapping("/teachers/{teacherId}/periods")
public class PeriodController {
	
	@Autowired
	private PeriodService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllperiods(){
		return new ResponseEntity<Object>(service.getAllPeriods(), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/{periodId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getPeriod(@PathVariable Long periodId) {
		return new ResponseEntity<Object>(service.getPeriod(periodId), HttpStatus.OK);
	}

	@RequestMapping(value="/{periodId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updatePeriod(@RequestBody Period period, @PathVariable Long periodId) {
		try {
			return new ResponseEntity<Object> (service.updatePeriod(period, periodId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createPost(@RequestBody Period period, @PathVariable Long teacherId) {
		try {
			return new ResponseEntity<Object> (service.createPeriod(period, teacherId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object> (e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{periodId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletePeriod(@PathVariable Long id) {
		try {
			service.removePeriod(id);
			return new ResponseEntity<Object>("Successfully deleted period with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete period.", HttpStatus.BAD_REQUEST);
		}
	}

}
