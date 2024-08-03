package com.nmb.authservice.contracts.requests;

public record RegisterRequest(
        String username,
        String email,
        String firstName,
        String lastName,
        String password
) {
}
