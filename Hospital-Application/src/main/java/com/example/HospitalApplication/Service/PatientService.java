package com.example.HospitalApplication.Service;

import com.example.HospitalApplication.Model.Doctor;
import com.example.HospitalApplication.Model.Patient;
import com.example.HospitalApplication.Repository.IDoctorRepo;
import com.example.HospitalApplication.Repository.IPatientsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.HospitalApplication.Model.Enums.City.*;
import static com.example.HospitalApplication.Model.Enums.Symptoms.*;

@Service
public class PatientService {

   @Autowired
   IPatientsRepo patientsRepo;


    @Autowired
    IDoctorRepo doctorRepo;

    @Autowired
    DoctorService doctorService;

    public String addPatient(Patient patient) {
        patientsRepo.save(patient);
        return "Patient-Added";
    }

    public String deletePatient(Integer patientId) {
        patientsRepo.deleteById(patientId);
        return "Patient_Removed";
    }

    public String doctorAvailable(Integer patientId) {

        Patient patient = patientsRepo.findById(patientId).orElse(null);

        if(patient == null) {
            return "Patient not found with this Id";
        }
        if(!(patient.getPatientCity().equals(Noida) || patient.getPatientCity().equals(Delhi) || patient.getPatientCity().equals(Faridabad))){
            return "We are still waiting to expend to your location.";
        }else{
            return getDoctorSuggestion(patient);
        }
    }

    private String getDoctorSuggestion(Patient patient) {
        if(patient.getPatientSymptom().equals(Arthritis) || patient.getPatientSymptom().equals(Back_Pain) ||patient.getPatientSymptom().equals(Tissue_Injuries)){
            List<Doctor> doctors = doctorRepo.findAllByDoctorSpecialityAndDoctorCity("Orthopedic", patient.getPatientCity());
            if(doctors.isEmpty()) return "There isn’t any doctor present at your location for your symptom";
            return "You should contact with this doctor:"+doctors.toString();
        }
        if(patient.getPatientSymptom().equals(Dysmenorrhea)){
            List<Doctor> doctors = doctorRepo.findAllByDoctorSpecialityAndDoctorCity("Gynecology", patient.getPatientCity());
            if(doctors.isEmpty()) return "There isn’t any doctor present at your location for your symptom";
            return "You should contact with this doctor:"+ doctors.toString();
        }
        if(patient.getPatientSymptom().equals(Skin_Infection) || patient.getPatientSymptom().equals(Skin_Burn)){
            List<Doctor> doctors = doctorRepo.findAllByDoctorSpecialityAndDoctorCity("Dermatology", patient.getPatientCity());
            if(doctors.isEmpty()) return "There isn’t any doctor present at your location for your symptom";
            return "You should contact with this doctor:"+ doctors.toString();
        }
        if(patient.getPatientSymptom().equals(Ear_Pain)){
            List<Doctor> doctors = doctorRepo.findAllByDoctorSpecialityAndDoctorCity("ENT", patient.getPatientCity());
            if(doctors.isEmpty()) return "There isn’t any doctor present at your location for your symptom";
            return "You should contact with this doctor:"+ doctors.toString();
        }
        return "There isn’t any doctor present at your location for your symptom";
    }

}
