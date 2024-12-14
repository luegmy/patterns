package com.demo.pattern.model.observer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum EventType {
    NEW_VIDEO,
    LIVE_STREAM
}
