-- Create USERS table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    wallet_balance DECIMAL(10,2) DEFAULT 0
);

-- Create PLANS table
CREATE TABLE IF NOT EXISTS plans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    premium DECIMAL(10,2) NOT NULL,
    coverage_amount DECIMAL(10,2) NOT NULL
);

-- Create POLICIES table
CREATE TABLE IF NOT EXISTS policies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    plan_id INT NOT NULL,
    purchase_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (plan_id) REFERENCES plans(id)
);

-- Create CLAIMS table
CREATE TABLE IF NOT EXISTS claims (
    id INT AUTO_INCREMENT PRIMARY KEY,
    policy_id INT NOT NULL,
    request_date DATE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (policy_id) REFERENCES policies(id)
);

-- Insert sample plans
INSERT INTO plans (name, premium, coverage_amount) VALUES ('Basic Health Plan', 500, 50000);
INSERT INTO plans (name, premium, coverage_amount) VALUES ('Gold Plan', 1000, 150000);
INSERT INTO plans (name, premium, coverage_amount) VALUES ('Family Health Plan', 1500, 300000);
