package com.example.healthinsurance.controller;

import com.example.healthinsurance.dto.BuyPolicyRequest;
import com.example.healthinsurance.entity.Policy;
import com.example.healthinsurance.entity.User;
import com.example.healthinsurance.service.PlanService;
import com.example.healthinsurance.service.PolicyService;
import com.example.healthinsurance.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    private final UserService userService;
    private final PlanService planService;
    private final PolicyService policyService;

    public PolicyController(UserService userService, PlanService planService, PolicyService policyService) {
        this.userService = userService;
        this.planService = planService;
        this.policyService = policyService;
    }

    @PostMapping("/buy")
    public ResponseEntity<?> buy(@RequestBody BuyPolicyRequest req) {
        User user = userService.findById(req.getUserId()).orElse(null);
        if(user == null) return ResponseEntity.badRequest().body("User not found");

        var plan = planService.findById(req.getPlanId());
        if(plan == null) return ResponseEntity.badRequest().body("Plan not found");

        double premium = plan.getPremium();
        if(user.getWalletBalance() < premium) {
            return ResponseEntity.badRequest().body("Insufficient wallet balance. Required: " + premium);
        }

        user.setWalletBalance(user.getWalletBalance() - premium);
        userService.save(user);

        Policy policy = policyService.createPolicy(user, plan, req.getMonths() == null ? 12 : req.getMonths());
        return ResponseEntity.ok(policy);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> policies(@PathVariable Integer userId) {
        User user = userService.findById(userId).orElse(null);
        if(user == null) return ResponseEntity.badRequest().body("User not found");
        return ResponseEntity.ok(policyService.findByUser(user));
    }
}
