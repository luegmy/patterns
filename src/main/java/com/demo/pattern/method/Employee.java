<<<<<<< HEAD
package com.demo.pattern.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Employee extends StaffPayment{
    public Employee(double salaryAmount, double deductionAmount) {
        super(salaryAmount, deductionAmount);
    }

    @Override
    void getSalary() {
        log.info("Calculating base salary.");
    }

    @Override
    void getDeduction() {
        setDeductionAmount(getSalaryAmount()*getDeductionAmount());
        log.info("11% Deduction of ${} is: ${}.", getSalaryAmount(), getDeductionAmount());
    }

    @Override
    void sendPayment() {
        log.info("Transferring payment to account.");
    }
=======
package com.demo.pattern.method;public class Employee {
>>>>>>> develop
}
