package co.com.mundocostenio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mundocostenio.domain.Tutor;
import co.com.mundocostenio.services.TutorService;

@RestController
public class TutorController {
	
	@Autowired
	private TutorService tutorService;
	
	@RequestMapping(
			value ="/tutor/{tutorId}", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Tutor> selectTutorById(@PathVariable int tutorId){
		HttpHeaders headers = new HttpHeaders();
		Tutor tutorResult = this.tutorService.selectTutorById(tutorId);
		
		return new ResponseEntity<Tutor>(tutorResult, headers, HttpStatus.OK);
		
	}

}
