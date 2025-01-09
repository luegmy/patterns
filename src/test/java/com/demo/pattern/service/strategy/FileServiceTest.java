package com.demo.pattern.service.strategy;

import com.demo.pattern.strategy.file.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileServiceTest {

    @Mock
    SaveFile saveFile;
    @Mock
    TranslateFile translateFile;

    @InjectMocks
    FileService fileService;

    @Test
    void testFile() {

        when(saveFile.saveAs()).thenReturn("Saving the file as csv.");
        when(translateFile.translateAs()).thenReturn("Translating file to English.");

        String response= fileService.saveFileAs();
        String response2= fileService.translateFileAs();

        assertEquals("Saving the file as csv.", response);
        assertEquals("Translating file to English.", response2);

        verify(translateFile,times(1)).translateAs();
        verify(saveFile,times(1)).saveAs();
    }
}
