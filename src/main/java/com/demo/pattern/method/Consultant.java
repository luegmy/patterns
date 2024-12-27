package com.demo.pattern.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Consultant extends StaffPayment{
    public Consultant(double salaryAmount, double deductionAmount) {
        super(salaryAmount, deductionAmount);
    }

    @Override
    void getSalary() {
        log.info("Calculating hourly salary.");
    }

    @Override
    void getDeduction() {
        setDeductionAmount(getSalaryAmount()*getDeductionAmount());
        log.info("5% Deduction of ${} is: ${}.", getSalaryAmount(), getDeductionAmount());
    }

    @Override
    void sendPayment() {
        log.info("Printing check.");
    }

    @Override
    void sendPaymentCopy() {
        log.info("Sending payment copy via email.");
    }
}
