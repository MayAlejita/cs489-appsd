package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.request.PatientRequest;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.PatientResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.PatientNotFoundException;

import java.util.List;

public interface PatientService {
    PatientResponse addNewPatient(PatientRequest newPatient);
    PatientResponse getPatientById(Integer patientId) throws PatientNotFoundException;
    PatientResponse updatePatient(Integer patientId, PatientRequest patient) throws PatientNotFoundException;
    List<PatientResponse> getAllPatient();
    List<PatientResponse> searchPatient(String searchString);
    void deletePatientById(Integer patientId);
}
