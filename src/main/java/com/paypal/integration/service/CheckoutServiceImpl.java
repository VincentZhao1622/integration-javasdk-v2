package com.paypal.integration.service;

import com.paypal.integration.api.CheckoutService;
import com.paypal.integration.vo.OrderVO;
import com.paypal.sdk.models.Order;
import org.springframework.http.ResponseEntity;

public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public ResponseEntity<Order> createOrder(OrderVO orderVO) {
        return null;
    }

    @Override
    public ResponseEntity<Order> captureOrder(String orderID) {
        return null;
    }
}
