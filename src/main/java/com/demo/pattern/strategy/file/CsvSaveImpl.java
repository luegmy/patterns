package com.demo.pattern.strategy.file;

import com.demo.pattern.model.strategy.FileType;

public class CsvSaveImpl implements SaveFile{
    @Override
    public String saveAs() {
        return "Saving the file as csv.";
    }

}
