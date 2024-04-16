package edu.miu.cs.cs489.dentalsurgeryapp.dto.request;

public record UserAuthRequest(
        String username,
        String password
) {
}
