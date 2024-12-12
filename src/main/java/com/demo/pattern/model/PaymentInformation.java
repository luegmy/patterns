package com.demo.pattern.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentInformation {

  private String paymentId;
  private String customerId;
  private String storeId;
  private PaymentType paymentType;
  private BigDecimal amount;
}
