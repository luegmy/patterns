package com.demo.pattern.facade;

import com.demo.pattern.facade.subsystem.InventoryService;
import com.demo.pattern.facade.subsystem.PaymentService;
import com.demo.pattern.facade.subsystem.ShippingService;
import com.demo.pattern.model.facade.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;
    @Override
    public boolean placeOrder(int productId) {
        boolean orderFulfilled = false;
        Product product = new Product();
        product.setProductId(productId);
        if (inventoryService.isAvailable(product)) {
            log.info("Product with ID: " + product.getProductId() + " is available.");
            boolean paymentConfirmed = paymentService.makePayment();
            if (paymentConfirmed) {
                log.info("Payment confirmed...");
                shippingService.shipProduct(product);
                log.info("Product shipped...");
                orderFulfilled = true;
            }
        }
        return orderFulfilled;
    }
}
