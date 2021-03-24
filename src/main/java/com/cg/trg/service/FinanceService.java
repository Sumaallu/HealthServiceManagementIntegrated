package com.cg.trg.service;

import java.util.List;

import com.cg.trg.entity.Finance;
import com.cg.trg.exception.PatientCaseNotFoundException;
import com.cg.trg.exception.UserNameException;

public interface FinanceService {

	List<Finance> findAll() throws PatientCaseNotFoundException;

	Finance save(Finance finance) throws UserNameException;

	String update(Finance finance) throws PatientCaseNotFoundException;

	List<Finance> findAllFinancialDetails(Integer patientId) throws PatientCaseNotFoundException;

	String findByFinanceId(int id) throws PatientCaseNotFoundException;

	String deleteFinanceByFinanceId(int id) throws PatientCaseNotFoundException;

	Finance findByPatientId(int id) throws PatientCaseNotFoundException;

	Finance add(Finance finance) throws UserNameException;



	


}
