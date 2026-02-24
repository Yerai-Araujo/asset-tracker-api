package com.at.asset_tracker.domain.repository;

import java.util.Optional;

import com.at.asset_tracker.domain.model.User;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
