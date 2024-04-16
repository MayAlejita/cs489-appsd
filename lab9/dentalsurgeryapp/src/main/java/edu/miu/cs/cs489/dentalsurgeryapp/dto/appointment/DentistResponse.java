package edu.miu.cs.cs489.dentalsurgeryapp.dto.appointment;

public record DentistResponse(
        Integer dentistId,
        String firstName,
        String lastName,
        String phoneNumber,
        String email
) {
}
