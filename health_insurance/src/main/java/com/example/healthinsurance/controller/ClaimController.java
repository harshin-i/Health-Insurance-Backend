package com.example.healthinsurance.controller;

import com.example.healthinsurance.dto.FileClaimRequest;
import com.example.healthinsurance.entity.Claim;
import com.example.healthinsurance.entity.Policy;
import com.example.healthinsurance.repository.PolicyRepository;
import com.example.healthinsurance.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    private final ClaimService claimService;
    private final PolicyRepository policyRepository;

    public ClaimController(ClaimService claimService, PolicyRepository policyRepository) {
        this.claimService = claimService;
        this.policyRepository = policyRepository;
    }

    @PostMapping("/file")
    public ResponseEntity<?> fileClaim(@RequestBody FileClaimRequest req) {
        Policy policy = policyRepository.findById(req.getPolicyId()).orElse(null);
        if (policy == null) return ResponseEntity.badRequest().body("Policy not found");
        Claim c = claimService.fileClaim(policy, req.getAmount());
        return ResponseEntity.ok(c);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> userClaims(@PathVariable Integer userId) {
        return ResponseEntity.ok(claimService.findByUserId(userId));
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<?> approve(@PathVariable Integer id) {
        Claim c = claimService.findById(id);
        if (c == null) return ResponseEntity.badRequest().body("Claim not found");
        c.setStatus("APPROVED");
        claimService.save(c);
        return ResponseEntity.ok(c);
    }

    @PostMapping("/reject/{id}")
    public ResponseEntity<?> reject(@PathVariable Integer id) {
        Claim c = claimService.findById(id);
        if (c == null) return ResponseEntity.badRequest().body("Claim not found");
        c.setStatus("REJECTED");
        claimService.save(c);
        return ResponseEntity.ok(c);
    }
}
