package com.cg.trg.service;

	import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;
import com.cg.trg.entity.InsurancePolicy;
import com.cg.trg.entity.Patient;
import com.cg.trg.exception.HealthServiceException;

	public interface InsurancePolicyService {

		public InsurancePolicy createPolicy( InsurancePolicy insurancePolicy) throws HealthServiceException ;
		public List<InsurancePolicy> getAllPolicies() throws HealthServiceException;
		public void deletePolicyById(Long policyId) throws HealthServiceException;
      //public InsurancePolicy updatePolicy(Long policyId, @Valid InsurancePolicy policyDetails)
				//throws HealthServiceException;
	  //	public InsurancePolicy getPolicyById(Long policyId) throws HealthServiceException;
		//InsurancePolicy findById(Long policyId);
		//InsurancePolicy updatePolicy(InsurancePolicy insurancePolicy) throws HealthServiceException;
		InsurancePolicy getPolicyById(Long policyId) throws HealthServiceException;
		//InsurancePolicy updatePolicy(Long policyId, @Valid InsurancePolicy policyDetails) throws HealthServiceException;
		InsurancePolicy updatePolicy(String policyName, @Valid InsurancePolicy policyDetails)
				throws HealthServiceException;
		
	}