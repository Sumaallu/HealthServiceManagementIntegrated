package com.cg.trg.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * This class is used to store the finance table attributes
 *
 */
@Entity
public class Finance{

	/**
	 * financeId attribute stores the id of a finance object
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="financeId")
	private Long financeId;
	
	@Column(name="patientId")
	private Long patientId;
	
	/**
	 * financeId attribute stores the id of a finance object
	 */
	/**
	 * patientName attribute stores name of a patient
	 */
	@Column(name="patientName",nullable=false,unique=true)
	private String patientName;
	
	/**
	 * registrationFee attribute stores the registrationFee of a patient
	 */
	@Column(name="registrationFee")
	private Double registrationFee;
	
	/**
	 * doctorFee attribute stores the fee of a doctor
	 */
	@Column(name="doctorFee")
	private Double doctorFee;
	
	/**
	 * medicinesAmount attribute stores the medicines amount of a patient
	 */
	@Column(name="medicineAmount")
	private Double medicineAmount;
	/**
	 * totalFee attribute stores the total fee of a patient
	 */
	@Column(name="totalFee")
	private Double totalFee;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="finance")
	@JoinColumn(name="patientId",nullable = false)
	private Patient patient;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_At;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_At;
	//Constructor
	public Finance() {
		
	}
	public Finance(String patientName, double registrationFee, double doctorFee, double medicinesAmount, double totalFee) {
		this.patientName = patientName;
		this.registrationFee = registrationFee;
		this.doctorFee = doctorFee;
		this.medicineAmount = medicinesAmount;
		this.totalFee = totalFee;
	}
	//Getters and setters
	public Long getFinanceId() {
		return financeId;
	}
	public void setFinanceId(Long financeId) {
		this.financeId = financeId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public double getRegistrationFee() {
		return registrationFee;
	}
	public void setRegistrationFee(double registrationFee) {
		this.registrationFee = registrationFee;
	}
	public double getDoctorFee() {
		return doctorFee;
	}
	public void setDoctorFee(double doctorFee) {
		this.doctorFee = doctorFee;
	}
	public double getMedicinesAmount() {
		return medicineAmount;
	}
	public void setMedicinesAmount(double medicinesAmount) {
		this.medicineAmount = medicinesAmount;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	@PrePersist
	public void onCreate() {
		this.created_At =  new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated_At =  new Date();
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	
	
	@Override
	public String toString() {
		return "Finance [patientName=" + patientName + ", doctorFee=" + doctorFee
				+ ", registrationFee=" + registrationFee + ", medicinesAmount=" + medicineAmount + ", totalFee="
				+ totalFee + "]";
	}
	

	
	
	
}