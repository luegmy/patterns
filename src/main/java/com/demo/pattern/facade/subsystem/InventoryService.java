package com.demo.pattern.facade.subsystem;

import com.demo.pattern.model.facade.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

@Primary
@Qualifier
public class InventoryService {
    public boolean isAvailable(Product product){
        /*Check Warehouse database for product availability*/
        return true;
    }
}
