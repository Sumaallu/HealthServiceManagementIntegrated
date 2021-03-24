package com.cg.trg.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.trg.dao.PatientRepository;
import com.cg.trg.entity.Patient;
import com.cg.trg.exception.HSMException;
import com.cg.trg.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService
{
@Autowired
	private PatientRepository patientRepository;
	
	@SuppressWarnings("unused")
	public Patient addPatient(Patient patient) {
		System.out.println("PSI Patient = "+patient);
	/*Integer id =Integer.parseInt( patient.getPatientName());
		int i=1;
		i++;
		id= id+i;
		patient.setPatientId(id);*/
		
		return patientRepository.save(patient);
	}
	

	public Iterable<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	@Override
	public void deletePatientBypatientId(Integer patientId) {
		Patient patient=patientRepository.findByPatientId(patientId);
		if(patient==null) {
			throw new HSMException("cannot delete this patient with : " + patientId+ " as this Patient does not exist");
		}
		patientRepository.delete(patient);
		
	}
	 
	
	@Override
	public Patient updatePatient(Integer patientId, Patient patient) {
		
		return patientRepository.save(patient);
		}
	@Override
	public Patient findPatientBypatientId(Integer patientId) {
		Patient patient=patientRepository.findByPatientId(patientId);
		if(patient==null) {
			throw new HSMException("Patient Id : " + patientId+ " does not exist");
		}
		return patient;
	}

}