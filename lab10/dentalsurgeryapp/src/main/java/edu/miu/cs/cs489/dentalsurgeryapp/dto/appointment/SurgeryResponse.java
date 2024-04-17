package edu.miu.cs.cs489.dentalsurgeryapp.dto.appointment;

public record SurgeryResponse(
        Integer surgeryId,
        String name,
        String phoneNumber
) {
}
