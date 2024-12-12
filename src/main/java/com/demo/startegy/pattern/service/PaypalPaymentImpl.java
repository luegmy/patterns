package com.demo.startegy.pattern.service;

import com.demo.startegy.pattern.model.PaymentInformation;
import com.demo.startegy.pattern.model.PaymentType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Qualifier("PaypalPaymentImpl")
public class PaypalPaymentImpl implements PaymentService {

  @Override
  public PaymentType getPaymentType() {
    return PaymentType.PAYPAL;
  }

  @Override
  public void processPayment(PaymentInformation paymentInformation) {
    process(paymentInformation);
  }

  private void process(PaymentInformation paymentInformation) {
    log.info(String.format("Hello %s from %s", paymentInformation.getCustomerId(), PaypalPaymentImpl.class.getName()));
  }
}
