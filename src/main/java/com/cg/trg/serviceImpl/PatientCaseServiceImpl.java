package com.cg.trg.serviceImpl;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.trg.dao.PatientCaseRepository;
import com.cg.trg.entity.PatientCase;
import com.cg.trg.exception.PatientCaseNotFoundException;
import com.cg.trg.service.PatientCaseService;


@Service

public  class PatientCaseServiceImpl implements PatientCaseService {
	
	@Autowired
	private  PatientCaseRepository patientCaseRepository;
	
	public PatientCaseServiceImpl(PatientCaseRepository patientCaseRepository) {
		super();
		this.patientCaseRepository = patientCaseRepository;
	}
	
	
	@Override
	public  PatientCase addPatientCase(PatientCase patientcase) throws PatientCaseNotFoundException {
		try {
			return patientCaseRepository.save(patientcase);
		}
		catch(DataAccessException e) {
			throw new PatientCaseNotFoundException(e.getMessage());	
		}
		catch(PatientCaseNotFoundException e) {
			throw new PatientCaseNotFoundException(e.getMessage());	
		}
		
	}
	@Override
     public List<PatientCase> getAllPatientCases() throws PatientCaseNotFoundException{
    	try {
    		return (List<PatientCase>) patientCaseRepository.findAll();	
    	}
    	catch(DataAccessException e) {
			throw new PatientCaseNotFoundException(e.getMessage());	
		}
		catch(PatientCaseNotFoundException e) {
			throw new PatientCaseNotFoundException(e.getMessage());	
		}
     }
	@Override
     public List<PatientCase> getAllPatientDetailsByDisease(String diseaseDescription) throws PatientCaseNotFoundException {
    	 try {
    		 return (List<PatientCase>) patientCaseRepository.findAll();
    	 }
    	 catch(DataAccessException e) {
 			throw new PatientCaseNotFoundException(e.getMessage());	
 		}
 		catch(PatientCaseNotFoundException e) {
 			throw new PatientCaseNotFoundException(e.getMessage());	
 		}
     }
	
//	@Override
//     public List<PatientCase> getAllPatientByDate(Date appointmentDate) throws PatientCaseNotFoundException{
//    	 try {
//    		 return (List<PatientCase>) patientCaseRepository.findPatientByDate( appointmentDate);
//    	 }
//    	 catch(DataAccessException e) {
//  			throw new PatientCaseNotFoundException(e.getMessage());	
//  		}
//  		catch(PatientCaseNotFoundException e) {
//  			throw new PatientCaseNotFoundException(e.getMessage());	
//  		}
//
//     }
	@Override
	public PatientCase findPatientByPatientCaseId(int patientcaseId) throws PatientCaseNotFoundException {
		try {
			PatientCase patientCase=patientCaseRepository.findByPatientCaseId(patientcaseId);
			return patientCase;	
		}
		 catch(DataAccessException e) {
	  			throw new PatientCaseNotFoundException(e.getMessage());	
	  		}
	  		catch(PatientCaseNotFoundException e) {
	  			throw new PatientCaseNotFoundException(e.getMessage());	
	  		}
	}
	@Override
	public void updatePatientCase(PatientCase patientCase) throws PatientCaseNotFoundException {
		try {
		 patientCaseRepository.save(patientCase);	
	}
		catch(DataAccessException e) {
  			throw new PatientCaseNotFoundException(e.getMessage());	
  		}
  		catch(PatientCaseNotFoundException e) {
  			throw new PatientCaseNotFoundException(e.getMessage());	
  		}
		}
	@Override
	public void deletePatientCaseById(int patientCaseId) throws PatientCaseNotFoundException {
		try {
			patientCaseRepository.deleteById(patientCaseId);	
		}
		catch(DataAccessException e) {
  			throw new PatientCaseNotFoundException(e.getMessage());	
  		}
  		catch(PatientCaseNotFoundException e) {
  			throw new PatientCaseNotFoundException(e.getMessage());	
  		}
		
	}


//	@Override
//	public List<PatientCase> getAllPatientByAppointmentDate (Date appointmentDate) throws PatientCaseNotFoundException {
//		// TODO Auto-generated method stub
//		try {
//   		 return (List<PatientCase>) patientCaseRepository.findPatientByAppointmentDate( appointmentDate);
//   	 }
//   	 catch(DataAccessException e) {
// 			throw new PatientCaseNotFoundException(e.getMessage());	
// 		}
// 		catch(PatientCaseNotFoundException e) {
// 			throw new PatientCaseNotFoundException(e.getMessage());	
// 		}


//	}	
}


