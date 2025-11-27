package com.example.healthinsurance.service;

import com.example.healthinsurance.entity.Plan;
import com.example.healthinsurance.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    private final PlanRepository repo;
    public PlanService(PlanRepository repo) { this.repo = repo; }
    public List<Plan> all() { return repo.findAll(); }
    public Plan save(Plan p) { return repo.save(p); }
    public Plan findById(Integer id) { return repo.findById(id).orElse(null); }
}
