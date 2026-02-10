package com.danichagas.user_registration.controller;

import com.danichagas.user_registration.business.UserService;
import com.danichagas.user_registration.infrastructure.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> findById(@RequestParam UUID id) {
        return ResponseEntity.ok(userService.searchUserById(id));
    }


}
