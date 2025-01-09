package com.demo.pattern.service.chain;

import com.demo.pattern.chain.bank.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApproveTest {
    @Mock
    private Approve approve;

    @InjectMocks
    private Bank bank;


    @Test
    void testLoanApprovedByExecutive() {

        bank.loanApplication(3000000);

        verify(approve, times(0)).loanApplication(30000);
    }
}
