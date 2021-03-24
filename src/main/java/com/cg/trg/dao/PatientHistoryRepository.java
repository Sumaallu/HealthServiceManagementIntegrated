package com.cg.trg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.trg.entity.PatientHistory;


public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Integer> {

	PatientHistory findByPatient(int patientId);

	PatientHistory findByPatientHistoryId(int historyId);
	

}