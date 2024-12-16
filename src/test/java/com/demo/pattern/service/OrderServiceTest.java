package com.demo.pattern.service;

import com.demo.pattern.facade.OrderServiceImpl;
import com.demo.pattern.facade.subsystem.InventoryService;
import com.demo.pattern.facade.subsystem.PaymentService;
import com.demo.pattern.facade.subsystem.ShippingService;
import com.demo.pattern.model.facade.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@SpringBootTest
public class OrderServiceTest {
    @Mock
    InventoryService inventoryService;
    @Mock
    PaymentService paymentService;
    @Mock
    ShippingService shippingService;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void testOrderProduct() {

        when(inventoryService.isAvailable(any(Product.class))).thenReturn(true);
        when(paymentService.makePayment()).thenReturn(true);
        doNothing().when(shippingService).shipProduct(any(Product.class));

        boolean result = orderService.placeOrder(24);

        assertTrue(result);
    }
}
