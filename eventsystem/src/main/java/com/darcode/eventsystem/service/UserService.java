package com.darcode.eventsystem.service;

import com.darcode.eventsystem.model.User;
import com.darcode.eventsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User register(User dto) {
        return userRepository.save(dto);
    }

    public User findByUsername(String username, String password) {
        try {
            Optional<User> userOptional = userRepository.findByUsername(username);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (user.getPassword().equals(password)) {
                    return user;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (DataAccessException e) {
            System.err.println("Error occurred while finding user by username: " + e.getMessage());
            throw new RuntimeException("Error finding user by username: " + e.getMessage());
        }
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
