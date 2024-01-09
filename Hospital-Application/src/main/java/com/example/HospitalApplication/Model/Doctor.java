package com.example.HospitalApplication.Model;

import com.example.HospitalApplication.Model.Enums.City;
import com.example.HospitalApplication.Model.Enums.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Length(min = 3, message = "please enter full name")
    private String doctorName;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Please enter a valid number")
    private String doctorPhoneNumber;

    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please enter a valid email")
    private String doctorEmail;

    @Enumerated(EnumType.STRING)
    private City doctorCity;

    @Enumerated(EnumType.STRING)
    private Speciality doctorSpeciality;
}
