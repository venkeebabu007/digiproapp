package com.arkmedis.digipro.repository;



import com.arkmedis.digipro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email (useful for login functionality)
    Optional<User> findByEmail(String email);

    // Find all users by a specific role
    List<User> findByRole(User.Role role);

    // Find all users belonging to a specific team
    List<User> findByTeamTeamId(Long teamId);

    // Custom query to search users by name (case-insensitive)
    List<User> findByNameIgnoreCaseContaining(String name);




}
