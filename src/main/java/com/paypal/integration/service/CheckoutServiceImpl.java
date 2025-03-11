package com.paypal.integration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.integration.api.CheckoutService;
import com.paypal.integration.common.IdUtils;
import com.paypal.integration.vo.OrderVO;
import com.paypal.sdk.PaypalServerSdkClient;
import com.paypal.sdk.controllers.OrdersController;
import com.paypal.sdk.exceptions.ApiException;
import com.paypal.sdk.http.response.ApiResponse;
import com.paypal.sdk.models.Order;
import com.paypal.sdk.models.OrderRequest;
import com.paypal.sdk.models.OrdersCreateInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class CheckoutServiceImpl implements CheckoutService {
    private final PaypalServerSdkClient client;

    public CheckoutServiceImpl(ObjectMapper objectMapper, PaypalServerSdkClient client) {
        this.client = client;
    }

    @Override
    public ResponseEntity<Order> createOrder(OrderVO orderVO) {
        try {
            Order response = this.createOrderVO(orderVO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Order> captureOrder(String orderID) {
        return null;
    }

    private Order createOrderVO(OrderVO orderVO) throws IOException, ApiException {
        // init order create request
        OrdersCreateInput ordersCreateInput = new OrdersCreateInput();
        // Request ID is preferred to be unique for debugging
        ordersCreateInput.setPaypalRequestId("REQ-ID-" + IdUtils.id32());
        ordersCreateInput.setBody(this.createOrderRequest(orderVO));

        OrdersController ordersController = client.getOrdersController();
        ApiResponse<Order> apiResponse = ordersController.ordersCreate(ordersCreateInput);
        return apiResponse.getResult();
    }

    private OrderRequest createOrderRequest(OrderVO orderVO) {
        // TODO: Try to let AI implement this mapping method
        return null;
    }
}
