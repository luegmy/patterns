package com.demo.pattern.model.chain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SupportRequest {
    private SupportLevel level;
    private String message;
}
