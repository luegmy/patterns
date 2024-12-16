package com.demo.pattern.publisher;

import com.demo.pattern.model.observer.YoutubeEvent;
import com.demo.pattern.observer.subscriber.Observer;

import java.util.ArrayList;

public class YoutubeChannel implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private String name;

    public YoutubeChannel(String name) {
        this.name = name;
    }

    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeSubscriber(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllSubscribers(YoutubeEvent event) {
        for (Observer observer : observers) {
            observer.notifyMe(name, event);
        }
    }
}
