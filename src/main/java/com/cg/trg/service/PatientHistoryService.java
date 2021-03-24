package com.cg.trg.service;
import com.cg.trg.entity.PatientHistory;
import com.cg.trg.exception.HSMException;

public interface PatientHistoryService {
	PatientHistory addPatientHistory(PatientHistory patientHistory) throws HSMException;
	
	Iterable<PatientHistory> getAllPatientHistories() throws HSMException;
	
	PatientHistory findPatientHistoryByPatientId(int patientId) throws HSMException;

	PatientHistory findPatientHistoryByHistoryId(int historyId) throws HSMException;

	void updatePatientHistory(int patientId, PatientHistory patientHistory) throws HSMException;

	void deletePatientHistoryById(int patientId) throws HSMException;
	
}