package com.backend.eventbooking.service.repo;

import com.backend.eventbooking.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventRepoService {
    void saveEvent(Event event);
    List<Event> getAllEvent();
}
