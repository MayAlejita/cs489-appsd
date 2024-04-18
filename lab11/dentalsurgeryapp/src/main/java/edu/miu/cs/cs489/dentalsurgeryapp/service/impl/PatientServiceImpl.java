package edu.miu.cs.cs489.dentalsurgeryapp.service.impl;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.AddressResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.request.PatientRequest;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.PatientResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.model.Address;
import edu.miu.cs.cs489.dentalsurgeryapp.model.Patient;
import edu.miu.cs.cs489.dentalsurgeryapp.repository.PatientRepository;
import edu.miu.cs.cs489.dentalsurgeryapp.service.PatientService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientResponse addNewPatient(PatientRequest newPatient) {
        var patient = new Patient(
                null, newPatient.firstName(), newPatient.lastName(),
                newPatient.dateOfBirth(), newPatient.phoneNumber(),
                newPatient.email(),
                (newPatient.address() != null) ? new Address(null,
                        newPatient.address().street(),
                        newPatient.address().city(),
                        newPatient.address().state(),
                        newPatient.address().zipCode()) : null);
        var savePatient = patientRepository.save(patient);
        return new PatientResponse(savePatient.getPatientId(),
                savePatient.getFirstName(),
                savePatient.getLastName(),
                savePatient.getDateOfBirth(),
                savePatient.getPhoneNumber(),
                savePatient.getEmail(),
                (savePatient.getAddress() != null) ? new AddressResponse(
                        savePatient.getAddress().getAddressId(),
                        savePatient.getAddress().getStreet(),
                        savePatient.getAddress().getCity(),
                        savePatient.getAddress().getState(),
                        savePatient.getAddress().getZipCode()
                ) : null);
    }

    @Override
    public PatientResponse getPatientById(Integer patientId) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            throw new PatientNotFoundException(String.format("Error: Patient with Id, %d, is not found", patientId));
        }
        return new PatientResponse(
                patient.getPatientId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getDateOfBirth(),
                patient.getPhoneNumber(),
                patient.getEmail(),
                (patient.getAddress() != null) ? new AddressResponse(
                        patient.getAddress().getAddressId(),
                        patient.getAddress().getStreet(),
                        patient.getAddress().getCity(),
                        patient.getAddress().getState(),
                        patient.getAddress().getZipCode()
                ) : null);
    }

    @Override
    public PatientResponse updatePatient(Integer patientId, PatientRequest updatedPatient) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            throw new PatientNotFoundException(String.format("Error: Patient with Id, %d, is not found", patientId));
        }
        patient.setFirstName(updatedPatient.firstName());
        patient.setLastName(updatedPatient.lastName());
        patient.setDateOfBirth(updatedPatient.dateOfBirth());
        patient.setPhoneNumber(updatedPatient.phoneNumber());
        patient.setEmail(updatedPatient.email());
        if (patient.getAddress() != null && updatedPatient.address() != null) {
            var address = patient.getAddress();
            address.setStreet(updatedPatient.address().street());
            address.setCity(updatedPatient.address().city());
            address.setState(updatedPatient.address().state());
            address.setZipCode(updatedPatient.address().zipCode());
        } else if (patient.getAddress() == null && updatedPatient.address() != null) {
            var newAddress = new Address();
            newAddress.setStreet(updatedPatient.address().street());
            newAddress.setCity(updatedPatient.address().city());
            newAddress.setState(updatedPatient.address().state());
            newAddress.setZipCode(updatedPatient.address().zipCode());
            patient.setAddress(newAddress);
        } else {
            patient.setAddress(null);
        }
        Patient upPatient = patientRepository.save(patient);
        return new PatientResponse(
                upPatient.getPatientId(),
                upPatient.getFirstName(),
                upPatient.getLastName(),
                upPatient.getDateOfBirth(),
                upPatient.getPhoneNumber(),
                upPatient.getEmail(),
                (upPatient.getAddress() != null) ? new AddressResponse(
                        upPatient.getAddress().getAddressId(),
                        upPatient.getAddress().getStreet(),
                        upPatient.getAddress().getCity(),
                        upPatient.getAddress().getState(),
                        upPatient.getAddress().getZipCode()
                ) : null);
    }

    @Override
    public List<PatientResponse> getAllPatient() {
        return patientRepository.findAll(Sort.by("lastname"))
                .stream()
                .map(p -> new PatientResponse(
                        p.getPatientId(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getDateOfBirth(),
                        p.getPhoneNumber(),
                        p.getEmail(),
                        (p.getAddress() != null) ? new AddressResponse(
                                p.getAddress().getAddressId(),
                                p.getAddress().getStreet(),
                                p.getAddress().getCity(),
                                p.getAddress().getState(),
                                p.getAddress().getZipCode()
                        ) : null
                ))
                .toList();
    }

    @Override
    public List<PatientResponse> searchPatient(String searchString) {
        List<Patient> patients = patientRepository.findPatientsByFirstNameContainingOrLastNameContainingOrEmailContainingOrAddress_CityOrAddress_StateOrAddress_StreetOrAddress_ZipCode(
                searchString, searchString, searchString, searchString, searchString, searchString, searchString);
        return patients.stream()
                .map(p -> new PatientResponse(
                        p.getPatientId(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getDateOfBirth(),
                        p.getPhoneNumber(),
                        p.getEmail(),
                        (p.getAddress() != null) ? new AddressResponse(
                                p.getAddress().getAddressId(),
                                p.getAddress().getStreet(),
                                p.getAddress().getCity(),
                                p.getAddress().getState(),
                                p.getAddress().getZipCode()
                        ) : null
                )).toList();
    }

    @Override
    public void deletePatientById(Integer patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient != null) {
            patientRepository.deleteById(patientId);
        }
    }
}
