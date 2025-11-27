package com.example.healthinsurance.dto;

public class AddWalletRequest {
    private Integer userId;
    private Double amount;

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}
