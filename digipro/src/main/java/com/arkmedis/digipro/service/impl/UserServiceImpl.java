package com.arkmedis.digipro.service.impl;



import com.arkmedis.digipro.dto.LoginResponse;
import com.arkmedis.digipro.entity.User;
import com.arkmedis.digipro.repository.UserRepository;
import com.arkmedis.digipro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arkmedis.digipro.dto.LoginRequest;


import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }



    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByRole(User.Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> getUsersByTeamId(Long teamId) {
        return userRepository.findByTeamTeamId(teamId);
    }

    @Override
    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameIgnoreCaseContaining(name);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    public LoginResponse login(LoginRequest loginRequest) {
//        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
//        if (userOptional.isEmpty()) {
//            throw new RuntimeException("Invalid email or password");
//        }
//
//        User user = userOptional.get();
//
//        // Plaintext password check (replace with encryption logic if necessary)
//        if (!user.getPassword().equals(loginRequest.getPassword())) {
//            throw new RuntimeException("Invalid email or password");
//        }
//
//        // Build the response
//        LoginResponse response = new LoginResponse();
//        response.setMessage("Login successful");
//        response.setUserId(user.getUserId());
//        response.setName(user.getName());
//        response.setEmail(user.getEmail());
//        response.setRole(user.getRole());
//
//        return response;
//    }


    public User login(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        User user = userOptional.get();

        // Assuming you have some method to check the password
        if (!checkPassword(user, loginRequest.getPassword())) {
            throw new RuntimeException("Invalid credentials!");
        }

        // Ensure role is correctly handled (if necessary for your logic)
        User.Role role = user.getRole();  // Role is already set properly when the user is retrieved

        // Return the user or any other response you want
        return user;  // or create a custom response DTO to include role, email, etc.
    }

    private boolean checkPassword(User user, String password) {
        // Implement password check (e.g., using bcrypt or plain comparison)
        return user.getPassword().equals(password); // Just a placeholder
    }



}
