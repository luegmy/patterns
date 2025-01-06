package com.demo.pattern.chain.support;

import com.demo.pattern.model.chain.SupportRequest;

public interface SupportHandler {
    void handleRequest(SupportRequest request);
    void setNextHandler(SupportHandler nextHandler);
}
