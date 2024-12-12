package com.demo.startegy.pattern.service;


import com.demo.startegy.pattern.model.PaymentInformation;

public interface PaymentService {

  void processPayment(PaymentInformation paymentInformation);
}
