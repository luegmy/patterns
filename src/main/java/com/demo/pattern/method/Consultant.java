package com.demo.pattern.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Consultant extends StaffPayment {

    @Override
    void getSalary() {
        log.info("Calculating hourly salary. {}:", getSalaryAmount());
    }

    @Override
    void getDeduction() {
        setDeductionAmount(getSalaryAmount() * getDeductionAmount());
        log.info("5% Deduction of ${} is: ${}.", getSalaryAmount(), getDeductionAmount());
    }

    @Override
    double sendPayment() {
        log.info("Printing check.{}:", getSalaryAmount() - getDeductionAmount());
        return getSalaryAmount() - getDeductionAmount();
    }

    @Override
    void sendPaymentCopy() {
        log.info("Sending payment copy via email.");
    }
}
