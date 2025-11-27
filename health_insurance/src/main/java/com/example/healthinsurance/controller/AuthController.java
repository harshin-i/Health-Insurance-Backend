package com.example.healthinsurance.controller;

import com.example.healthinsurance.dto.RegisterRequest;
import com.example.healthinsurance.entity.User;
import com.example.healthinsurance.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if(userService.findByEmail(req.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("Email already exists");
        }
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        u.setWalletBalance(0.0);
        User saved = userService.register(u);
        return ResponseEntity.ok(saved);
    }
}
