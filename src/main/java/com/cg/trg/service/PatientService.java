package com.cg.trg.service;

import com.cg.trg.entity.Patient;



     public interface PatientService {
	
	public Patient addPatient(Patient patient);
	
	public Patient findPatientBypatientId(Integer patientId);
	
	public Iterable<Patient> getAllPatients();
	
	public void deletePatientBypatientId(Integer patientId);
	
	public Patient updatePatient(Integer patientId,Patient patient);
	
}
