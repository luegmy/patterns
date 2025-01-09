package com.demo.pattern.strategy.file;

import com.demo.pattern.model.strategy.FileType;
import com.demo.pattern.strategy.payment.CashPaymentImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class CsvSaveImpl implements SaveFile {
    @Override
    public String saveAs() {
        return "Saving the file as csv." + CsvSaveImpl.class.getName();
    }

}
