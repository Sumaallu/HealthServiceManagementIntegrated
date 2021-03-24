package com.cg.trg.entity;


//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Nikhil
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private Integer userId;
	
	@NotNull
	@NotBlank(message="Please enter your email")
    @Email(message = "Email should be valid")
	@Pattern(regexp="[A-Za-z]+[0-9]*@[a-zA-Z]+.[a-zA-A]+")
    @Column(name = "user_email")
	private String userEmail;
	
	@NotNull
	@NotBlank(message="Please enter your name")
	@Size(min=2, max=30,message="First name should have atleast 2 characters")
    @Column(name = "user_name")
	private String userName;
	
	@NotNull
	@NotBlank(message="Please enter password")
    @Column(name = "user_password")
	private String userPassword;
	
	/*@OneToOne(mappedBy = "users")
	 private Set<Patient> patients;
	
	@OneToOne(mappedBy = "users")
	private Set<Doctor> doctors;
	*/
	

}