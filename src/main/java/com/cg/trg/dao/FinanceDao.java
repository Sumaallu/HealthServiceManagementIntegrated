package com.cg.trg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.Finance;

@Repository
public interface FinanceDao extends JpaRepository<Finance,Integer>{

	String update(Finance finance);

	List<Finance> findAllFinancialDetails(Integer patientId);

	String findByFinanceId(int id);

	String deleteFinanceByFinanceId(int id);

	Finance findByPatientId(int id);
}