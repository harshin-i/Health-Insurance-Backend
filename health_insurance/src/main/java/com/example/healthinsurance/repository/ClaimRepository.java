package com.example.healthinsurance.repository;

import com.example.healthinsurance.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
    List<Claim> findByStatus(String status);
    List<Claim> findByPolicyUserId(Integer userId);
}
