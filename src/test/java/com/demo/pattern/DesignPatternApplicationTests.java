package com.demo.pattern;

import com.demo.pattern.context.PaymentContext;
import com.demo.pattern.controller.OrderController;
import com.demo.pattern.facade.OrderService;
import com.demo.pattern.facade.OrderServiceImpl;
import com.demo.pattern.facade.subsystem.InventoryService;
import com.demo.pattern.facade.subsystem.PaymentService;
import com.demo.pattern.facade.subsystem.ShippingService;
import com.demo.pattern.model.facade.Product;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DesignPatternApplicationTests {


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
