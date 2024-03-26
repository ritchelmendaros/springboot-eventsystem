package com.darcode.eventsystem.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.darcode.eventsystem.model.User;
import com.darcode.eventsystem.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            if (userService.existsByUsername(user.getUsername())) {
                return ResponseEntity.badRequest().body("Username already exists");
            }

            userService.register(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error registering user: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            User existingUser = userService.findByUsername(user.getUsername(), user.getPassword());
            if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid username or password");
            }
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("user_type", existingUser.getUserType());

            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error logging in: " + e.getMessage());
        }
    }

    @PostMapping("/exists")
    public ResponseEntity<?> checkUsernameExists(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        boolean exists = userService.existsByUsername(username);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/getUserId")
    public ResponseEntity<?> getUserId(@RequestParam("username") String username) {
        try {
            Long userId = userService.getUserIdByUsername(username);
            return ResponseEntity.ok(userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving user ID: " + e.getMessage());
        }
    }

    @GetMapping("/getUserDetails")
    public ResponseEntity<?> getUserDetails(@RequestParam("userId") Long userId) {
        try {
            User user = userService.findByUserId(userId);
            if (user != null) {
                User userDetails = new User();
                userDetails.setUserid(user.getUserid());
                userDetails.setFirstname(user.getFirstname());
                userDetails.setLastname(user.getLastname());
                userDetails.setUserType(user.getUserType());

                return ResponseEntity.ok(userDetails);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving user details: " + e.getMessage());
        }
    }

    @PostMapping("/updateUserType")
    public ResponseEntity<?> updateUserType(@RequestBody Map<String, Object> requestData) {
        try {
            Long userId = Long.parseLong(requestData.get("userId").toString());
            Integer userType = Integer.parseInt(requestData.get("userType").toString());

            userService.updateUserType(userId, userType);
            return ResponseEntity.ok("User type updated successfully");
        } catch (NumberFormatException | NullPointerException e) {
            return ResponseEntity.badRequest().body("Invalid userId or userType");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating user type: " + e.getMessage());
        }
    }

}
