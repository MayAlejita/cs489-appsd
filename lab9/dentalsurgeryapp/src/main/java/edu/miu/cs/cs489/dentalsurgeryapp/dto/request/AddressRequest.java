package edu.miu.cs.cs489.dentalsurgeryapp.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        @NotBlank(message = "Address street is required and cannot be null or empty string or blank spaces")
        String street,
        @NotBlank(message = "Address city is required and cannot be null or empty string or blank spaces")
        String city,
        String state,
        String zipCode
) {
}
