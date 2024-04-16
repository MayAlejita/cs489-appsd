package edu.miu.cs.cs489.dentalsurgeryapp.dto.request;

public record UserRequest (
        String username,
        String password,
        String firstName,
        String lastName,
        String email,
        boolean enabled,
        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired
){
}
