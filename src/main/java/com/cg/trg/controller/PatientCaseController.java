package com.cg.trg.controller;
import java.util.List;


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

import com.cg.trg.entity.PatientCase;
import com.cg.trg.exception.PatientCaseNotFoundException;
import com.cg.trg.service.MapValidationErrorService;
import com.cg.trg.service.PatientCaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/api")
public class PatientCaseController {
	
	@Autowired
	private PatientCaseService patientCaseService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@ApiOperation(value = "AddpatientCase",
			       response=PatientCase.class,
			       consumes="PatientCase Object",
			       tags="Post PatientCase Record",
			       httpMethod = "POST")
	
	@PostMapping("/PatientCase")
	public ResponseEntity<PatientCase> addPatientCase(@RequestBody PatientCase patientcase){
		try {
			PatientCase patientcases=patientCaseService.addPatientCase(patientcase);
			return new ResponseEntity<PatientCase>(patientcases,HttpStatus.OK);
		}
		catch(PatientCaseNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		}
	
	@ApiOperation(value = "Get All Patient Case Id",
			      response=PatientCase.class,
			      tags="Get All Patient Cases",
			      httpMethod = "GET")
	
	@GetMapping("/patientcaseid/{patientcaseId}")
	public ResponseEntity<PatientCase> getAllPatientByPatientCaseId(@PathVariable Integer patientcaseId) {
		try {
		PatientCase patientCases =  patientCaseService.findPatientByPatientCaseId(patientcaseId);
		return new ResponseEntity<PatientCase>(patientCases, HttpStatus.OK);
	}
		catch(PatientCaseNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@ApiOperation(value = "Get All Patient Cases",
			      response=PatientCase.class,
			      tags="Get All Patient Cases",
			      httpMethod = "GET")
	
	@GetMapping("/getAllPatientCases")
	public ResponseEntity<List<PatientCase>> getAllPatientCases() {
		try {
		List<PatientCase> patients = (List<PatientCase>) patientCaseService.getAllPatientCases();
		return new ResponseEntity<List<PatientCase>>(patients, HttpStatus.OK);
	}
		catch(PatientCaseNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@ApiOperation(value = "Get All Patient Diseases",
			response=PatientCase.class,
			tags="Get All Patient Diseses",
			httpMethod="GET")
	
	@GetMapping("/getAll/{disease}")
	public ResponseEntity<List<PatientCase>> getAllPatientDetailsByDisease(@PathVariable String disease) {
		try {
		List<PatientCase> patients = (List<PatientCase>) patientCaseService.getAllPatientDetailsByDisease(disease);
		return new ResponseEntity<List<PatientCase>>(patients, HttpStatus.OK);
	}
		catch(PatientCaseNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		}
	
//	@ApiOperation(value = "Get All Patient by Date",
//		      response=PatientCase.class,
//		      tags="Get All Patient Cases",
//		      httpMethod = "GET")
//
//   @GetMapping("/{patientbyDate}")
//  public ResponseEntity<PatientCase> getAllPatientByDate(@PathVariable Integer Date) {
//	try {
//	PatientCase patientCases =  patientCaseService.findPatientByPatientCaseId(Date);
//	return new ResponseEntity<PatientCase>(patientCases, HttpStatus.OK);
//}
//	catch(PatientCaseNotFoundException e) {
//		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//	}
//}
	
	
	@ApiOperation(value="update Patient Case",
			      response=PatientCase.class,
			      consumes="PatientCase Object",
			      tags="Update Patient Case record",
			      httpMethod="PUT")
	
	@PutMapping("/{patientId}")
	public ResponseEntity<PatientCase> updatePatientCaseById(@RequestBody PatientCase patientCaseId){
		try {
			 patientCaseService.updatePatientCase(patientCaseId);
			 return new ResponseEntity<PatientCase>(patientCaseId, HttpStatus.OK);
		}
		catch(PatientCaseNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	    
	}
	
	@ApiOperation(value="delete Patient Case",
			       response=PatientCase.class,
			       consumes="PatientCaseId",
			       tags="Delete Patient Case record",
			       httpMethod="DELETE")
	
	@DeleteMapping("/{patientCaseId}")
	public ResponseEntity<?> deletePatientCase(@PathVariable int patientCaseId) {
		try {
		   patientCaseService.deletePatientCaseById(patientCaseId);
		return new ResponseEntity<String>("Project with id : "+patientCaseId+" deleted successfully.",HttpStatus.OK);
	}
	catch(PatientCaseNotFoundException e) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
	}
}