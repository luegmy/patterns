package com.demo.pattern.context;

import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
import com.demo.pattern.strategy.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentContextImpl implements PaymentContext {

    private Map<PaymentType, PaymentService> paymentServiceByPaymentType;

    public PaymentContextImpl(List<PaymentService> paymentServices) {
        this.paymentServiceByPaymentType = paymentServices.stream()
                .collect(Collectors.toMap(PaymentService::getPaymentType, Function.identity()));
    }

    @Override
    public void validateAndProcessPayment(PaymentInformation paymentInformation) {
        PaymentType type = paymentInformation.getPaymentType();

        PaymentService paymentService = paymentServiceByPaymentType.get(type);
        paymentService.processPayment(paymentInformation);

    }
}
