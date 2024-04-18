package edu.miu.cs.cs489.dentalsurgeryapp.dto.response;

public record DentistResponse(
        Integer dentistId,
        String firstName,
        String lastName,
        String phoneNumber,
        String email
) {
}
