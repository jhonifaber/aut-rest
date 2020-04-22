package com.aut.prueba.repository;

import com.aut.prueba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
