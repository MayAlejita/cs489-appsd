package edu.miu.cs.cs489.pizzadeliveryapp.dto.request;

public record UserAuthRequest(
        String username,
        String password
) {
}
