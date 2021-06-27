package com.example.TODOmanager.repository;

import com.example.TODOmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     User findByName(String name);

}
