package com.example.healthinsurance.scheduler;

import com.example.healthinsurance.entity.Policy;
import com.example.healthinsurance.service.PolicyService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PolicyScheduler {
    private final PolicyService policyService;

    public PolicyScheduler(PolicyService policyService) { this.policyService = policyService; }

    @Scheduled(fixedRate = 60000)
    public void checkExpiredPolicies() {
        LocalDate today = LocalDate.now();
        List<Policy> expired = policyService.findExpiredBefore(today);
        if(!expired.isEmpty()) {
            System.out.println("Expired policies count: " + expired.size());
            expired.forEach(p -> System.out.println("Expired policy id: " + p.getId() + " user: " + p.getUser().getEmail()));
        }
    }
}
