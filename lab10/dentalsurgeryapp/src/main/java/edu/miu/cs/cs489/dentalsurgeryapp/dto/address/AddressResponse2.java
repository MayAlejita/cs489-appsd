package edu.miu.cs.cs489.dentalsurgeryapp.dto.address;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.patient.PatientResponse2;

public record AddressResponse2(
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode,
        PatientResponse2 patient
) {
}
