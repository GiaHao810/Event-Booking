package com.backend.eventbooking.controller;

import com.backend.eventbooking.dto.request.AuthenticationRequest;
import com.backend.eventbooking.dto.request.RegisterRequest;
import com.backend.eventbooking.dto.Response;
import com.backend.eventbooking.dto.response.ResponseObject;
import com.backend.eventbooking.dto.response.SuccessAuthenticationResponse;
import com.backend.eventbooking.model.User;
import com.backend.eventbooking.service.AuthenticationService;
import com.backend.eventbooking.service.repo.UserRepoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepoService userRepoService;
    private final AuthenticationService authenticationService;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public ResponseEntity<Response> getAllUser() {
        return ResponseEntity.ok(
                new ResponseObject("OK",
                        "OK",
                        userRepoService.getAllUser())
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addUser(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(
                new ResponseObject("Created",
                        "OK",
                        authenticationService.register(registerRequest))
        );
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Response> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(
                new ResponseObject("OK",
                        "OK",
                        authenticationService.authenticate(authenticationRequest))
        );
    }
}
