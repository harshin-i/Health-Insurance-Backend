package com.example.healthinsurance.service;

import com.example.healthinsurance.entity.User;
import com.example.healthinsurance.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repo) { this.userRepository = repo; }

    public User register(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(Integer id) { return userRepository.findById(id); }
    public Optional<User> findByEmail(String email) { return userRepository.findByEmail(email); }
    public List<User> findAll() { return userRepository.findAll(); }

    public User save(User u) { return userRepository.save(u); }
}
