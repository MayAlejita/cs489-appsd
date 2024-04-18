package edu.miu.cs.cs489.dentalsurgeryapp.repository;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Dentist;
import org.springframework.data.repository.ListCrudRepository;

public interface DentistRepository extends ListCrudRepository<Dentist, Integer> {
}
