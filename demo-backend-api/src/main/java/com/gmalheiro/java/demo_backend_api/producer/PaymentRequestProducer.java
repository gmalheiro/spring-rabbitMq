package com.gmalheiro.java.demo_backend_api.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmalheiro.java.demo_backend_api.dto.PaymentDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    //TODO: ADD INFO TO APPLICATION.PROPERTIES
    private final String exchange = "payment-request-exchange";
    private final String routingKey = "payment-request-routing-key";


    public void integrate (PaymentDTO payment) throws JsonProcessingException {
        amqpTemplate.convertAndSend(exchange,routingKey,mapper.writeValueAsString(payment));
    }

}
