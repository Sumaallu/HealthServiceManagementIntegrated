package com.cg.trg.controller;
import javax.validation.Valid;
import com.cg.trg.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.trg.entity.Patient;

 

import com.cg.trg.serviceImpl.PatientServiceImpl;

 

@CrossOrigin(origins="http://localhost:8085")
@RestController
  @RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientServiceImpl;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    
    @PostMapping("/add")
    public ResponseEntity<?> createNewPatient(@Valid @RequestBody Patient patient ,  BindingResult result ) {
        System.out.println("Patient = "+patient);
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
        if (errorMap != null)
            return errorMap;
        Patient p= patientServiceImpl.addPatient(patient); 
        return new ResponseEntity<Patient>(p,HttpStatus.CREATED);
    }
    @GetMapping("/{patientId}")
    public ResponseEntity<?> getProjectById(@PathVariable Integer patientId){
        Patient patient = patientServiceImpl.findPatientBypatientId(patientId);
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public Iterable<Patient> getAllPatients(){
        return patientServiceImpl.getAllPatients();
    }
    
    @DeleteMapping("/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer patientId) {
           patientServiceImpl.deletePatientBypatientId(patientId);
        return new ResponseEntity<String>("Project with id : "+patientId+" deleted successfully.",HttpStatus.OK);
    }
    @PutMapping("/{patientId}")
    public void updatePatientById(@Valid @RequestBody Patient patient ,@PathVariable Integer patientId)
    {
        patientServiceImpl.updatePatient(patientId,patient);
    }
}