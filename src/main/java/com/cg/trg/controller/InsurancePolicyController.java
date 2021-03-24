package com.cg.trg.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.cg.trg.entity.InsurancePolicy;
import com.cg.trg.exception.HealthServiceException;
import com.cg.trg.service.InsurancePolicyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class InsurancePolicyController {

	@Autowired
	InsurancePolicyService insurancePolicyService;

	@ApiOperation(value = "Get all policies",
			response=InsurancePolicy.class,
			tags="get-all-policies",
			httpMethod="GET")

	@GetMapping("/policies/all")
	public ResponseEntity<List<InsurancePolicy>> getAllPolicies() throws HealthServiceException {
		List<InsurancePolicy> policyList=insurancePolicyService.getAllPolicies(); 
		return new ResponseEntity<>(policyList,HttpStatus.OK);
	}
	@ApiOperation(value="Create policies",
			response=InsurancePolicy.class,
			tags="create-policies",
			consumes="InsuracePolicy Object",
			httpMethod="POST")

	//@PostMapping("/policies")
	@PostMapping(consumes = "application/json", produces = "application/json", path = "/policies")
	public ResponseEntity<InsurancePolicy> createPolicy( @RequestBody InsurancePolicy insurancePolicy)throws HealthServiceException {
	System.out.println("INSURANCE POLICY => "+insurancePolicy);
 	return new ResponseEntity<>(insurancePolicyService.createPolicy(insurancePolicy),HttpStatus.CREATED);
	}
		
	@ApiOperation(value="Update policies",
			response=InsurancePolicy.class,
			tags="update-policies",
			consumes="PolicyId",
			httpMethod="PUT")

	@PutMapping(consumes ="application/json", produces = "application/json",path="/policies/{policyName}")  
	public InsurancePolicy updatePolicy(@PathVariable String policyName, @Valid @RequestBody InsurancePolicy policyDetails) throws 
	HealthServiceException{
		  
			return insurancePolicyService.updatePolicy(policyName, policyDetails);
		}
		
	/*
	 * try { InsurancePolicy pol=
	 * insurancePolicyService.updatePolicy(insurancePolicy); return new
	 * ResponseEntity<>(pol, HttpStatus.OK); }catch(HealthServiceException e) {
	 * throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }
	 */
	@ApiOperation(value="Delete policies",
			response=String.class,
			consumes="policyId",
			tags="deletes policy from record",
			httpMethod="DELETE")

	@DeleteMapping("/policies/{policyId}")
	public ResponseEntity<String>deletePolicyById(@PathVariable Long policyId ) {
		try {
			insurancePolicyService.deletePolicyById(policyId);
			return new ResponseEntity<>("Policy deleted", HttpStatus.OK);
		}catch(HealthServiceException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@ApiOperation(value="Get policy by Id",
			response=InsurancePolicy.class,
			tags="get-policy-by-id",
			consumes="policyId",
			httpMethod="GET")
	@GetMapping("/policies/{policyId}")
	public ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable Long policyId) {
		try {
			InsurancePolicy policy=insurancePolicyService.getPolicyById(policyId);
			return new ResponseEntity<>(policy, HttpStatus.OK);
		}
		catch(HealthServiceException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}

