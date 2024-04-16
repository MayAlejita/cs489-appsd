package edu.miu.cs.cs489.dentalsurgeryapp.dto.response;

public record SurgeryResponse(
        Integer surgeryId,
        String name,
        String phoneNumber
) {
}
