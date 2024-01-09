package com.example.HospitalApplication.Controller;

import com.example.HospitalApplication.Model.Patient;
import com.example.HospitalApplication.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class PatientsController {

    @Autowired
    PatientService patientService;

    //Adding Patient
    @PostMapping("/patient")
    public String addPatient(@Valid @RequestBody Patient patient)
    {
        return patientService.addPatient(patient);
    }

    //Deleting Patient
    @DeleteMapping("/patient/{patientId}")
    public String deletePatient(@PathVariable Integer patientId)
    {
        return patientService.deletePatient(patientId);
    }

    //Suggesting Doctor based on Patient's Symptom and Location
    @GetMapping("/doctor-available")
    public String doctoravailable(@RequestParam Integer patientId)
    {
        return patientService.doctorAvailable(patientId);
    }

}
