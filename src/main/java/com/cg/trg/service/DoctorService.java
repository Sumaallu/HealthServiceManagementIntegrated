package com.cg.trg.service;

 

import java.util.List;

 

import javax.validation.Valid;

 

import com.cg.trg.entity.Doctor;

 

public interface DoctorService {
    
public Doctor saveDoctor(@Valid Doctor doctor);
    
    public Doctor findByDoctorId(int doctorId);
    
    public List<Doctor> getAllDoctors();
    
    public void deleteByDoctorId(int doctorId);
    
    public Doctor updateDoctor(String userName,Doctor doctor);

 


}
 