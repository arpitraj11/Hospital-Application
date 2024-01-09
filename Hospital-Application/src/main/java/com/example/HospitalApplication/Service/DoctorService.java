package com.example.HospitalApplication.Service;

import com.example.HospitalApplication.Model.Doctor;
import com.example.HospitalApplication.Repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService  {

    @Autowired
    IDoctorRepo doctorRepo;
    public String addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
        return "Doctor_Added";
    }

    public String deleteDoctor(Integer doctorId) {
        doctorRepo.deleteById(doctorId);
        return "Doctor_Removed";
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }
}
