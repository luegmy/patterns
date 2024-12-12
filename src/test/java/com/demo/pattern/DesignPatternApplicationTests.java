package com.demo.pattern;

import com.demo.pattern.context.PaymentContext;
import com.demo.pattern.model.PaymentInformation;
import com.demo.pattern.model.PaymentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class DesignPatternApplicationTests {

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
