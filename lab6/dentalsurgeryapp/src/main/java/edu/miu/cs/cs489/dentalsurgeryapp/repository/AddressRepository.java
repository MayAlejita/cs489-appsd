package edu.miu.cs.cs489.dentalsurgeryapp.repository;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
