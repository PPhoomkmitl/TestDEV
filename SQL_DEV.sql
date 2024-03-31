CREATE DATABASE IF NOT EXISTS DBCorebiz;

USE DBCorebiz;

CREATE SCHEMA IF NOT EXISTS partnerbenefit;

CREATE TABLE IF NOT EXISTS partnerbenefit.benefit_master (
    partner_code VARCHAR(7) NOT NULL CHECK (
        partner_code REGEXP '^[0-9]{3}\.[0-9]{3}$'
        AND SUBSTRING(partner_code, 4, 1) = '.'
    ),
      plan_code VARCHAR(4) NOT NULL CHECK (
        (SUBSTRING(plan_code, 1, 2) = 'GI' OR SUBSTRING(plan_code, 1, 2) = 'PT')
        AND SUBSTRING(plan_code, 3) REGEXP '^[0-9]{2}$'
    ),
    policy_no VARCHAR(8) NOT NULL CHECK (policy_no REGEXP '^[0-9]{8}$'),
   temp_policy_no VARCHAR(8) CHECK (
        (SUBSTRING(temp_policy_no, 1, 2) = 'VL' OR SUBSTRING(temp_policy_no, 1, 2) = 'UI')
        AND SUBSTRING(temp_policy_no, 3) REGEXP '^[0-9]{6}$'
    ),
    mode ENUM('0', '1', '2', '3', '4', '5', '6', '7', '8', '9') NOT NULL,
    pay_period VARCHAR(4) NOT NULL CHECK (pay_period REGEXP '^[0-9]{4}$'),
    policy_status ENUM('A', 'I', 'C'),
    policy_status_date DATE NOT NULL,
    sum INT NOT NULL
);

INSERT INTO partnerbenefit.benefit_master (partner_code, plan_code, policy_no, temp_policy_no, mode, pay_period, policy_status, policy_status_date, sum) VALUES
('123.456', 'GI01', '12345678', 'VL123456', '0', '0521', 'A', '2024-03-31', 4100),
('234.567', 'PT02', '23456789', NULL, '1', '0124', 'I', '2023-03-31', 5000),
('071.678', 'GI03', '34567890', 'UI234567', '2', '0344', 'C', '2022-05-18', 11300),
('456.789', 'PT04', '45678901', NULL, '3', '0122', 'A', '2020-03-31', 1400),
('567.890', 'GI05', '56789012', 'VL345678', '4', '0234', 'I', '2020-03-25', 15000),
('678.901', 'PT06', '67890123', NULL, '5', '0125', 'C', '2019-03-17', 51000),
('789.012', 'GI07', '78901234', 'UI456789', '6', '0482', 'A', '2019-03-15', 70000),
('071.123', 'PT08', '89012345', NULL, '7', '0247', 'I', '2019-03-18', 400800);

/*ข้อที่ 1*/
SELECT * FROM partnerbenefit.benefit_master
WHERE partner_code LIKE '071.%';

/*ข้อที่ 2*/
SELECT * FROM partnerbenefit.benefit_master
WHERE policy_status_date >= '2020-01-01' AND policy_status_date <= '2020-12-31';

/*ข้อที่ 3*/
SELECT * FROM partnerbenefit.benefit_master
WHERE sum >= 100000 AND sum <= 500000;




