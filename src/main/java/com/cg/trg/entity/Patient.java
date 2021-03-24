package com.cg.trg.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientId;
	
	@NotBlank(message = "Patient name is required")
	@Column(unique = true , updatable = true)
	private String patientName;	
	@Column
	@NotNull(message = "Patient Age number is required")
	private int patientAge;
	
	@Column(name = "patientContact", nullable = false, length =10)
	@NotNull(message = "Patient phone number is required")
	private long patientContact;
	@Column
	private String address;
	
    @Column
	private String symptoms;
   // private long policyId;
    

	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_At;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_At;

	// getters and setters
	//@JsonManagedReference
	/*
	 * public List<PatientHistory> getPatientHistories() { return patientHistories;
	 * } public void setPatientHistories(List<PatientHistory> patientHistories) {
	 * this.patientHistories = patientHistories; }
	 */
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	/*
	 * @JsonManagedReference public PatientCase getPatientCases() { return
	 * patientCases; } public void setPatientCases(PatientCase patientCases) {
	 * this.patientCases = patientCases; }
	 */
	public int getPatientAge() {
		return patientAge;
	}
	
	/*@ManyToMany(mappedBy = "patients")
    @JsonIgnore
    private Set<Doctor> doctors;*/
 
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public Patient(Integer patientId, @NotBlank(message = "Patient name is required") String patientName,
			@NotNull(message = "Patient Age number is required") int patientAge,
			@NotNull(message = "Patient phone number is required") long patientContact, String address, String symptoms,
			long policyId, Date created_At, Date updated_At) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientContact = patientContact;
		this.address = address;
		this.symptoms = symptoms;
	//	this.policyId = policyId;
		this.created_At = created_At;
		this.updated_At = updated_At;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientContact=" + patientContact + ", address=" + address + ", symptoms=" + symptoms
				+ ",  created_At=" + created_At + ", updated_At=" + updated_At + "]";
	}
	/*public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}*/
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getPatientContact() {
		return patientContact;
	}
	public void setPatientContact(long patientContact) {
		this.patientContact = patientContact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms =symptoms;
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
	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
	 * "patients") private List<PatientHistory> patientHistories = new
	 * ArrayList<>();
	 * 
	 * 
	 * @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
	 * "patients") private PatientCase patientCases;
	 */

	@PrePersist
	public void onCreate() {
		this.created_At=new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updated_At=new Date();
	}
}