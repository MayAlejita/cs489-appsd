package edu.miu.cs.cs489.dentalsurgeryapp.dto.patient;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.address.AddressResponse;
import java.time.LocalDate;

public record PatientResponse(
        Integer patientId,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String phoneNumber,
        String email,
        AddressResponse address
) {
}
