package com.demo.pattern.model.observer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class YoutubeEvent {
    private EventType eventType;
    private String topic;
}
