package com.demo.pattern.chain.support;

import com.demo.pattern.model.chain.SupportLevel;
import com.demo.pattern.model.chain.SupportRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Setter
public class IntermediateSupportHandler implements SupportHandler{
    private SupportHandler nextHandler;
    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getLevel() == SupportLevel.INTERMEDIATE) {
            System.out.println("Intermediate support handling request: " + request.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
