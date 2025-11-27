# 🏥 Health Insurance Backend (Spring Boot)

A simple **Fintech + Healthcare** backend application built using **Spring Boot**, demonstrating:

- User registration & authentication
- Wallet top-up (Fintech feature)
- Health insurance plans
- Buying insurance policies
- Filing & approving claims
- Auto-schedulers for policy expiry + pending claims
- H2 database (in-memory)
- REST API architecture

This project is beginner-friendly and suitable for interviews, assignments, and portfolio demos.

---

## 🚀 Features

### 👤 User Module
- Register new user
- View wallet balance
- Add money to wallet (fintech style)

### 🛡️ Insurance Plans
- Preloaded dataset using `schema.sql`
- API to fetch all plans

### 📄 Policy Management
- Buy a health insurance policy
- View user's policies
- Expiry handled by a scheduled job

### 💰 Claims Processing
- File a claim for a policy
- Approve / reject claims
- List claims for each user
- Scheduler logs pending claims every minute

### 🗄 Database
- H2 in-memory DB
- Auto-creates tables using `schema.sql`
- No installation required

---

## 🛠 Tech Stack

src/main/java/com/example/healthinsurance/
  controller/
    AuthController.java
    WalletController.java
    PlanController.java
    PolicyController.java
    ClaimController.java

  entity/
    User.java
    Plan.java
    Policy.java
    Claim.java

  service/
    UserService.java
    PlanService.java
    PolicyService.java
    ClaimService.java

  repository/
    UserRepository.java
    PlanRepository.java
    PolicyRepository.java
    ClaimRepository.java

  scheduler/
    PolicyScheduler.java
    ClaimScheduler.java

  HealthInsuranceApplication.java


--

