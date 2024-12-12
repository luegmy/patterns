package com.demo.pattern.service;

import com.demo.pattern.model.PaymentInformation;
import com.demo.pattern.model.PaymentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Qualifier("PsePaymentImpl")
public class PsePaymentImpl implements PaymentService {

  @Override
  public PaymentType getPaymentType() {
    return PaymentType.PSE;
  }

  @Override
  public void processPayment(PaymentInformation paymentInformation) {
    process(paymentInformation);
  }

  private void process(PaymentInformation paymentInformation) {
    log.info(String.format("Hello %s from %s", paymentInformation.getCustomerId(), PsePaymentImpl.class.getName()));
  }
}
