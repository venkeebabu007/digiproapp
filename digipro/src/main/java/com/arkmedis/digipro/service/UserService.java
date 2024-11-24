package com.arkmedis.digipro.service;



import com.arkmedis.digipro.entity.User;

import java.util.List;
import java.util.Optional;
public interface UserService {
    // Save or update a user
    User saveOrUpdateUser(User user);

    // Find a user by their ID
    Optional<User> getUserById(Long userId);

    // Find a user by their email
    Optional<User> getUserByEmail(String email);

   // Find a user by their email
    Optional<User> findByEmail(String email);


    // Retrieve all users

    List<User> getAllUsers();

    // Find users by role
    List<User> getUsersByRole(User.Role role);

    // Find users by team ID
    List<User> getUsersByTeamId(Long teamId);

    // Search users by name
    List<User> searchUsersByName(String name);

    // Delete a user by their ID
    void deleteUserById(Long userId);



}
