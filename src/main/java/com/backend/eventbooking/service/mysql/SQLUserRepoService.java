package com.backend.eventbooking.service.mysql;

import com.backend.eventbooking.dto.response.ResponseObject;
import com.backend.eventbooking.model.User;
import com.backend.eventbooking.repository.UserRepository;
import com.backend.eventbooking.service.repo.UserRepoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SQLUserRepoService implements UserRepoService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(SQLUserRepoService.class);

    @Override
    public void saveUser(User user) {
        if(checkUser(user).getStatus().equals("TRUE")) userRepository.save(user);
    }

    @Override
    public ResponseObject checkUser(User user) {
        return (
                Objects.equals(user.getMail(), "")
                || Objects.equals(user.getName(), "")
                || Objects.equals(user.getPassword(), "")
        )
                ? new ResponseObject("USER CREDENCIAL INVALID", "FALSE" , null)
                : new ResponseObject("USER CREDENCIAL VALID", "TRUE" ,user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<User> findByMail(String mail) {
        return userRepository.findByMail(mail);
    }
}
