package com.demo.pattern.strategy.file;

import com.demo.pattern.model.strategy.FileType;
import org.springframework.stereotype.Service;

@Service
public class CsvSaveImpl implements SaveFile{
    @Override
    public String saveAs() {
        return "Saving the file as csv.";
    }

}
