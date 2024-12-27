package com.demo.pattern.strategy.file;

import com.demo.pattern.model.strategy.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class FileService {

    private final SaveFile saveFile;
    private final TranslateFile translateFile;

    public String saveFileAs() {
       return saveFile.saveAs();
    }

    public String translateFileAs(){
        return translateFile.translateAs();
    }

}
