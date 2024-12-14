package com.demo.pattern;

import com.demo.pattern.context.PaymentContext;
import com.demo.pattern.model.observer.EventType;
import com.demo.pattern.model.observer.YoutubeEvent;
import com.demo.pattern.model.strategy.PaymentInformation;
import com.demo.pattern.model.strategy.PaymentType;
import com.demo.pattern.publisher.Subject;
import com.demo.pattern.publisher.YoutubeChannel;
import com.demo.pattern.subscriber.Observer;
import com.demo.pattern.subscriber.YoutubeSubscriber;
import org.junit.jupiter.api.Test;
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

	@Test
	public void testObserver() throws Exception {
		Subject subject = new YoutubeChannel("MyChannel");

		Observer john = new YoutubeSubscriber("John");
		Observer bob = new YoutubeSubscriber("Bob");
		Observer tom = new YoutubeSubscriber("Tom");

		subject.addSubscriber(john);
		subject.addSubscriber(bob);
		subject.addSubscriber(tom);

		subject.notifyAllSubscribers(new YoutubeEvent(EventType.NEW_VIDEO, "Design patterns"));
		subject.removeSubscriber(tom);


		System.out.println();
		Thread.sleep(5000);
		subject.notifyAllSubscribers(new YoutubeEvent(EventType.LIVE_STREAM, "JAVA for beginners"));
	}

}
