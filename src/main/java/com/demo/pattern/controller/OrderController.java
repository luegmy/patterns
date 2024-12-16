package com.demo.pattern.controller;

import com.demo.pattern.facade.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/pattern")
@Slf4j
public class OrderController {
    OrderService orderService;
    boolean orderFulfilled = false;

    public void orderProduct(int productId) {
        orderFulfilled = orderService.placeOrder(productId);
        log.info("OrderFulfillmentController: Order fulfillment completed. ");
    }
}
