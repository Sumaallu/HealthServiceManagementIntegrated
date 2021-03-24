package com.cg.trg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.trg.exception.HSMException;
import com.cg.trg.exception.PatientCaseNotFoundException;
import com.cg.trg.exception.PatientIdException;
import com.cg.trg.exception.UserNameException;
import com.cg.trg.entity.Finance;
import com.cg.trg.service.*;

@CrossOrigin(origins="http://localhost:8084")
@RestController
@RequestMapping("/api")
public class FinanceController {
	@Autowired
	private FinanceService financeService;

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/finance/{patientId}")
	public ResponseEntity<Finance> findByPatientId(@PathVariable Integer patientId){
		try {
			Finance finance = financeService.findByPatientId(patientId);
			return new ResponseEntity<>(finance, HttpStatus.OK);
		}catch(PatientIdException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	
	@PostMapping("/finance/add")
	public ResponseEntity<?> add(@RequestBody Finance finance) {
		System.out.println("FINANCE = "+ finance);
		try {
			Finance status= financeService.add(finance);
			return new ResponseEntity<>(status, HttpStatus.OK);
		}catch(HSMException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	@GetMapping("/finance")
	public ResponseEntity<List<Finance>> findAllFinancialDetais(@PathVariable Integer patientId){
		try {
			List<Finance> financeList = financeService.findAllFinancialDetails(patientId);
			return new ResponseEntity<>(financeList, HttpStatus.OK);
		}catch(PatientIdException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PutMapping("/finance")
	public ResponseEntity<String> update(@RequestBody Finance finance) {
		try {
			String status= financeService.update(finance);
			return new ResponseEntity<>(status, HttpStatus.OK);
		}catch(PatientCaseNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	
	
	@DeleteMapping("/finance/{financeId}")
	public ResponseEntity<?> deleteFinanceByFinanceId(@PathVariable Integer financeId) {
		try {
			String status= financeService.deleteFinanceByFinanceId(financeId);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		}catch(PatientCaseNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}


