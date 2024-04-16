package edu.miu.cs.cs489.dentalsurgeryapp.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PatientRequest(
        @NotBlank(message = "Patient first name is required and cannot be null or empty string or blank spaces")
        String firstName,
        @NotBlank(message = "Patient last name is required and cannot be null or empty string or blank spaces")
        String lastName,
        LocalDate dateOfBirth,
        String phoneNumber,
        String email,
        @Valid AddressRequest address
) {
}
