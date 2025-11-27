package com.example.healthinsurance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "plans")
public class Plan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double premium;
    private Double coverageAmount;

    public Plan() {}

    public Plan(Integer id, String name, Double premium, Double coverageAmount) {
        this.id = id;
        this.name = name;
        this.premium = premium;
        this.coverageAmount = coverageAmount;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPremium() { return premium; }
    public void setPremium(Double premium) { this.premium = premium; }

    public Double getCoverageAmount() { return coverageAmount; }
    public void setCoverageAmount(Double coverageAmount) { this.coverageAmount = coverageAmount; }
}
