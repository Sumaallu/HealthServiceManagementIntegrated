package com.cg.trg.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * This class will create patientHistory table in database and get all patient
 * history details
 * 
 * 
 *
 */

@Entity
@Table(name = "patienthistory")

public class PatientHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientHistoryId;
	
	@Column
	private LocalDate recordedDate;
	
	@Column
	private String diseaseName;

	@NotNull(message = "Patient blood group is required")
	@Column(nullable = false)

	private String bloodGroup;
	@Column
	private String dietAdvised;
	@Column
	private String treatmentStatus;


//	 ManytoOne Mapping with patient-patienthistory
	
	  @ManyToOne(cascade = CascadeType.ALL)  
	  @JoinColumn(name = "patientId")
	private Patient patient;


	public PatientHistory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PatientHistory(int patientHistoryId, LocalDate recordedDate, String diseaseName,
			@NotNull(message = "Patient blood group is required") String bloodGroup, String dietAdvised,
			String treatmentStatus, Patient patient) {
		super();
		this.patientHistoryId = patientHistoryId;
		this.recordedDate = recordedDate;
		this.diseaseName = diseaseName;
		this.bloodGroup = bloodGroup;
		this.dietAdvised = dietAdvised;
		this.treatmentStatus = treatmentStatus;
		this.patient = patient;
	}


	public int getPatientHistoryId() {
		return patientHistoryId;
	}


	public void setPatientHistoryId(int patientHistoryId) {
		this.patientHistoryId = patientHistoryId;
	}


	public LocalDate getRecordedDate() {
		return recordedDate;
	}


	public void setRecordedDate(LocalDate recordedDate) {
		this.recordedDate = recordedDate;
	}


	public String getDiseaseName() {
		return diseaseName;
	}


	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getDietAdvised() {
		return dietAdvised;
	}


	public void setDietAdvised(String dietAdvised) {
		this.dietAdvised = dietAdvised;
	}


	public String getTreatmentStatus() {
		return treatmentStatus;
	}


	public void setTreatmentStatus(String treatmentStatus) {
		this.treatmentStatus = treatmentStatus;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "PatientHistory [patientHistoryId=" + patientHistoryId + ", recordedDate=" + recordedDate
				+ ", diseaseName=" + diseaseName + ", bloodGroup=" + bloodGroup + ", dietAdvised=" + dietAdvised
				+ ", treatmentStatus=" + treatmentStatus + ", patient=" + patient + "]";
	}


	

		 
	

}