package com.example.healthinsurance.service;

import com.example.healthinsurance.entity.Claim;
import com.example.healthinsurance.entity.Policy;
import com.example.healthinsurance.repository.ClaimRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClaimService {
    private final ClaimRepository repo;

    public ClaimService(ClaimRepository repo) {
        this.repo = repo;
    }

    public Claim fileClaim(Policy policy, Double amount) {
        Claim c = new Claim();
        c.setPolicy(policy);
        c.setAmount(amount);
        c.setRequestDate(LocalDate.now());
        c.setStatus("PENDING");
        return repo.save(c);
    }

    public List<Claim> findPending() { return repo.findByStatus("PENDING"); }
    public Claim findById(Integer id) { return repo.findById(id).orElse(null); }
    public Claim save(Claim c) { return repo.save(c); }
    public List<Claim> findByUserId(Integer userId) { return repo.findByPolicyUserId(userId); }
}
