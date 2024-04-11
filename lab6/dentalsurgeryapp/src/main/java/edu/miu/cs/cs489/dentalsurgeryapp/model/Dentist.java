package edu.miu.cs.cs489.dentalsurgeryapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @OneToMany
    @JoinColumn(name = "dentist_id", unique = false, nullable = true)
    private List<Appointment> appointments;

    public Dentist(Integer dentistId, String firstName, String lastName, String phoneNumber, String email) {
        this.dentistId = dentistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
