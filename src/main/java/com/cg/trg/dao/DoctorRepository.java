package com.cg.trg.dao;

 


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

import com.cg.trg.entity.Doctor;

 

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

 

    Doctor findByDoctorId(int doctorId);

 

    Doctor findByUserName(String username);
}