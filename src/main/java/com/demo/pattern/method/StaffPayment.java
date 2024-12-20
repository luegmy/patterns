package com.demo.pattern.method;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
public abstract class StaffPayment {
    private double salaryAmount;
    private double deductionAmount;

    public final void processPayment() {
        // call specific steps to process the payment
        getSalary();
        getDeduction();
        sendPayment();
        notifyAccountant();
        sendPaymentCopy();
    }

    abstract void getSalary();
    abstract void getDeduction();
    abstract void sendPayment();

    final void notifyAccountant() {
        log.info("Sending notification to Accountant Department.");
    }
    void sendPaymentCopy() {
        log.info("No copy needed by default.");
    }
}
