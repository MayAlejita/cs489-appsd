package edu.miu.cs.cs489.dentalsurgeryapp.repository;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Appointment;
import org.springframework.data.repository.ListCrudRepository;

public interface AppointmentRepository extends ListCrudRepository<Appointment, Integer> {
}
