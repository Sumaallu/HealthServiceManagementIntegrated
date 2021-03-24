package com.cg.trg.dao;

import java.util.Optional;

//import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
//import javax.transaction.Transactional;

/*
 * This interface creates a Insurance Policy repository of a patient
 * @author win
 */
import org.springframework.stereotype.Repository;
import com.cg.trg.entity.InsurancePolicy;
import com.cg.trg.entity.Patient;


@Repository
public interface InsurancePolicyDAO extends JpaRepository<InsurancePolicy,Long> {

	public InsurancePolicy findByPolicyName(String policyName);


	//@Transactional
	//public void deletePolicyById(Long policyId);
	//@Transactional
	//public InsurancePolicy findByPatientIdentifier(String patientIdentifier);
	//public InsurancePolicy findById(Long policyId);
	
}