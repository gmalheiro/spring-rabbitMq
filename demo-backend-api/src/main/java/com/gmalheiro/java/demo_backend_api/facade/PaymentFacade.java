package com.gmalheiro.java.demo_backend_api.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmalheiro.java.demo_backend_api.dto.PaymentDTO;
import com.gmalheiro.java.demo_backend_api.producer.PaymentRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacade {

    @Autowired
    private PaymentRequestProducer producer;

    public String requestPayment (PaymentDTO request) {
        try{
            producer.integrate(request);
        } catch (JsonProcessingException e) {
            return "There was an error requesting payment... " + e.getMessage();
        }
        return "Payment waiting confirmation";
    }

    public void paymentError(String payload) {
        System.err.println("==== ERROR RESPONSE =====" + payload);
    }

    public void paymentSuccess(String payload) {
        System.out.println("==== SUCCESS RESPONSE  =====" + payload);
    }

}
