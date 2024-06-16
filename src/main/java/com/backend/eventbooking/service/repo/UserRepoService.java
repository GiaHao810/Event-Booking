package com.backend.eventbooking.service.repo;

import com.backend.eventbooking.model.ResponseObject;
import com.backend.eventbooking.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRepoService {
    void saveUser(User user);
    ResponseObject checkUser(User user);
    List<User> getAllUser();
    Optional<User> findByName(String name);
    Optional<User> findByMail(String mail);
}
