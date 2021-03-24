package com.cg.trg.service;

import java.sql.Date;

import java.util.List;

import javax.validation.Valid;

import com.cg.trg.entity.PatientCase;

import com.cg.trg.exception.PatientCaseNotFoundException;

public interface PatientCaseService {
//	List<PatientCase> findPatientByAppointmentDate(int appointmentDate) throws PatientCaseNotFoundException;
	PatientCase addPatientCase(PatientCase patientcase) throws PatientCaseNotFoundException;
	List<PatientCase> getAllPatientCases() throws PatientCaseNotFoundException;
	List<PatientCase> getAllPatientDetailsByDisease(String diseaseDescription) throws PatientCaseNotFoundException;
	PatientCase findPatientByPatientCaseId(int patientcaseId) throws PatientCaseNotFoundException;
	void deletePatientCaseById(int patientCaseId) throws PatientCaseNotFoundException;
	void updatePatientCase(PatientCase patientCase) throws PatientCaseNotFoundException;
//	List<PatientCase> getAllPatientByDate(Date appointmentDate) throws PatientCaseNotFoundException;
	 
}



