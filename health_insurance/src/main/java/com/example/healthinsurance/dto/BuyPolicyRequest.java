package com.example.healthinsurance.dto;

public class BuyPolicyRequest {
    private Integer userId;
    private Integer planId;
    private Integer months;

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getPlanId() { return planId; }
    public void setPlanId(Integer planId) { this.planId = planId; }

    public Integer getMonths() { return months; }
    public void setMonths(Integer months) { this.months = months; }
}
