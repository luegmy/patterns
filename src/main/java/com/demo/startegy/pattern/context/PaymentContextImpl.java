package com.demo.startegy.pattern.context;

import com.demo.startegy.pattern.model.PaymentInformation;
import com.demo.startegy.pattern.model.PaymentType;
import com.demo.startegy.pattern.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentContextImpl implements PaymentContext {
    @Qualifier("CashPaymentImpl")
    @Autowired
    private PaymentService cashPaymentService;
    @Qualifier("PaypalPaymentImpl")
    @Autowired
    private PaymentService paypalPaymentService;
    @Qualifier("PsePaymentImpl")
    @Autowired
    private PaymentService psePaymentService;

    @Override
    public void validateAndProcessPayment(PaymentInformation paymentInformation) {
        PaymentType type = paymentInformation.getPaymentType();

        if (PaymentType.CASH.equals(type)) cashPaymentService.processPayment(paymentInformation);
        else if (PaymentType.PAYPAL.equals(type)) paypalPaymentService.processPayment(paymentInformation);
        else if (PaymentType.PSE.equals(type)) psePaymentService.processPayment(paymentInformation);

    }
}
