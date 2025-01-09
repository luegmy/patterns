package com.demo.pattern.strategy.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EnglishTranslateFileImpl implements TranslateFile {
    @Override
    public String translateAs() {
        return "Translating file to English." + EnglishTranslateFileImpl.class.getName();
    }
}
