package com.cg.trg.entity;
import java.time.LocalDate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author win
 * This is Insurance Policy entity class that maps to a table, patients.
 * The policy id is auto generated.
 */
	@Entity
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@Table(name = "insurance")
	@EntityListeners(AuditingEntityListener.class)
	@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
	public class InsurancePolicy {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "policyid")
		//@NotNull
		private Long policyId;
		/*
		 * this is the policy name
		 */
		@Column(name = "policy_name")
		//@NotBlank(message = "Policy Name cannot be Blank")
		private String policyName;
		/*
		 * this is the time stamp of creation or update
		 */
		@Column(name = "created_at")
		@Temporal(TemporalType.DATE)
		@CreatedDate
		private Date createdate;
		/*
		   * this is the time stamp of end date
		   */
	  @Column(name = "end_at")
	  @Temporal(TemporalType.DATE)
	  @LastModifiedDate
	    private Date enddate;
	  /*
	   * this is the maximum amount of policy
	   */
	  @Column(name="max_amount")
	  private double maximumAmount;
		

		// OnetoOne mapping with patient
	    @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "id")
		//@JsonIgnore
		private Patient patients;

	@Override
		public String toString() {
			return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", createdate=" + createdate
					+ ", enddate=" + enddate + ", maximumAmount=" + maximumAmount + ", patients=" + patients + "]";
		}

	}

