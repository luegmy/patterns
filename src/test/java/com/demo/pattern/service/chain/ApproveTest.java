package com.demo.pattern.service.chain;

import com.demo.pattern.chain.bank.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ApproveTest {
    @Mock
    private Bank bankSpy;


    @Test
    void testLoanApprovedByExecutive() {

        // Espiamos el objeto interno creado
        doNothing().when(bankSpy).setNext(any(Approve.class));

        bankSpy.loanApplication(30000);

        verify(bankSpy, times(1)).loanApplication(30000);
    }
}
