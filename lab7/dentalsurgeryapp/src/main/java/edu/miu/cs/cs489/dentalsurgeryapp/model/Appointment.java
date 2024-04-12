package edu.miu.cs.cs489.dentalsurgeryapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    private LocalDateTime dateAppointment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", unique = false, nullable = true)
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", unique = false, nullable = true)
    private Dentist dentist;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surgery_id", unique = false, nullable = true)
    private Surgery surgery;

    public Appointment(Integer appointmentId, LocalDateTime dateAppointment) {
        this.appointmentId = appointmentId;
        this.dateAppointment = dateAppointment;
    }
}
