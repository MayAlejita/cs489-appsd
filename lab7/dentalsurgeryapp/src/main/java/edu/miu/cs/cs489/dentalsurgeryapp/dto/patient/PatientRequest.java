package edu.miu.cs.cs489.dentalsurgeryapp.dto.patient;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.address.AddressRequest;

import java.time.LocalDate;

public record PatientRequest(
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String phoneNumber,
        String email,
        AddressRequest address
) {
}
