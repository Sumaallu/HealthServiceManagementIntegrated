package com.cg.trg.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.trg.dao.PatientHistoryRepository;
import com.cg.trg.dao.PatientRepository;
import com.cg.trg.entity.Patient;
import com.cg.trg.entity.PatientCase;
import com.cg.trg.entity.PatientHistory;
import com.cg.trg.exception.HSMException;
import com.cg.trg.exception.PatientCaseNotFoundException;
import com.cg.trg.service.PatientHistoryService;



@Service
public  class PatientHistoryServiceImpl implements PatientHistoryService{
	@Autowired
	private PatientHistoryRepository patientHistoryRepositary;
	
	@Autowired
	private PatientRepository patientRepositary;
	
	public PatientHistoryServiceImpl(PatientHistoryRepository patientHistoryRepositary) {
		super();
		this.patientHistoryRepositary = patientHistoryRepositary;
	}

	@Override
	public  PatientHistory addPatientHistory(PatientHistory patientHistory) throws HSMException {
	System.out.println("PATIENT HISTORY = "+patientHistory);
		Patient patient = patientRepositary.findById(patientHistory.getPatient().getPatientId()).orElse(null);
           if (patient == null) {
               patient = new Patient();
           }
           
           Patient p=patientHistory.getPatient();
           if(p.getPatientId()!=null)
           patient.setPatientId(p.getPatientId());
           patient.setPatientName(p.getPatientName());
          patient.setPatientAge(p.getPatientAge());
          patient.setPatientContact(p.getPatientContact());
          patient.setAddress(p.getAddress());
          patient.setSymptoms(p.getSymptoms());
          patient.setCreated_At(p.getCreated_At());
          patient.setUpdated_At(p.getUpdated_At());
           patientHistory.setPatient(patient);
           return patientHistoryRepositary.save(patientHistory);
		
//		try {
//			return patientHistoryRepositary.save(patientHistory);
//		}
//		catch(DataAccessException e) {
//			throw new HSMException(e.getMessage());	
//		}
//		catch(HSMException e) {
//			throw new HSMException(e.getMessage());	
//		}
		
	}
	
	@Override	
public Iterable<PatientHistory> getAllPatientHistories() throws HSMException{
    try {
		return patientHistoryRepositary.findAll();
    } catch(DataAccessException e) {
		throw new HSMException(e.getMessage());	
	}
	catch(HSMException e) {
		throw new HSMException(e.getMessage());	
	}
	}

	@Override
	public PatientHistory findPatientHistoryByHistoryId(int historyId) throws HSMException{
     try {
		return  patientHistoryRepositary.findByPatientHistoryId(historyId);
     } catch(DataAccessException e) {
   		throw new HSMException(e.getMessage());	
   	}
   	catch(HSMException e) {
   		throw new HSMException(e.getMessage());	
   	}
	}
	@Override
	public void updatePatientHistory(int patientId, PatientHistory patientHistory) throws HSMException{
		try {
			patientHistoryRepositary.save(patientHistory);
		} catch(DataAccessException e) {
	   		throw new HSMException(e.getMessage());	
	   	}
	   	catch(HSMException e) {
	   		throw new HSMException(e.getMessage());	
	   	}
		
	}
	@Override
	public void deletePatientHistoryById(int patientId) throws HSMException{
		try {
			patientHistoryRepositary.deleteById(patientId);
		} catch(DataAccessException e) {
	   		throw new HSMException(e.getMessage());	
	   	}
	   	catch(HSMException e) {
	   		throw new HSMException(e.getMessage());	
	   	}
		
	}

	@Override
	public PatientHistory findPatientHistoryByPatientId(int patientId) throws HSMException {
		 try {
				return  patientHistoryRepositary.findByPatient(patientId);
		      } catch(DataAccessException e) {
		  		throw new HSMException(e.getMessage());	
		  	}
		  	catch(HSMException e) {
		  		throw new HSMException(e.getMessage());	
		  	}
		 }
}