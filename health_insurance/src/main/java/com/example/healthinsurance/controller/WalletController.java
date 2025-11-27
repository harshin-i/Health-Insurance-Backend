package com.example.healthinsurance.controller;

import com.example.healthinsurance.dto.AddWalletRequest;
import com.example.healthinsurance.entity.User;
import com.example.healthinsurance.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
    private final UserService userService;

    public WalletController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMoney(@RequestBody AddWalletRequest req) {

        User user = userService.findById(req.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        user.setWalletBalance(user.getWalletBalance() + req.getAmount());
        userService.save(user);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/balance/{userId}")
    public ResponseEntity<?> balance(@PathVariable Integer userId) {

        User user = userService.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        return ResponseEntity.ok(user.getWalletBalance());
    }
}

