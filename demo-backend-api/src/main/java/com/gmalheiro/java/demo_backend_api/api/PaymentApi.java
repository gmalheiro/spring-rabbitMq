package com.gmalheiro.java.demo_backend_api.api;

import com.gmalheiro.java.demo_backend_api.dto.PaymentDTO;
import com.gmalheiro.java.demo_backend_api.facade.PaymentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentApi {
    @Autowired
    private PaymentFacade paymentFacade;

    @PostMapping
    public String process (@RequestBody PaymentDTO request) {
        return  paymentFacade.requestPayment(request);
    }
}
