package com.demo.pattern.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public enum PaymentType {
    CASH, PAYPAL, PSE
}