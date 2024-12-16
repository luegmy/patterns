package com.demo.pattern;

import com.demo.pattern.model.observer.EventType;
import com.demo.pattern.model.observer.YoutubeEvent;
import com.demo.pattern.observer.publisher.Subject;
import com.demo.pattern.observer.publisher.YoutubeChannel;
import com.demo.pattern.observer.subscriber.Observer;
import com.demo.pattern.observer.subscriber.YoutubeSubscriber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


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
