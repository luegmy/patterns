package com.demo.pattern.strategy;

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
public class PaymentContextImpl implements PaymentContext {

    private List<PaymentService> paymentServices;
    private Map<PaymentType, PaymentService> paymentServiceByPaymentType;

    @Override
    public void validateAndProcessPayment(PaymentInformation paymentInformation) {
        paymentServiceByPaymentType = paymentServices.stream()
                .collect(Collectors.toMap(PaymentService::getPaymentType, Function.identity()));
        log.info("Map{}:", paymentServiceByPaymentType);
        PaymentType type = paymentInformation.getPaymentType();
        log.info("Type{}:", type);
        PaymentService paymentService = paymentServiceByPaymentType.get(type);
        log.info("ServiceType{}:", paymentService);
        paymentService.processPayment(paymentInformation);

    }
}
