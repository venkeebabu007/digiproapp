package com.arkmedis.digipro.controller;


import com.arkmedis.digipro.dto.LoginRequest;
import com.arkmedis.digipro.dto.LoginResponse;
import com.arkmedis.digipro.entity.User;
import com.arkmedis.digipro.service.UserService;
import com.arkmedis.digipro.service.impl.UserServiceImpl;
import com.arkmedis.digipro.utility.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create or update a user
    @PostMapping
    public ResponseEntity<User> saveOrUpdateUser(@RequestBody User user) {
        User savedUser = userService.saveOrUpdateUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get users by role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable User.Role role) {
        List<User> users = userService.getUsersByRole(role);
        return ResponseEntity.ok(users);
    }

    // Search users by name
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsersByName(@RequestParam String name) {
        List<User> users = userService.searchUsersByName(name);
        return ResponseEntity.ok(users);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        User user = userServiceImpl.login(loginRequest);
        return ResponseEntity.ok(user);  // You can also return a custom response DTO
    }

//    // Authenticate user
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
//        Optional<User> user = userService.getUserByEmail(loginRequest.getEmail());
//        if (user.isPresent() && userService.checkPassword(loginRequest.getPassword(), user.get().getPassword())) {
//            // You can create and return a token here for stateless sessions (JWT)
//            return ResponseEntity.ok(user.get());
//        } else {
//            return ResponseEntity.status(401).body("Invalid email or password.");
//        }
//    }



}
