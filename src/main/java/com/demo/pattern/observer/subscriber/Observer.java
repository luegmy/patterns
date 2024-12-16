package com.demo.pattern.observer.subscriber;


import com.demo.pattern.model.observer.YoutubeEvent;

public interface Observer {
    void notifyMe(String youtubeChannelName, YoutubeEvent event);
}
