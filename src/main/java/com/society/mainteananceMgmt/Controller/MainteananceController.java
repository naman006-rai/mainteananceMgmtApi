package com.society.mainteananceMgmt.Controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.society.mainteananceMgmt.Model.MainteanceInfo;
import com.society.mainteananceMgmt.Service.MainteananceService;

@RestController 
public class MainteananceController {
	
	@Autowired
	private MainteananceService service;
	
	@PostMapping("/insert")
	public ResponseEntity<MainteanceInfo> insertResident(@RequestBody MainteanceInfo mainteanceInfo) {

		MainteanceInfo response = service.insertResident(mainteanceInfo);

		try{
			return new ResponseEntity<MainteanceInfo>(response, HttpStatus.CREATED);
		}
		catch(ServiceException dataAlreadyExistsException ){
			return new ResponseEntity("Exception Occured", HttpStatus.CONFLICT);
		}

	}
	
	@GetMapping("/mainteance/{owner}")
	public ResponseEntity getDatabyName(@PathVariable (required= true) String owner ) {
		try{
			return new ResponseEntity(service.getDatabyOwner(owner), HttpStatus.OK);
		}
		catch(ServiceException dataNotFoundException ){
			return new ResponseEntity(dataNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/mainteance/{owner}/{status}")
	public ResponseEntity<MainteanceInfo> updateStatus(@PathVariable (required= true)String owner ,@PathVariable(required= true) String status) {
		MainteanceInfo response= service.updateStatus(owner,status);
		
		try{
			return new ResponseEntity<MainteanceInfo>(response, HttpStatus.CREATED);
		}
		catch(ServiceException dataNotFoundException ){
			return new ResponseEntity(dataNotFoundException.getMessage(), HttpStatus.CONFLICT);
		}

	}
	
	@DeleteMapping("/mainteance/{owner}")
	public ResponseEntity deletebyOwner(@PathVariable (required= true) String owner ) {
		try{
			return new ResponseEntity(service.deleteByOwner(owner), HttpStatus.OK);
		}
		catch(ServiceException dataNotFoundException ){
			return new ResponseEntity(dataNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/")
	public ResponseEntity deleteAll() {
		try{
			return new ResponseEntity(service.deleteAll(), HttpStatus.OK);
		}
		catch(ServiceException dataNotFoundException ){
			return new ResponseEntity(dataNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}

	}


}
