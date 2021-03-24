package com.cg.trg.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.Patient;


@Repository
public interface PatientRepository  extends JpaRepository<Patient, Integer>
	{

		Patient findByPatientId(int patientId);
		
	}