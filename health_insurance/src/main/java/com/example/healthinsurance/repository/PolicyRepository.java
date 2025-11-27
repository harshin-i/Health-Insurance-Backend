package com.example.healthinsurance.repository;

import com.example.healthinsurance.entity.Policy;
import com.example.healthinsurance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
    List<Policy> findByUser(User user);
    List<Policy> findByExpiryDateBefore(LocalDate date);
}
