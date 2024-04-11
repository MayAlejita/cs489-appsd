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
@Table(name="surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryId;
    private String name;
    private String phoneNumber;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = false, nullable = true)
    private Address address;
    @OneToMany(mappedBy = "surgery", fetch = FetchType.EAGER)
    private List<Appointment> appointments;

    public Surgery(Integer surgeryId, String name, String phoneNumber, Address address) {
        this.surgeryId = surgeryId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Surgery(Integer surgeryId, String name, String phoneNumber, List<Appointment> appointments) {
        this.surgeryId = surgeryId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.appointments = appointments;
    }
}
