package com.backend.eventbooking.service.mysql;

import com.backend.eventbooking.model.Event;
import com.backend.eventbooking.dto.response.ResponseObject;
import com.backend.eventbooking.repository.EventRepository;
import com.backend.eventbooking.service.repo.EventRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SQLEventRepoService implements EventRepoService {

    private final EventRepository eventRepository;

    @Override
    public void saveEvent(Event event) {
        if (checkEvent(event).getStatus().equals("TRUE")) eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    public ResponseObject checkEvent(Event event) {
        return (
                event.getHeader().isBlank()
                        || event.getDescription().isBlank()
                        || event.getStartDate().toString().isBlank()
                        || event.getEndDate().toString().isBlank()
        )
                ? new ResponseObject("EVENT INVALID", "FALSE", null)
                : new ResponseObject("EVENT VALID", "TRUE", event);
    }
}
