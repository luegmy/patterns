package com.demo.pattern.service.method;

import com.demo.pattern.method.Consultant;
import com.demo.pattern.method.StaffPayment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
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
