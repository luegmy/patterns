package com.demo.startegy.pattern.context;

import com.demo.startegy.pattern.model.PaymentInformation;
import com.demo.startegy.pattern.model.PaymentType;
import com.demo.startegy.pattern.service.PaymentService;
import com.demo.startegy.pattern.service.PaypalPaymentImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
