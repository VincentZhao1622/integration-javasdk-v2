package com.paypal.integration.common;

public enum PaymentMethod {
    PAYPAL("PAYPAL"),
    CARD("CARD"),
    APPLE_PAY("APPLE_PAY"),
    GOOGLE_PAY("GOOGLE_PAY");

    private final String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
