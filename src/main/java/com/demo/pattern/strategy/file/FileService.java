package com.demo.pattern.strategy.file;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Setter
@Component
public class FileService {

    private SaveFile saveFile;
    private TranslateFile translateFile;

    public String saveFileAs() {
       return saveFile.saveAs();
    }

    public String translateFileAs(){
        return translateFile.translateAs();
    }

}
