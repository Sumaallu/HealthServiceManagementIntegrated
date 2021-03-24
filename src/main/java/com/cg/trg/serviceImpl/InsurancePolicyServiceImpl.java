package com.cg.trg.serviceImpl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
//import javax.transaction.Propagation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.trg.dao.InsurancePolicyDAO;
//import com.cg.trg.dao.PatientDAO;
import com.cg.trg.entity.InsurancePolicy;
import com.cg.trg.entity.Patient;
import com.cg.trg.exception.HealthServiceException;
import com.cg.trg.service.InsurancePolicyService;

@Service
//@Transactional(propagation = Propagation.NESTED)
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	@Autowired
	private InsurancePolicyDAO insurancePolicyDAO;

	//@Autowired
	//private PatientDAO patientDAO;
	@Override
	public List<InsurancePolicy> getAllPolicies() throws HealthServiceException{
		try{
			List<InsurancePolicy> policylist = (List<InsurancePolicy>) insurancePolicyDAO.findAll();
			if (policylist.size() > 0) {
				return policylist;
			} else {
				return null;}
		}
		catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HealthServiceException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HealthServiceException(e.getMessage());
		}


	}

	@Override
	public InsurancePolicy createPolicy(InsurancePolicy insurancePolicy)throws HealthServiceException {
		try { return insurancePolicyDAO.save(insurancePolicy);
		}catch(DataAccessException e) {
			//converting SQLException to HealthServiceException 
			throw new  HealthServiceException(e.getMessage()); 
		}
		catch(Exception e) { 
			//converting SQLException to HealthServiceExceptionException
			throw new HealthServiceException(e.getMessage()); }


	}

	/*
	 * @Override public InsurancePolicy createPolicy(InsurancePolicy
	 * insurancePolicy) {
	 * 
	 * return insurancePolicyDAO.save(insurancePolicy);
	 * 
	 * 
	 * }
	 */

	/*
	 * @Override public InsurancePolicy updatePolicy(InsurancePolicy
	 * insurancePolicy)throws HealthServiceException { try {
	 * 
	 * return insurancePolicyDAO.save(insurancePolicy); }catch(DataAccessException
	 * e) { //converting SQLException to EmployeeException throw new
	 * HealthServiceException (e.getMessage()); }catch(Exception e) { //converting
	 * SQLException to EmployeeException throw new
	 * HealthServiceException(e.getMessage()); }
	 * 
	 * 
	 * }
	 */


	@Override 
	//public InsurancePolicy updatePolicy(InsurancePolicy
	// insurancePolicy)throws HealthServiceException { 
 public InsurancePolicy updatePolicy(String policyName, @Valid InsurancePolicy policyDetails)throws HealthServiceException {
		InsurancePolicy policy = insurancePolicyDAO.findByPolicyName(policyName);

		policy.setPolicyName(policyDetails.getPolicyName());
		policy.setCreatedate(policyDetails.getCreatedate());
		policy.setEnddate(policyDetails.getEnddate());
		policy.setMaximumAmount(policyDetails.getMaximumAmount());
		insurancePolicyDAO.save(policy);
		return policy;
	}
	@Override
	public InsurancePolicy getPolicyById(Long policyId)throws HealthServiceException {
		try {
			Optional<InsurancePolicy> optional= insurancePolicyDAO.findById(policyId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid policyid");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HealthServiceException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HealthServiceException(e.getMessage());
		}
	}

	@Override
	public void deletePolicyById(Long policyId) throws HealthServiceException {
		try {
			insurancePolicyDAO.deleteById(policyId);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HealthServiceException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HealthServiceException(e.getMessage());


		}
	}
}	


