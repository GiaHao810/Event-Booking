package com.backend.eventbooking.controller;

import com.backend.eventbooking.dto.Response;
import com.backend.eventbooking.model.Event;
import com.backend.eventbooking.dto.response.ResponseObject;
import com.backend.eventbooking.service.repo.EventRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class EventController {

    private final EventRepoService eventRepoService;
    Response n = new ResponseObject("", "", null);
    @GetMapping("/")
    public ResponseEntity<ResponseObject> getAllEvent(){
        return ResponseEntity.ok(
                new ResponseObject("OK", "OK", eventRepoService.getAllEvent())
        );
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addEvent(@RequestBody Event event){
        eventRepoService.saveEvent(event);
        return ResponseEntity.ok(
                new ResponseObject("OK", "OK", null)
        );
    }
}
