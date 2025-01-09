package com.demo.pattern.strategy.file;

import com.demo.pattern.model.strategy.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PdfSaveFileImpl implements SaveFile {
    @Override
    public String saveAs() {
        return "Saving the file as pdf." + PdfSaveFileImpl.class.getName();
    }

}
