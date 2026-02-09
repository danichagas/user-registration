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

    public void updateUserByID(UUID id, User user) {
        User userEntity = repository.findById(id).orElseThrow();
        User userUpdated = User.builder()
                .id(userEntity.getId())
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .build();
        repository.saveAndFlush(userUpdated);
    }

}