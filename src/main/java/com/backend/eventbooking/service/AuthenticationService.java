package com.backend.eventbooking.service;

import com.backend.eventbooking.dto.*;
import com.backend.eventbooking.dto.request.AuthenticationRequest;
import com.backend.eventbooking.dto.request.RegisterRequest;
import com.backend.eventbooking.dto.response.FailAuthenticationResponse;
import com.backend.eventbooking.dto.response.SuccessAuthenticationResponse;
import com.backend.eventbooking.model.Role;
import com.backend.eventbooking.model.User;
import com.backend.eventbooking.service.repo.UserRepoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
    @Autowired
    private final UserRepoService userRepoService;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtService jwtService;

    public Response register(RegisterRequest registerRequest) {
        User user = User.builder()
                .name(registerRequest.name())
                .mail(registerRequest.mail())
                .password(passwordEncoder.encode(registerRequest.password()))
                .createAt(LocalDate.now())
                .role(Role.USER)
                .build();
        userRepoService.saveUser(user);

        var jwtToken = jwtService.generateToken(user);

        return new SuccessAuthenticationResponse(
                jwtToken,
                jwtService.getExpirationTime()
        );
    }

    public Response authenticate(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.mail(),
                            authenticationRequest.password()
                    )
            );
        } catch (AuthenticationException e) {

            logger.error(e.getMessage());

            return new FailAuthenticationResponse(
                    e.getMessage(),
                    "FAILED",
                    authenticationRequest
            );
        }

        var jwtToken = jwtService.generateToken(
                userRepoService.findByMail(authenticationRequest.mail())
                        .orElseThrow()
        );

        return new SuccessAuthenticationResponse(
                jwtToken,
                jwtService.getExpirationTime()
        );
    }
}
