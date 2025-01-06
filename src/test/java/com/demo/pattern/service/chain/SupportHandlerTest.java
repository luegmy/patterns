package com.demo.pattern.service.chain;

import com.demo.pattern.chain.support.AdvancedSupportHandler;
import com.demo.pattern.chain.support.BasicSupportHandler;
import com.demo.pattern.chain.support.IntermediateSupportHandler;
import com.demo.pattern.chain.support.SupportHandler;
import com.demo.pattern.model.chain.SupportLevel;
import com.demo.pattern.model.chain.SupportRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class SupportHandlerTest {

    @Spy
    private BasicSupportHandler basicSupportHandler;
    @Spy
    private IntermediateSupportHandler intermediateSupportHandler;
    @Spy
    private AdvancedSupportHandler advancedSupportHandler;

    @BeforeEach
    void setUp() {

        basicSupportHandler.setNextHandler(intermediateSupportHandler);
        intermediateSupportHandler.setNextHandler(advancedSupportHandler);

    }

    @Test
    void testBasic() {

        SupportRequest request = SupportRequest.builder()
                .level(SupportLevel.BASIC)
                .message("Soporte basico")
                .build();
        basicSupportHandler.handleRequest(request);

        verify(basicSupportHandler, times(1)).handleRequest(request);
        verify(intermediateSupportHandler, never()).handleRequest(request);
        verify(advancedSupportHandler, never()).handleRequest(request);
    }

    @Test
    void testIntermediate() {

        SupportRequest request = SupportRequest.builder()
                .level(SupportLevel.INTERMEDIATE)
                .message("Soporte intermedio")
                .build();
        basicSupportHandler.handleRequest(request);

        verify(basicSupportHandler, times(1)).handleRequest(request);
        verify(intermediateSupportHandler, times(1)).handleRequest(request);
        verify(advancedSupportHandler, never()).handleRequest(request);
    }
}
