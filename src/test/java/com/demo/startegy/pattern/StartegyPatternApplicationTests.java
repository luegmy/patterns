package com.demo.startegy.pattern;

import com.demo.startegy.pattern.context.PaymentContext;
import com.demo.startegy.pattern.model.PaymentInformation;
import com.demo.startegy.pattern.model.PaymentType;
import com.demo.startegy.pattern.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StartegyPatternApplicationTests {

	@SpyBean
	private PaymentContext paymentContext;

	@ParameterizedTest
	@EnumSource(value = PaymentType.class, names = {"CASH", "PAYPAL", "PSE"})
	void When_ProcessingPayment_Expect_CorrectOutput(PaymentType paymentType) {
		PaymentInformation paymentInformation = PaymentInformation.builder()
				.paymentType(paymentType)
				.customerId("Test")
				.build();

		paymentContext.validateAndProcessPayment(paymentInformation);

		verify(paymentContext, atMostOnce()).validateAndProcessPayment(any(PaymentInformation.class));
	}

}
