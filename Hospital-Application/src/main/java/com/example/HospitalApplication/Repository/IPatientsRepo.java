package com.example.HospitalApplication.Repository;

import com.example.HospitalApplication.Model.Patient;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientsRepo extends JpaRepository<Patient, Integer> {
}
