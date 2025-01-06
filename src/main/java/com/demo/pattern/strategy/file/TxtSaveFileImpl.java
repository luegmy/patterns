package com.demo.pattern.strategy.file;

import com.demo.pattern.model.strategy.FileType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service()
@Primary
public class TxtSaveFileImpl implements SaveFile {

    @Override
    public String saveAs() {
        return "Saving the file as txt.";
    }

}
