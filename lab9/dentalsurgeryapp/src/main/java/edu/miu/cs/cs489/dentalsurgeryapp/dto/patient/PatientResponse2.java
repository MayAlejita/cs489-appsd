package edu.miu.cs.cs489.dentalsurgeryapp.dto.patient;

import java.time.LocalDate;

public record PatientResponse2(
        Integer patientId,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String phoneNumber,
        String email
) {
}
