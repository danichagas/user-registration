package com.danichagas.user_registration.infrastructure.repository;

import com.danichagas.user_registration.infrastructure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
