package com.project.easyEvent.user.model.repository;

import com.project.easyEvent.user.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Boolean existsByEmail(String email);

    Optional<Users> findByEmail(String email);
}
