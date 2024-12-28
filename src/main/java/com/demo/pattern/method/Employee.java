package com.demo.pattern.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Employee extends StaffPayment {
    @Override
    void getSalary() {
        log.info("Calculating base salary. {}:", getSalaryAmount());
    }

    @Override
    void getDeduction() {
        setDeductionAmount(getSalaryAmount() * getDeductionAmount());
        log.info("11% Deduction of ${} is: ${}.", getSalaryAmount(), getDeductionAmount());
    }

    @Override
    double sendPayment() {
        log.info("Printing check.{}:", getSalaryAmount() - getDeductionAmount());
        return getSalaryAmount() - getDeductionAmount();
    }
}
