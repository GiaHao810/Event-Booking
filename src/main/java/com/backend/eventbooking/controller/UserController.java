package com.backend.eventbooking.controller;

import com.backend.eventbooking.modelDTO.AuthenticationRequest;
import com.backend.eventbooking.modelDTO.RegisterRequest;
import com.backend.eventbooking.modelDTO.Response;
import com.backend.eventbooking.model.ResponseObject;
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
    public ResponseEntity<ResponseObject> getAllUser(){
        List<User> userList = userRepoService.getAllUser();

        return ResponseEntity.ok(
                new ResponseObject("OK", "OK", userList)
        );
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addUser(@RequestBody RegisterRequest registerRequest){
        Response response = authenticationService.register(registerRequest);

        log.info(response.toString());

        return ResponseEntity.ok(
                new ResponseObject("Created", "OK", response)
        );
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseObject> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        Response response = authenticationService.authenticate(authenticationRequest);

        log.info(response.toString());

        return ResponseEntity.ok(
                new ResponseObject("OK", "OK", response)
        );
    }
}
