package com.demo.startegy.pattern.service;

import com.demo.startegy.pattern.model.PaymentInformation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Qualifier("CashPaymentImpl")
@Primary
public class CashPaymentImpl implements PaymentService {

  @Override
  public void processPayment(PaymentInformation paymentInformation) {
    process(paymentInformation);
  }

  private void process(PaymentInformation paymentInformation) {
    log.info(String.format("Hello %s from %s", paymentInformation.getCustomerId(), CashPaymentImpl.class.getName()));
  }
}
