package com.intro.SpringBoot.service;

import com.intro.SpringBoot.controller.PatientController;
import com.intro.SpringBoot.model.Employee;
import com.intro.SpringBoot.model.Patient;
import com.intro.SpringBoot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() { return patientRepository.findAll();}

    public Optional<Patient> getPatientById(Long id) { return patientRepository.findById(id); }

    public List<Patient> getPatientsByDateOfBirth(LocalDate start, LocalDate end){
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    public List<Patient> getPatientsAdmittedBy(Integer employeeId, String department){
        return patientRepository.admittedBy(employeeId, department);
    }

    public List<Patient> getPatientsWithOffDoctor(){
        return patientRepository.withOffDoctor();
    }
}
