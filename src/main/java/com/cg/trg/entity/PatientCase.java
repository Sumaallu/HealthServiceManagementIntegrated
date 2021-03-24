package com.cg.trg.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 * This class will create patientHistory table in database and get all patient
 * history details
 * 
 * 
 *
 */

@Entity
@Table(name = "patientcase")
public class PatientCase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientCaseId;
	
	@Column
	private LocalDate appointmentDate;
    
	@Column
	private String associatedDoctorName;
	@Column
	private String diseaseDescription;
	@Column
	private String currentTreatment;
	@Column
	private String medicine;
	@Column
	private int medicineFee;
	
//	OneToOne mapping for patient-patientCase
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "patientId")
	private Patient patient;

public PatientCase(Integer patientCaseId, LocalDate appointmentDate, String associatedDoctorName,
		String diseaseDescription, String currentTreatment, String medicine, int medicineFee, Patient patient) {
	super();
	this.patientCaseId = patientCaseId;
	this.appointmentDate = appointmentDate;
	this.associatedDoctorName = associatedDoctorName;
	this.diseaseDescription = diseaseDescription;
	this.currentTreatment = currentTreatment;
	this.medicine = medicine;
	this.medicineFee = medicineFee;
	this.patient = patient;
}

public Integer getPatientCaseId() {
	return patientCaseId;
}

public void setPatientCaseId(Integer patientCaseId) {
	this.patientCaseId = patientCaseId;
}

public LocalDate getAppointmentDate() {
	return appointmentDate;
}

public void setAppointmentDate(LocalDate appointmentDate) {
	this.appointmentDate = appointmentDate;
}

public String getAssociatedDoctorName() {
	return associatedDoctorName;
}

public void setAssociatedDoctorName(String associatedDoctorName) {
	this.associatedDoctorName = associatedDoctorName;
}

public String getDiseaseDescription() {
	return diseaseDescription;
}

public void setDiseaseDescription(String diseaseDescription) {
	this.diseaseDescription = diseaseDescription;
}

public String getCurrentTreatment() {
	return currentTreatment;
}

public void setCurrentTreatment(String currentTreatment) {
	this.currentTreatment = currentTreatment;
}

public String getMedicine() {
	return medicine;
}

public void setMedicine(String medicine) {
	this.medicine = medicine;
}

public int getMedicineFee() {
	return medicineFee;
}

public void setMedicineFee(int medicineFee) {
	this.medicineFee = medicineFee;
}

public Patient getPatient() {
	return patient;
}

public void setPatient(Patient patient) {
	this.patient = patient;
}

public PatientCase() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "PatientCase [patientCaseId=" + patientCaseId + ", appointmentDate=" + appointmentDate
			+ ", associatedDoctorName=" + associatedDoctorName + ", diseaseDescription=" + diseaseDescription
			+ ", currentTreatment=" + currentTreatment + ", medicine=" + medicine + ", medicineFee=" + medicineFee
			+ ", patient=" + patient + "]";
}

	
	

}