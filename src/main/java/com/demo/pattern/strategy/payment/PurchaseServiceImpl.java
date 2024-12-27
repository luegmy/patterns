package com.demo.pattern.strategy.payment;

import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private List<Payment> payments;
    private Map<PaymentType, Payment> paymentServiceByPaymentType;

    @Override
    public void validateAndProcessPayment(PaymentInformation paymentInformation) {
        paymentServiceByPaymentType = payments.stream()
                .collect(Collectors.toMap(Payment::getPaymentType, Function.identity()));
        Payment payment = paymentServiceByPaymentType.get(paymentInformation.getPaymentType());
        payment.processPayment(paymentInformation);

    }
}
