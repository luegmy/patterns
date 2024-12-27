package com.demo.pattern.strategy.file;

public class EnglishTranslateFileImpl implements TranslateFile{
    @Override
    public String translateAs() {
        return "Translating file to English.";
    }
}
