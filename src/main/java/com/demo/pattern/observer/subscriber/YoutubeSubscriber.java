package com.demo.pattern.observer.subscriber;

import com.demo.pattern.model.observer.YoutubeEvent;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class YoutubeSubscriber implements Observer {

    private String name;

    @Override
    public void notifyMe(String youtubeChannelName, YoutubeEvent event) {
        System.out.println("Dear " + name + ", Notification from " + youtubeChannelName + ": " + event);
    }

}
