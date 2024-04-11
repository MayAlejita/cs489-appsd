package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Patient;

import java.util.List;

public interface PatientService {
    Patient addNewPatient(Patient newPatient);
    Patient updatePatient(Patient patient);
    List<Patient> getAllPatient();
    void deletePatientById(Integer patientId);
}
