package com.example.healthinsurance.controller;

import com.example.healthinsurance.entity.Plan;
import com.example.healthinsurance.service.PlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
    private final PlanService planService;
    public PlanController(PlanService planService) { this.planService = planService; }

    @GetMapping
    public ResponseEntity<List<Plan>> all() {
        return ResponseEntity.ok(planService.all());
    }

    @PostMapping
    public ResponseEntity<Plan> create(@RequestBody Plan plan) {
        return ResponseEntity.ok(planService.save(plan));
    }
}
