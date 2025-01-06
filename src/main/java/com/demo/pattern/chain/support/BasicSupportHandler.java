package com.demo.pattern.chain.support;

import com.demo.pattern.model.chain.SupportLevel;
import com.demo.pattern.model.chain.SupportRequest;
import lombok.Getter;
import lombok.Setter;

@Setter
public class BasicSupportHandler implements SupportHandler {

    private SupportHandler nextHandler;
    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getLevel() == SupportLevel.BASIC) {
            System.out.println("Basic support handling request: " + request.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
