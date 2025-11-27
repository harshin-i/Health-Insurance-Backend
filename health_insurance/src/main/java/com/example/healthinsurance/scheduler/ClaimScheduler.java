package com.example.healthinsurance.scheduler;

import com.example.healthinsurance.entity.Claim;
import com.example.healthinsurance.service.ClaimService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClaimScheduler {
    private final ClaimService claimService;

    public ClaimScheduler(ClaimService claimService) { this.claimService = claimService; }

    @Scheduled(fixedRate = 60000)
    public void checkPendingClaims() {
        List<Claim> pending = claimService.findPending();
        if(!pending.isEmpty()) {
            System.out.println("Pending claims: " + pending.size());
            pending.forEach(c -> System.out.println("Pending claim id: " + c.getId() + " policyId: " + c.getPolicy().getId()));
        }
    }
}
