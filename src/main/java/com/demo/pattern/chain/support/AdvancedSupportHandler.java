package com.demo.pattern.chain.support;

import com.demo.pattern.model.chain.SupportLevel;
import com.demo.pattern.model.chain.SupportRequest;
import lombok.Setter;

@Setter
public class AdvancedSupportHandler implements SupportHandler{
    private SupportHandler nextHandler;
    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getLevel() == SupportLevel.ADVANCED) {
            System.out.println("Advanced support handling request: " + request.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
