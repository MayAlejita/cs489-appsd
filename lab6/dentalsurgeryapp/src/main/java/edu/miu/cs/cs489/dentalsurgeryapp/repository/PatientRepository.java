package edu.miu.cs.cs489.dentalsurgeryapp.repository;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
