package com.gautam.SOPE.orderengine.controller;

import com.gautam.SOPE.orderengine.model.Order;
import com.gautam.SOPE.orderengine.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final PaymentService paymentService;

    public OrderController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam String type, @RequestParam BigDecimal amount) {
        paymentService.checkout(type, amount);

        // Simulation
        Order order = new Order();
        order.printStatus(); // Output: Order is currently in [NEW] state...

        order.nextState();   // Output: Order payment processed...
        order.printStatus(); // Output: Order is currently in [PAID] state...

        order.nextState();   // Output: Order has been shipped!
        order.printStatus(); // Output: Order is currently in [SHIPPED] state.

        order.nextState();   // Output: Order is already shipped...

        return "Payment processed via " + type;
    }


}