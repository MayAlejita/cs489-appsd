package edu.miu.cs.cs489.dentalsurgeryapp.dto.address;

public record AddressRequest(
        String street,
        String city,
        String state,
        String zipCode
) {
}
