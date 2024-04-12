package edu.miu.cs.cs489.dentalsurgeryapp.repository;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Patient;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PatientRepository extends ListCrudRepository<Patient, Integer> {
    public List<Patient> findPatientsByFirstNameContainingOrLastNameContainingOrEmailContainingOrAddress_CityOrAddress_StateOrAddress_StreetOrAddress_ZipCode(
            String firstName, String lastName, String email, String city, String state, String street, String zipCode);
}
