package com.example.HospitalApplication.Controller;

import com.example.HospitalApplication.Model.Doctor;
import com.example.HospitalApplication.Service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //Adding Doctor
    @PostMapping("/doctor")
    public String addDoctor(@Valid @RequestBody Doctor doctor)
    {
        return doctorService.addDoctor(doctor);
    }

    //Deleting Doctor
    @DeleteMapping("/doctor/{doctorId}")
    public String deleteDoctor(@PathVariable Integer doctorId)
    {

        return doctorService.deleteDoctor(doctorId);
    }

    @GetMapping("doctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

}
