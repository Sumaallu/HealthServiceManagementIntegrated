package com.cg.trg.serviceImpl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.trg.dao.FinanceDao;
import com.cg.trg.entity.Finance;
import com.cg.trg.exception.PatientCaseNotFoundException;
import com.cg.trg.exception.UserNameException;
import com.cg.trg.service.FinanceService;

@Service
@Transactional
public class FinancaServiceImpl implements FinanceService{
	@Autowired
	private FinanceDao financeDao;
	


		@Override
		public List<com.cg.trg.entity.Finance> findAll() throws PatientCaseNotFoundException {
			try {
				return financeDao.findAll();
			}catch(PersistenceException e) {
			
				throw new PatientCaseNotFoundException(e.getMessage());
			}catch(Exception e) {
			
				throw new PatientCaseNotFoundException(e.getMessage());
			}
		}

	
	@Override

	
	public Finance add(Finance finance) throws UserNameException {
		try {
			return financeDao.save(finance);
		}catch(PersistenceException e) {
			
			throw new UserNameException (e.getMessage());
		}catch(Exception e) {
			
			throw new UserNameException (e.getMessage());
		}
	}

	
	
	@Override
	public String update(Finance finance) throws PatientCaseNotFoundException {
		try {
			return financeDao.update(finance);
		}catch(PersistenceException e) {
			
			throw new PatientCaseNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new PatientCaseNotFoundException(e.getMessage());
		}
	}


		@Override
	
		
	
		public List<Finance> findAllFinancialDetails(Integer patientId) throws PatientCaseNotFoundException {
			try {
				return financeDao.findAllFinancialDetails(patientId);
			}catch(PersistenceException e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}catch(Exception e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}
		}


		@Override
		
		public String findByFinanceId(int id) throws PatientCaseNotFoundException {
			try {
				return financeDao.findByFinanceId(id);
			}catch(PersistenceException e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}catch(Exception e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}
		}
	
		@Override
		
		public String deleteFinanceByFinanceId(int id) throws PatientCaseNotFoundException {
			try {
				return financeDao.deleteFinanceByFinanceId(id);
			}catch(PersistenceException e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}catch(Exception e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}
		}


		
		@Override
		
		public Finance findByPatientId(int id) throws PatientCaseNotFoundException {
			try {
				return financeDao.findByPatientId(id);
			}catch(PersistenceException e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}catch(Exception e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}
		}


		@Override
		public Finance save(Finance finance) throws UserNameException {
			try {
				return financeDao.save(finance);
			}catch(PersistenceException e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}catch(Exception e) {
				
				throw new PatientCaseNotFoundException(e.getMessage());
			}
		}



		
}

