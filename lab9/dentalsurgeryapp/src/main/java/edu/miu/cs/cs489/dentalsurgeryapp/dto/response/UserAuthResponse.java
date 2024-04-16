package edu.miu.cs.cs489.dentalsurgeryapp.dto.response;

public record UserAuthResponse(
        String jwtToken,
        String firstName,
        String lastName
) {
}