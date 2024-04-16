package edu.miu.cs.cs489.dentalsurgeryapp.repository;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Surgery;
import org.springframework.data.repository.ListCrudRepository;

public interface SurgeryRepository extends ListCrudRepository<Surgery, Integer> {
}
