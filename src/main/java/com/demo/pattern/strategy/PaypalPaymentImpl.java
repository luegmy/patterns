package com.demo.pattern.strategy;

<<<<<<< HEAD:src/main/java/com/demo/pattern/strategy/PaypalPaymentImpl.java
import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
=======
import com.demo.startegy.pattern.model.PaymentInformation;
import com.demo.startegy.pattern.model.PaymentType;
import lombok.RequiredArgsConstructor;
>>>>>>> origin/develop:src/main/java/com/demo/startegy/pattern/service/PaypalPaymentImpl.java
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
