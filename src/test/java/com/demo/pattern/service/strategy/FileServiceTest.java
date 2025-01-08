package com.demo.pattern.service.strategy;

import com.demo.pattern.strategy.file.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class FileServiceTest {

    @Test
    void testFile() {
        SaveFile saveFile = new PdfSaveFileImpl();
        TranslateFile translateFile = new EnglishTranslateFileImpl();
        FileService fileService = new FileService(saveFile, translateFile);

        fileService.setSaveFile(new CsvSaveImpl());

        assertEquals("Saving the file as csv.", fileService.saveFileAs());
        assertEquals("Translating file to English.", fileService.translateFileAs());
    }
}
