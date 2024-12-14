package com.demo.pattern.model.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public enum PaymentType {
    CASH, PAYPAL, PSE
}
