package com.cg.trg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.trg.entity.PatientHistory;
import com.cg.trg.exception.HSMException;
import com.cg.trg.service.MapValidationErrorService;
import com.cg.trg.service.PatientHistoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api
@RestController
@RequestMapping("/api")

public class PatientHistoryController {
	
	@Autowired
	private PatientHistoryService patientHistoryService;	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
      
	
	@ApiOperation(value = "Add patient History",
			      response=PatientHistory.class,
			      consumes="PatientHistory Object",
			      tags="Post PatientHistory Record",
			      httpMethod="POST")
	
	@PostMapping("/PatientHistory")
	public ResponseEntity<PatientHistory> addPatientHistory( @RequestBody PatientHistory patientHistory) {
		try {
			PatientHistory patientHistory1 = patientHistoryService.addPatientHistory(patientHistory);
			return new ResponseEntity<PatientHistory>(patientHistory1, HttpStatus.OK);	
		}
		catch(HSMException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	
	@ApiOperation(value=" Get All Patient Histories",
			       response=PatientHistory.class,
			       tags="Get All Patient Histories",
			       httpMethod="GET")
	
	@GetMapping("/all")
	public Iterable<PatientHistory> getAllPatientHistories() {
		try {
			return patientHistoryService.getAllPatientHistories();
		}
		catch(HSMException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@ApiOperation(value="delete Patient History",
		       response=PatientHistory.class,
		       consumes="PatientId",
		       tags="Delete Patient History record",
		       httpMethod="DELETE")
	
	@DeleteMapping("/deletehistory/{patientId}")
	public ResponseEntity<?> deletePatient(@PathVariable int patientId) {
		try {
			 patientHistoryService.deletePatientHistoryById(patientId);
				return new ResponseEntity<String>("Project with id : "+patientId+" deleted successfully.",HttpStatus.OK);
		}
		catch(HSMException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		  	}
	
	
	@ApiOperation(value="Update Patient History",
		       response=PatientHistory.class,
		       consumes="PatientId",
		       tags="Update Patient Case record",
		       httpMethod="PUT")
	
	@PutMapping("/updatehistory/{patientId}")
	public void updatePatientHistoryById( @RequestBody PatientHistory patientHistory ,@PathVariable int patientId){
		try {
			patientHistoryService.updatePatientHistory(patientId,patientHistory);
		}
		catch(HSMException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
		

	@ApiOperation(value=" Get All Patient History Id",
			       response=PatientHistory.class,
			       tags="Get All Patient Histories",
			       httpMethod="GET")
	
	@GetMapping("/historyid/{historyId}")
	public ResponseEntity<PatientHistory> getPatientHistoryByHistoryId(@PathVariable int historyId){
		try {
			PatientHistory project = patientHistoryService.findPatientHistoryByHistoryId(historyId);
			return new ResponseEntity<PatientHistory>(project, HttpStatus.OK);
		}
		catch(HSMException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
//	@ApiOperation(value=" Get All Patient Id",
//		       response=PatientHistory.class,
//		       tags="Get All Patient Histories",
//		       httpMethod="GET")
//	
//	@GetMapping("/patientid/{patientId}")
//	public ResponseEntity<?> getPatientHistoryByPatientId(@PathVariable Integer patientId){
//		try {
//			PatientHistory project = patientHistoryService.findPatientHistoryByPatientId(patientId);
//			return new ResponseEntity<PatientHistory>(project, HttpStatus.OK);
//		}
//	
//	catch(HSMException e) {
//		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//	}
//		}
}