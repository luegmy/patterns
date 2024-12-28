package com.demo.pattern.method;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public abstract class StaffPayment {
    private double salaryAmount;
    private double deductionAmount;

    public final double processPayment() {
        // call specific steps to process the payment
        getSalary();
        getDeduction();
        notifyAccountant();
        sendPaymentCopy();
        return sendPayment();
    }

    abstract void getSalary();
    abstract void getDeduction();
    abstract double sendPayment();

    final void notifyAccountant() {
        log.info("Sending notification to Accountant Department.");
    }
    void sendPaymentCopy() {
        log.info("No copy needed by default.");
    }
}
