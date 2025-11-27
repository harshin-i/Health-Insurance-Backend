package com.example.healthinsurance.service;

import com.example.healthinsurance.entity.Policy;
import com.example.healthinsurance.entity.User;
import com.example.healthinsurance.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PolicyService {
    private final PolicyRepository repo;
    public PolicyService(PolicyRepository repo) { this.repo = repo; }

    public Policy createPolicy(User user, com.example.healthinsurance.entity.Plan plan, int months) {
        LocalDate now = LocalDate.now();
        Policy p = new Policy();
        p.setUser(user);
        p.setPlan(plan);
        p.setPurchaseDate(now);
        p.setExpiryDate(now.plusMonths(months));
        return repo.save(p);
    }

    public List<Policy> findByUser(User user) { return repo.findByUser(user); }

    public java.util.List<Policy> findExpiredBefore(LocalDate date) { return repo.findByExpiryDateBefore(date); }
}
