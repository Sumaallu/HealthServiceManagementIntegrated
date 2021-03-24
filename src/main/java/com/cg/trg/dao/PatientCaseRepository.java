package com.cg.trg.dao;



import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.trg.entity.PatientCase;

public interface PatientCaseRepository extends JpaRepository<PatientCase,Integer>{

	List<PatientCase> findPatientByDiseaseDescription(String diseaseDescription);
//	List<PatientCase> findPatientByAppointmentDate(Date appointmentDate);
	PatientCase findByPatient(int patientId);
	PatientCase findByPatientCaseId(int patientCaseId);
//	List<PatientCase> findPatientByDate(Date appointmentDate);
	
   
	
}




