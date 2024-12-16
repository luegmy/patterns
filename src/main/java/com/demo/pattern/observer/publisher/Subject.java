package com.demo.pattern.observer.publisher;

import com.demo.pattern.model.observer.YoutubeEvent;
import com.demo.pattern.observer.subscriber.Observer;

public interface Subject {
    void addSubscriber(Observer observer);
    void removeSubscriber(Observer observer);
    void notifyAllSubscribers(YoutubeEvent event);
}
