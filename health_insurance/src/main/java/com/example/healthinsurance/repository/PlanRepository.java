package com.example.healthinsurance.repository;

import com.example.healthinsurance.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
