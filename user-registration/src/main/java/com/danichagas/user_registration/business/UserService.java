package com.danichagas.user_registration.business;

import com.danichagas.user_registration.infrastructure.entities.User;
import com.danichagas.user_registration.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void registerUser(User user) {
        repository.saveAndFlush(user);
    }

    public User searchUserById(UUID id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("ID not found")
        );
    }

    public void deleteUserById(UUID id) {
        repository.deleteById(id);
    }


}
