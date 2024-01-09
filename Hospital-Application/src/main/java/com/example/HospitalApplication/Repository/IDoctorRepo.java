package com.example.HospitalApplication.Repository;

import com.example.HospitalApplication.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {

    List<Doctor> findAllByDoctorSpecialityAndDoctorCity(String orthopedic, String patientCity);
}
