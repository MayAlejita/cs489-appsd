package edu.miu.cs.cs489.dentalsurgeryapp.repository;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
