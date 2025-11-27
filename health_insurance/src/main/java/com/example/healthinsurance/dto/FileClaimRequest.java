package com.example.healthinsurance.dto;

public class FileClaimRequest {
    private Integer policyId;
    private Double amount;

    public Integer getPolicyId() { return policyId; }
    public void setPolicyId(Integer policyId) { this.policyId = policyId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}
