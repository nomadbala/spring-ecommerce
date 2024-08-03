package com.nmb.authservice.service;

import com.nmb.authservice.contracts.requests.LoginRequest;
import com.nmb.authservice.contracts.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final KeycloakService keycloakService;

    public AccessTokenResponse login(LoginRequest request) {
        return keycloakService.getToken(request);
    }

    public void register(RegisterRequest request) {
        keycloakService.createUser(request);
    }
}
