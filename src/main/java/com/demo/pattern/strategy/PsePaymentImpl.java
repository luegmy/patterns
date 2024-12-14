package com.demo.pattern.strategy;

<<<<<<< HEAD:src/main/java/com/demo/pattern/strategy/PsePaymentImpl.java
import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
=======
import com.demo.startegy.pattern.model.PaymentInformation;
import com.demo.startegy.pattern.model.PaymentType;
import lombok.RequiredArgsConstructor;
>>>>>>> origin/develop:src/main/java/com/demo/startegy/pattern/service/PsePaymentImpl.java
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
