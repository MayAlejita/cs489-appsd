package edu.miu.cs.cs489.dentalsurgeryapp.repository;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
