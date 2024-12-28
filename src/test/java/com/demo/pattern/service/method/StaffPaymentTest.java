package com.demo.pattern.service.method;

import com.demo.pattern.method.Consultant;
import com.demo.pattern.method.StaffPayment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaffPaymentTest {
    @Test
    void testStaffPayment() {
        StaffPayment consultant = new Consultant();
        consultant.setSalaryAmount(1000);
        consultant.setDeductionAmount(0.05);

        assertEquals(950.0, consultant.processPayment());
        assertEquals(1000.0, consultant.getSalaryAmount());
        assertEquals(50.0, consultant.getDeductionAmount());

    }
}
